package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {

    /**
     * Total data
     */
    private float total;

    /**
     * Current page number
     */
    private int currentPage;

    /**
     * Current number of items per page
     */
    private int pageSize;

    /**
     * PageCount
     */
    private int totalPage;

    /**
     * data
     */
    private List<T> data;

}
