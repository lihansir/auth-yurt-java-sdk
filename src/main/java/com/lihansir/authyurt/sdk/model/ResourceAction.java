package com.lihansir.authyurt.sdk.model;

import lombok.Data;

/**
 * 资源操作
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class ResourceAction {

    /**
     * 操作名称。格式为： 资源名称:操作名称。例：order:read
     */
    private String name;

    private String description;

    public ResourceAction(String name) {
        this.name = name;
    }

}
