package com.lihansir.authyurt.sdk.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClientSecretAuthMethod
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum ClientSecretAuthMethod {

    /**
     * Post parameter
     */
    CLIENT_SECRET_POST,
    /**
     * The basic format string in the request header
     */
    CLIENT_SECRET_BASIC,
    /**
     * url
     */
    NONE,
    /**
     * All of the above support
     */
    ALL;

    public static List<String> getAllMethods() {
        return Arrays.stream(ClientSecretAuthMethod.values()).filter((method) -> method != ALL)
            .map((method) -> method.name().toLowerCase()).collect(Collectors.toList());
    }

    public String getMethod() {
        return this.name().toLowerCase();
    }

}
