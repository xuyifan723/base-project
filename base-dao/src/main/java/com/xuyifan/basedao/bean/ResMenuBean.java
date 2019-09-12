package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2019-09-12 16:26:56
 * @Version 1.0
 */
@Data
public class ResMenuBean {
    private String created;   //
    private Date createdTime;   //创建时间
    private Integer id;   //
    private Integer level;   //
    private String name;   //目录名称
    private Integer parentId;   //
    private String updated;   //
    private Date updatedTime;   //
    private String url;   //
    private Integer version;   //0以下代表删除，0及0以上代表版本
}
