package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 策略授权结果封装对象
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyAssignmentResult {

    private String policyId;

    private String code;

    private PolicyDetail policyDetail;

    private ResourceNamespace namespace;

    private PolicyAssignmentTargetType targetType;

    private Object target;

    private List<Object> targets;

    private Boolean enabled;

    /**
     * 子节点继承
     */
    private Boolean inherit;

    private Boolean external;

    private ResourceNamespace targetNamespace;

    private Long gmtCreate;

}
