package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2020-04-10 16:14:09
 * @Version 1.0
 */
@Data
public class MenuBean {
    private Integer id;   //
    private String title;   //名称
    private String url;   //路径
    private String icon;   //图标
    private Integer parentId;   //父id
    private Integer version;   //0以下代表删除，0及0以上代表版本
    private String created;   //创建人
    private Date createdTime;   //创建时间
    private String updated;   //更新人
    private Date updatedTime;   //更新时间
}
