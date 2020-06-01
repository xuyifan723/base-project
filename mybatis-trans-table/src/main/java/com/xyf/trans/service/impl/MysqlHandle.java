package com.xyf.trans.service.impl;

import com.xyf.trans.service.DatabaseHandle;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

/**
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
@Service("mysql")
public class MysqlHandle implements DatabaseHandle {
    private  Document document;
}
