package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 策略详情
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDetail {

    private Policy policy;

    private List<PolicyStatement> statements;

}
