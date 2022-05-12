package com.lihansir.authyurt.sdk.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Response Type
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum ResponseType {

    /**
     * https://tools.ietf.org/html/rfc6749#section-3.1.1
     * https://tools.ietf.org/html/rfc6749#section-4.1.1
     */
    CODE("code"),
    /**
     * "token" for requesting an access token (implicit grant) as described
     * https://tools.ietf.org/html/rfc6749#section-4.2.1
     */
    TOKEN("token"),
    /**
     * a registered extension value as described by Section 8.4.
     * https://tools.ietf.org/html/rfc6749#section-8.4
     */
    ID_TOKEN("id_token"),
    ID_TOKEN_TOKEN("id_token token"),
    CODE_ID_TOKEN("code id_token"),
    CODE_TOKEN("code token"),
    CODE_ID_TOKEN_TOKEN("code id_token token"),
    /**
     * https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html#none
     */
    NONE("none");

    private final String type;

    ResponseType(String type) {
        this.type = type;
    }

    public static List<String> responseTypes() {
        return Arrays.stream(ResponseType.values())
                .map(ResponseType::getType)
                .collect(Collectors.toList());
    }

    public String getType() {
        return type;
    }

}
