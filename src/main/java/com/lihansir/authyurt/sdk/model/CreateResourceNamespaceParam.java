package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 创建权限组参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class CreateResourceNamespaceParam {

    private String code;

    private String name;

    private String description;

    public CreateResourceNamespaceParam(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
