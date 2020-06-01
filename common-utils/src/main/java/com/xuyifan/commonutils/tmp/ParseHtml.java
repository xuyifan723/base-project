package com.xuyifan.commonutils.tmp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: xuyifan
 * @Date: 2020/5/27
 */
public class ParseHtml {
    public static void main(String[] args) {
        String baseUrl="D:\\\\OAfile\\\\发文\\\\2020\\\\5\\\\27\\\\个人疼";
        String urlHtml=baseUrl+"\\个人疼-审批稿纸信息-公司发文通用〔2020〕6号.html";
       // String urlStr="http://localhost:8080/ekp/km/imissive/km_imissive_archive/kmImissiveArchive1.do?method=print&fdId=1725510e23321a2ebcb1ef34f4eb2339c";
        try {
           // URL url = new URL(urlStr);
            File input = new File(urlHtml);
            Document docHtml = Jsoup.parse(input,"UTF-8");
            Elements els = docHtml.select("img[src]");
            for (Element el : els) {
                String href = el.attr("src");
                el.val();
                System.out.println(href);
                int i = href.lastIndexOf("fdId=");
                String substring = href.substring(i+5, href.length());
                String imgGetURL="http://localhost:8080"+href;
               URL imgUrl=new URL(imgGetURL);
                HttpURLConnection conn = (HttpURLConnection) imgUrl
                        .openConnection();
                conn.setRequestMethod("GET");
                InputStream in = conn.getInputStream();

                File f1 = new File(baseUrl + "\\" + substring+".jpg");
                if (!f1.exists()) {
                    f1.getParentFile().mkdirs();
                }
                BufferedInputStream bin = new BufferedInputStream(in);
                FileOutputStream fos = new FileOutputStream(f1);
                BufferedOutputStream bout = new BufferedOutputStream(fos);
                // 准备长度是5*1024的字节数组，
                byte[] bytes = new byte[1024 * 5];
                while (bin.read(bytes) != -1) {
                    bout.write(bytes);
                }
                el.val(substring+".jpg");
                bout.flush();
                bout.close();
                fos.close();
                bin.close();
                in.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
