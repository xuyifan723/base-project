package com.xuyifan.commonutils.common;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.xuyifan.commonutils.exception.BizException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 阿里的数据导入和导出
 *
 * @version 1.0
 * @author: Xu yifan
 * @date: 2020/1/7 0007 13:18
 */
public class ExcelUtils {
    public static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 拿取模版文件进行下载
     *
     * @param response
     * @param fileName     导出的文件名称
     * @param tempFileName 模版文件 在resouces的excelFile文件下面
     * @param data         导出的数据，为模版对象在excelvo的包下
     * @param tClass       导出数据的class
     * @param <T>          泛型
     */
    public static <T> void writerTemp(HttpServletResponse response, String fileName, String tempFileName, List<T> data, Class<T> tClass) {
        //String tempName = GetResource.class.getClassLoader().getResource("excelFile" + File.separator + tempFileName + ".xlsx").getPath();


        try {
            String projectPath = System.getProperty("user.dir");
            File sourceFile = new File(projectPath +  File.separator +"yue-juan-business-exam"+  File.separator +"exam-impl"+  File.separator +"src"+  File.separator +"main"+  File.separator +"resources"+  File.separator +"excelFile"+  File.separator + tempFileName+".xlsx");
            String tempName = sourceFile.getPath();
            ExcelUtils.logger.info(tempName);





            ServletOutputStream outputStream = response.getOutputStream();
            setExportConfig(response, fileName);
            EasyExcel.write(outputStream, tClass).registerWriteHandler(getStyle()).withTemplate(tempName).sheet().needHead(false).doWrite(data);
        } catch (IOException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 设置response的一些配置
     *
     * @param response
     * @param fileName
     * @throws UnsupportedEncodingException
     */
    public static void setExportConfig(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
        response.setContentType("application/msexcel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fn = URLEncoder.encode(fileName + ".xlsx", "utf-8");
        fn=fn.replaceAll("\\+", "%20");

        response.addHeader("filename", fn);
        response.addHeader("Content-Disposition", "attachment;fileName=" + fn);
        response.addHeader("Access-Control-Expose-Headers", "filename");
    }

    public static HorizontalCellStyleStrategy getStyle(){
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short)16);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        contentWriteFont.setFontHeightInPoints((short)13);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        //设置边框格式
        BorderStyle borderStyle = BorderStyle.THIN;
        contentWriteCellStyle.setBorderBottom(borderStyle);
        contentWriteCellStyle.setBorderLeft(borderStyle);
        contentWriteCellStyle.setBorderRight(borderStyle);
        contentWriteCellStyle.setBorderTop(borderStyle);
        //水平居中
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        return horizontalCellStyleStrategy;
    }

    /**
     * 通过model导出数据
     *
     * @param response
     * @param fileName
     * @param data
     * @param tClass
     * @param <T>
     */
    public static <T> void writerModel(HttpServletResponse response, String fileName, List<T> data, Class<T> tClass) {
        try {
            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            setExportConfig(response, fileName);
            EasyExcel.write(response.getOutputStream(), tClass).registerWriteHandler(getStyle()).sheet(fileName).doWrite(data);
        } catch (IOException e) {
            throw new BizException("导出模版出错");
        }
    }

    /**
     * 没有model的导入
     * @param excelFile
     * @return
     */
    public static List<Map<Integer, String>> noModelReader(MultipartFile excelFile, Integer headRow) {
        try {
            NoModleDataListener noModleDataListener = new NoModleDataListener();
            EasyExcel.read(excelFile.getInputStream(), noModleDataListener).headRowNumber(headRow).sheet().doRead();
            List<Map<Integer, String>> data = noModleDataListener.data;
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * model的导入
     * @param excelFile
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> List<T> modelReader(MultipartFile excelFile, Class<T> tClass, ModelListener modelListener, Integer headRow) {
        try {
            if (!excelFile.getOriginalFilename().toUpperCase().endsWith("XLSX")){
                throw new BizException("上传文件有问题");
            }
            EasyExcel.read(excelFile.getInputStream(),tClass,modelListener ).headRowNumber(headRow).sheet().doRead();
            List<T> data = modelListener.getList();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static  class  ModleDataListener<T> extends AnalysisEventListener<T> {
        List<T> data = new ArrayList();
        @Override
        public void invoke(Object item, AnalysisContext analysisContext) {
            T cellData = (T) item;
            data.add(cellData);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        }
    }


    /**
     * 直接用map接收数据
     *
     * @author Jiaju Zhuang
     */
    public static class NoModleDataListener extends AnalysisEventListener<Map<Integer, String>> {
        /**
         * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
         */
        private static final int BATCH_COUNT = 5;
        List<Map<Integer, String>> data = new ArrayList<Map<Integer, String>>();


        @Override
        public void invoke(Map<Integer, String> item, AnalysisContext analysisContext) {

            data.add(item);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        }
    }


    public static void main(String[] args) {
        String url = "E:\\tmp\\20191226普通.xlsx";
        File file = new File(url);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            NoModleDataListener noModleDataListener = new NoModleDataListener();
            EasyExcel.read(fileInputStream, noModleDataListener).sheet().doRead();
            List<Map<Integer, String>> data = noModleDataListener.data;
            System.out.println(data.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
