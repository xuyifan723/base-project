package com.xuyifan.commonutils.generator.temp;

import com.xuyifan.commonutils.generator.bean.TableColumn;
import com.xuyifan.commonutils.generator.bean.TableName;

import java.util.List;

/**
 * @author Xu yifan
 * @Ddecription 待写
 * @date 2019/9/11 11:43
 * @Version 1.0
 */
public class MapperFileTemp extends Temp{
    private String fileSuffix="Mapper.xml";
    private String tempName="controllerTemp.txt";
    public MapperFileTemp(TableName tableName, List<TableColumn> columns) {
        super(tableName, columns);
    }

    @Override
    public void handle() {

    }
}
