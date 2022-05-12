package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 修改权限组参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class UpdateResourceNamespaceParam {

    private String name;

    private String code;

    private String description;

}
