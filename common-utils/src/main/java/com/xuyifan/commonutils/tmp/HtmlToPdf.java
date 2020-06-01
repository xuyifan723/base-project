package com.xuyifan.commonutils.tmp;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Author: xuyifan
 * @Date: 2020/5/27
 */
public class HtmlToPdf {
    public  void tomPdf(String html, String DEST) throws Exception {
        ConverterProperties props = new ConverterProperties();
        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
        defaultFontProvider.addFont("D:\\OAfile\\微软vista雅黑.ttf");
        props.setFontProvider(defaultFontProvider);
        File file1 = new File(DEST);
      if (!file1.exists()){
          file1.getParentFile().mkdirs();
      }
        PdfWriter writer = new PdfWriter(DEST);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(new PageSize(595.0F, 842.0F));
        Document document = HtmlConverter.convertToDocument(new FileInputStream(html), pdf, props);
        document.close();
        pdf.close();
    }

    public static void main(String[] args) {
        HtmlToPdf htmlToPdf=new HtmlToPdf();
        String basePath="D:\\OAfile";
        try {
            htmlToPdf.tomPdf(basePath+"\\发文\\2020-5-27\\个人疼\\个人疼-审批稿纸信息-公司发文通用〔2020〕6号.html",basePath+"\\发文\\2020-5-27\\个人疼\\test.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
