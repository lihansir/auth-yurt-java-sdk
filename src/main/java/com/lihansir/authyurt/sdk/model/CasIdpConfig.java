package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CAS 配置
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CasIdpConfig {

    private boolean enabled;

    /**
     * ServiceTicket 过期时间（秒）
     */
    private Long stLifetime;

}
