package com.xyf.trans.enums;

/** 数据库字段类型
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
public enum SqlType {
    //      ------------日期类型--------------
    //日期值  YYYY-MM-DD   例如：1000-01-01/9999-12-31
    DATE,
    //时间值或持续时间  HH:MM:SS 例如：'-838:59:59'/'838:59:59'
    TIME,
    //年份值  YYYY  例如：1901/2155
    YEAR,
    //混合日期和时间值   YYYY-MM-DD HH:MM:SS  例如：1000-01-01 00:00:00/9999-12-31 23:59:59
    DATETIME,
    //混合日期和时间值，时间戳  YYYYMMDD HHMMSS  例如：1970-01-01 00:00:00/2038
    TIMESTAMP,
    //       ----------字符串类型----------------
    //0-255字节	定长字符串
    CHAR,
    //0-65535 字节	变长字符串
    VARCHAR,
    //0-255字节	不超过 255 个字符的二进制字符串
    TINYBLOB,
    //0-255字节	短文本字符串
    TINYTEXT,
    //0-65 535字节	二进制形式的长文本数据
    BLOB,
    //0-65 535字节	长文本数据
    TEXT,
    //0-16 777 215字节	二进制形式的中等长度文本数据
    MEDIUMBLOB,
    //0-16 777 215字节	中等长度文本数据
    MEDIUMTEXT,
    //0-4 294 967 295字节	二进制形式的极大文本数据
    LONGBLOB,
    //0-4 294 967 295字节	极大文本数据
    LONGTEXT,
    //        ---------数值类型---------
    // (0，255)小整数值
    TINYINT,
    //(0，65 535)	大整数值
    SMALLINT,
    //(0，16 777 215)	大整数值
    MEDIUMINT,
    //(0，4 294 967 295)	大整数值
    INT或INTEGER,
    //(0，18 446 744 073 709 551 615)	极大整数值
    BIGINT,
    //单精度浮点数值
    FLOAT,
   //双精度浮点数值
    DOUBLE;
}
