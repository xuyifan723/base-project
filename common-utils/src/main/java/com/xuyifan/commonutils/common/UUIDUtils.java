package com.xuyifan.commonutils.common;

import java.util.UUID;

/**
 * @Author: xuyifan
 * @Date: 2020/5/6
 */
public class UUIDUtils {
    public static String getLowString(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String idStr = str.replaceAll("-", "");
        return idStr;
    }

    public static void main(String[] args) {
        String upString = UUIDUtils.getLowString();
        System.out.println(upString);
    }
}
