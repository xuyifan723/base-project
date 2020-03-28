package com.xuyifan.basedao.bean;
import lombok.Data;
import java.util.Date;
/**
 * @author Xu yifan
 * @Ddecription 
 * @date 2020-03-28 14:59:27
 * @Version 1.0
 */
@Data
public class ResourcePermissionBean {
    private Integer id;   //
    private String operatorType;   //用户类型
    private Integer operatorId;   //用户id
    private String resourceType;   //资源类型
    private Integer resourceId;   //资源id
    private String permissionType;   //允许操作类型
    private Integer permissionAction;   //0代表不允许，1代表允许
    private Integer version;   //0以下代表删除，0及0以上代表版本
    private String created;   //创建人
    private Date createdTime;   //创建时间
    private String updated;   //更新人
    private Date updatedTime;   //更新时间
}
