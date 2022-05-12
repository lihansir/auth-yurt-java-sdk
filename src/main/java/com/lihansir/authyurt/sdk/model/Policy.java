package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 策略
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    /**
     * 策略 ID
     */
    private String id;

    /**
     * 用户池 ID
     */
    private String userPoolId;

    /**
     * 系统为系统自己创建的权限
     */
    private Boolean systemDefault;

    /**
     * 是否是自动创建的权限
     */
    private Boolean autoCreate;

    /**
     * 是否隐藏、设置为 true 的策略在列表接口不会返回给用户
     * 仅用户维护系统内置逻辑，如应用登录策略
     */
    private Boolean hidden;

    private String code;

    private String description;

    private String namespaceId;

    public Long gmtCreate;

    public Long gmtModified;

}
