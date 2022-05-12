package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.RoleAssignmentTargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色信息
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleInfo {

    private String id;

    private String userPoolId;

    private String code;

    private String description;

    private Boolean isSystem;

    /**
     * 继承自哪个资源（目前只有 GROUP 和 ORG）
     */
    private RoleAssignmentTargetType inherit;

    private String namespaceId;

    private String namespaceCode;

    private String namespaceName;

    public Long gmtCreate;

    public Long gmtModified;

}
