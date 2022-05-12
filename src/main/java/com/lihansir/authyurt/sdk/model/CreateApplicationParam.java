package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 创建应用参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class CreateApplicationParam {

    /**
     * 应用名称
     */
    private String name;

    /**
     * 应用标识符（末级域名）
     */
    private String identifier;

    public CreateApplicationParam(String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
    }

}
