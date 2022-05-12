package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.ApplicationPermissionStrategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 应用授权配置
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationPermissionStrategyConfig {

    /**
     * 应用授权默认策略，允许所有（ALLOW_ALL）或者拒绝所有（DENY_ALL）
     */
    private ApplicationPermissionStrategy defaultStrategy;

    private String allowPolicyId;

    private String denyPolicyId;

}
