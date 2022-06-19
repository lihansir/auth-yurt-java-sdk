package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 密码轮换策略
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordUpdatePolicyConfig {

    private Boolean enabled;

    /**
     * 密码不可重复周期（单位/月）
     */
    private Integer differenceCycle;

    /**
     * 强制修改密码周期（单位/月）
     */
    private Integer forcedCycle;

    /**
     * 密码到期提示（单位/天）
     */
    private Integer remindCycle;

}
