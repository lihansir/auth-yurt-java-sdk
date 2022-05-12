package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.PolicyEffect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 策略声明参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyStatementParam {

    /**
     * 资源 ARN（AuthYurt Resource Name） 例：order:1234
     */
    private String resource;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 资源操作。例：order:delete
     */
    private List<String> actions;

    private PolicyEffect effect;

}
