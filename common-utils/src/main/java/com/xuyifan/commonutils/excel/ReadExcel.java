package com.xuyifan.commonutils.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcel {
    private static final String SUFFIX_2003 = "xls";
    private static final String SUFFIX_2007 = "xlsx";
    private Integer excelNum=0; //文件列数量
    private boolean headerDataFlag=false;//读取的数据是否保留表头数据
    private List<List<String>> data=new ArrayList<>(); //数据
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象

    /**
     * 读取excel文件去掉表头数据
     * @param fis     文件流
     * @param fileType    文件类型
     * @param flag        判断是否有表头，每个sheet必须一样 默认为没有
     * @param colnum      文件列数，如果没有表头必须填写
     * @return
     */
    public List<List<String>> readExcel(InputStream fis,String fileType,boolean flag,Integer colnum) {
        try {
            Workbook workbook = null;
            if (colnum!=null){
                excelNum=colnum;
            }
            headerDataFlag=flag;
            if (SUFFIX_2003.equals(fileType)) {
                workbook = new HSSFWorkbook(fis);
            } else if (SUFFIX_2007.equals(fileType)) {
                workbook = new XSSFWorkbook(fis);
            }
            int numOfSheet = workbook.getNumberOfSheets();
            for (int i = 0; i < numOfSheet; ++i) {
                Sheet sheet = workbook.getSheetAt(i);
                parseSheet(sheet, data);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析每个sheet上的数据
     * @param sheet
     * @param data
     */
    private void parseSheet(Sheet sheet, List<List<String>> data) {
        Row row;
        int count = 0;
        //利用迭代器，取出每一个Row
        Iterator<Row> iterator = sheet.iterator();
        while(iterator.hasNext()) {
            row = iterator.next();

            //由于第一行是标题，因此这里单独处理
            if (count == 0) {
               List<String> header = new ArrayList<>();
                header = parseHeaderRow(row);
               if (headerDataFlag){
                 excelNum=header.size();
               }else {
                  data.add(header);
               }
            } else {
                //其它行都在这里处理
                parseRow(row);
            }
            count++;
        }
    }


    /**
     * 解析表头
     * @param row
     * @return
     */
    private List<String> parseHeaderRow(Row row) {
        List<String> rst = new ArrayList<>();
        //利用迭代器得到每一个cell
        for (Cell cell : row) {
            cell.setCellType(CellType.STRING);
            //取出cell中的value
            rst.add(cell.getStringCellValue());
        }
        return rst;
    }

    /**
     * 解析表格数据
     * @param row
     * @return
     */
    private List<String> parseRow(Row row) {
        List<String> rst = new ArrayList<>();
        for (int i=0;i<row.getFirstCellNum();i++){
            rst.add("");
        }
        for (Cell cell : row) {
            cell.setCellType(CellType.STRING);
            String value=cell.getStringCellValue();
            if (value==null){
                value="";
            }
            //取出cell中的value
            rst.add(value);
        }
        for (int i=row.getLastCellNum();i<excelNum;i++){
            rst.add("");
        }
        return rst;
    }


    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,4,32};
        for (int j=arr.length-1;j>0;j--){
            if (arr[j]==arr[j-1]){
                System.out.print(arr[j]+",");
            }
        }


    }
}