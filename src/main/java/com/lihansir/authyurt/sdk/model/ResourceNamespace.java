package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 权限组
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class ResourceNamespace {

    /**
     * 唯一 ID
     */
    private String id;

    /**
     * 用户池 ID
     */
    private String userPoolId;

    /**
     * 权限组名称
     */
    private String name;

    /**
     * 权限组 code
     */
    private String code;

    /**
     * 描述
     */
    private String description;

    /**
     * 绑定应用 ID
     */
    private String applicationId;

    /**
     * 是否是集成应用生成的权限分组
     */
    private Boolean integrateApplication;

    /**
     * 是否是用户池默认应用生成的权限分组
     */
    private Boolean defaultApplication;

    public Long gmtCreate;

    public Long gmtModified;

}
