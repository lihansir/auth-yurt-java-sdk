package com.lihansir.authyurt.sdk.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * oauth grant type
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum GrantType {

    /**
     * Authorization code grant
     *
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-1.3.1" target="_blank">RFC 6749 (OAuth 2.0), 1.3.1.
     *      Authorization Code</a>
     * @see <a href="http://tools.ietf.org/html/rfc6749#section-4.1.3" target="_blank">RFC 6749 (OAuth 2.0), 4.1.3.
     *      Access Token Request</a>
     * @see <a href="http://openid.net/specs/openid-connect-core-1_0.html#TokenEndpoint" target="_blank">OpenID Connect
     *      Core 1.0, 3.1.3. Token Endpoint</a>
     */
    AUTHORIZATION_CODE("authorization_code"),
    /**
     * The implicit grant is a simplified authorization code flow optimized for clients implemented in a browser using a
     * scripting language such as JavaScript.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-1.3.2" target="_blank">RFC 6749 (OAuth 2.0), 1.3.2.
     *      Implicit</a>
     */
    IMPLICIT("implicit"),
    /**
     * The resource owner password credentials (i.e., username and password) can be used directly as an authorization
     * grant to obtain an access token. The credentials should only be used when there is a <strong>high degree of trust
     * between the resource owner and the client</strong> (e.g., the client is part of the device operating system or a
     * highly privileged application), and when other authorization grant types are <strong>not available</strong> (such
     * as an authorization code).
     *
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-1.3.3" target="_blank">RFC 6749 (OAuth 2.0), 1.3.3.
     *      Resource Owner Password Credentials</a>
     * @see <a href="http://tools.ietf.org/html/rfc6749#section-4.3.2" target="_blank">RFC 6749 (OAuth 2.0), 4.3.2.
     *      Access Token Request</a>
     */
    PASSWORD("password"),
    /**
     * Client Credentials grant
     *
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-1.3.4" target="_blank">RFC 6749 (OAuth 2.0), 1.3.4.
     *      Client Credentials</a>
     * @see <a href="http://tools.ietf.org/html/rfc6749#section-4.4.2" target="_blank">RFC 6749 (OAuth 2.0), 4.4.2.
     *      Access Token Request</a>
     */
    CLIENT_CREDENTIALS("client_credentials"),
    /**
     * The grant type used when refreshing the token
     *
     * @see <a href="http://tools.ietf.org/html/rfc6749#section-6" target="_blank">RFC 6749 (OAuth 2.0), 6. Refreshing
     *      an Access Token</a>
     * @see <a href="http://openid.net/specs/openid-connect-core-1_0.html#RefreshTokens" target="_blank">OpenID Connect
     *      Core 1.0, 12. Using Refresh Tokens</a>
     */
    REFRESH_TOKEN("refresh_token"),
    /**
     * The grant type used when obtaining the access token
     */
    TOKEN("token"),

    OFFLINE_ACCESS("offline_access");

    private final String type;

    GrantType(String type) {
        this.type = type;
    }

    public static List<String> grantTypes() {
        return Arrays.stream(GrantType.values()).map(GrantType::getType).collect(Collectors.toList());
    }

    public String getType() {
        return type;
    }

}
