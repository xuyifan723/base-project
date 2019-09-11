package com.xuyifan.commonutils.generator.temp;

import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;

import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/6 14:10
 * @Version 1.0
 */
public class ControllerTemp extends Temp {
    public ControllerTemp(TableName tableName, List<TableColumn> columns) {
        super(tableName, columns);
    }

    @Override
    public void handle() {

    }
}
