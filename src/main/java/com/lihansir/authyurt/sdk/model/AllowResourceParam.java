package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import lombok.Data;

/**
 * 允许操作资源参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class AllowResourceParam {

    /**
     * 资源 ARN（AuthYurt Resource Name） 例：order:1234
     */
    private String resource;

    /**
     * 资源操作。例：order:delete
     */
    private String action;

    private PolicyAssignmentTargetType targetType;

    /**
     * 授予目标 ID
     * 当 targetType 为 USER 和 ORG 时，targetId 为用户 ID 和机构节点 ID；
     * 当 targetType 为 ROLE 时，targetId 为角色 code，并且同时需要补充 namespaceCode；
     * 当 targetType 为 GROUP 时，targetId 为用户分组 code
     */
    private String targetId;

    private String namespaceCode;

    public AllowResourceParam(String resource, String action, PolicyAssignmentTargetType targetType, String targetId) {
        this.resource = resource;
        this.action = action;
        this.targetType = targetType;
        this.targetId = targetId;
    }

}
