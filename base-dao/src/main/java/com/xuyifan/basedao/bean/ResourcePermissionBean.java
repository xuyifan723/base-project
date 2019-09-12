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
public class ResourcePermissionBean {
    private String created;   //
    private Date createdTime;   //创建时间
    private Integer id;   //
    private Integer operatorId;   //用户id
    private String operatorType;   //用户类型
    private Integer permissionAction;   //0代表不允许，1代表允许
    private String permissionType;   //允许操作类型
    private Integer resourceId;   //资源id
    private String resourceType;   //资源类型
    private String updated;   //
    private Date updatedTime;   //
    private Integer version;   //0以下代表删除，0及0以上代表版本
}
