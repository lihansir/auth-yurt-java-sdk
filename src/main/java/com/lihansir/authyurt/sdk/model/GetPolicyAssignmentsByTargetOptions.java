package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 根据授权目标获取策略授权信息可选项
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPolicyAssignmentsByTargetOptions {

    /**
     * 授权目标类型（可为空，为空查询全部）
     */
    private PolicyAssignmentTargetType targetType;

    /**
     * 权限组 code（可为空）
     */
    private String namespaceCode;

}
