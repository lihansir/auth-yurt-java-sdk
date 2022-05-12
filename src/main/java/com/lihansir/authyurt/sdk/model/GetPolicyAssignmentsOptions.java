package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取策略授权信息可选项
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPolicyAssignmentsOptions {

    /**
     * 策略 code
     */
    private String code;

    /**
     * 策略授权目标类型
     */
    private PolicyAssignmentTargetType targetType;

    /**
     * 策略授权目标 ID
     * 当 targetType 为 USER 和 ORG 时，targetId 为用户 ID 和机构节点 ID；
     * 当 targetType 为 ROLE 时，targetId 为角色 code，并且同时需要补充 options 中的 namespaceCode；
     * 当 targetType 为 GROUP 时，targetId 为用户分组 code
     */
    private String targetId;

    /**
     * 权限组 code
     */
    private String namespaceCode;

    private int currentPage = 1;

    private int pageSize = 10;

}
