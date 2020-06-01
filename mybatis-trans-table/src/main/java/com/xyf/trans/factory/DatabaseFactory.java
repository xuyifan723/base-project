package com.xyf.trans.factory;

import com.xyf.trans.enums.DatabaseType;
import com.xyf.trans.service.DatabaseHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xuyifan
 * @Date: 2020/6/1
 */
@Component
public class DatabaseFactory {
    @Autowired
    public Map<String, DatabaseHandle> quesContext = new ConcurrentHashMap<>();

    public DatabaseHandle getDataViewClass(DatabaseType databaseType) {
        DatabaseHandle databaseHandle = this.quesContext.get(databaseType.getName());
        return databaseHandle;
    }
}
