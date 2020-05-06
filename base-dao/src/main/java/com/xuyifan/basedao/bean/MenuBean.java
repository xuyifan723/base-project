package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2020-05-06 17:40:22
 * @Version 1.0
 */
@Data
public class MenuBean {
    private String id;   //
    private String title;   //
    private String url;   //
    private String icon;   //
    private String parentId;   //
    private Integer version;   //
    private String created;   //
    private Date createdTime;   //
    private String updated;   //
    private Date updatedTime;   //
}
