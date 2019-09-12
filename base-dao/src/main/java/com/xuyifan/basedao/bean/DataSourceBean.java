package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 数据源
 * @date 2019-09-12 16:26:56
 * @Version 1.0
 */
@Data
public class DataSourceBean {
    private String created;   //创建人
    private Date createdTime;   //创建时间
    private String driverName;   //数据库驱动
    private Integer id;   //
    private String name;   //数据源名称
    private String password;   //密码
    private String updated;   //更新人
    private Date updatedTime;   //更新时间
    private String url;   //数据url
    private Integer username;   //数据源用户名
    private Integer version;   //0以下代表删除，0及0以上代表版本
}
