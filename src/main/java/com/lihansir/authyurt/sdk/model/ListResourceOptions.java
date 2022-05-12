package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.ResourceType;
import lombok.Data;

/**
 * 资源列表可选项
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
public class ListResourceOptions {

    /**
     * 资源类型（为空返回全部类型的资源）
     */
    private ResourceType type;

    private int currentPage = 1;

    private int pageSize = 10;

}
