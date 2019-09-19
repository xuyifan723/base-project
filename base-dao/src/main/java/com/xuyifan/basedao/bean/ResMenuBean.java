package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2019-09-19 08:44:48
 * @Version 1.0
 */
@Data
public class ResMenuBean {
    private Integer id;   //
    private String name;   //目录名称
    private String url;   //
    private Integer level;   //
    private Integer parentId;   //
    private Integer version;   //0以下代表删除，0及0以上代表版本
    private String created;   //
    private Date createdTime;   //创建时间
    private String updated;   //
    private Date updatedTime;   //
}
