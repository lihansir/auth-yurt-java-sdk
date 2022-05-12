package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 创建分组参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class CreateGroupParam {

    /**
     * 分组 code
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 外部分组 ID
     */
    private String externalId;

    public CreateGroupParam(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
