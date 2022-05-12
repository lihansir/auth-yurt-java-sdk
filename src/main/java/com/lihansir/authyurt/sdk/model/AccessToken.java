package com.lihansir.authyurt.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AccessToken
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {

    private String accessToken;

    private String refreshToken;

    private String idToken;

    private String scope;

    private String tokenType;

    private Long expiresIn;

}
