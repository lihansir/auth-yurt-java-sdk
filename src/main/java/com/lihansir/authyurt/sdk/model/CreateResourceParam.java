package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.ResourceType;
import lombok.Data;

import java.util.List;

/**
 * 创建资源参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class CreateResourceParam {

    /**
     * 资源名称
     */
    private String code;

    /**
     * 资源类型
     */
    private ResourceType type;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 资源操作
     */
    private List<ResourceAction> actions;

    /**
     * 资源命名空间
     */
    private String namespaceCode;

    /**
     * API URL（当 type 为 api 时使用）
     */
    private String apiIdentifier;

    public CreateResourceParam(String code, ResourceType type) {
        this.code = code;
        this.type = type;
    }

}
