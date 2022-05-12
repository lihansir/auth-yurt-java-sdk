package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.PolicyAssignmentTargetType;
import lombok.Data;

/**
 * 获取应用授权列表可选项
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class ApplicationAuthorizationAssignmentsOptions {

    /**
     * 目标类型（为空查全部）
     */
    private PolicyAssignmentTargetType targetType;

    private int currentPage = 1;

    private int pageSize = 10;

}
