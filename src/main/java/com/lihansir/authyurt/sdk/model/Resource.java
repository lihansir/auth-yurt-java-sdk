package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 资源
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    /**
     * 唯一 ID
     */
    private String id;

    /**
     * 用户池 ID
     */
    private String userPoolId;

    /**
     * 资源名称。例：order
     */
    private String code;

    /**
     * 资源操作
     */
    private List<ResourceAction> actions;

    /**
     * 资源类型 data、api、menu、button
     */
    private String type;

    /**
     * 资源描述
     */
    private String description;

    /**
     * API URL（当 type 为 api 时使用）
     */
    private String apiIdentifier;

    /**
     * 权限组 ID
     */
    private String namespaceId;

    public Long gmtCreate;

    public Long gmtModified;

}
