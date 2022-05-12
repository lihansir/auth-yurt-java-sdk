package com.lihansir.authyurt.sdk.enums;

/**
 * IdToken 签名算法
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public enum IdTokenSignerEnum {

    /**
     * 非对称加密。使用私钥加密，需要使用公钥解密
     */
    HS256,

    /**
     * hash 对称加密。使用应用密钥加密，需要使用应用密钥解密
     */
    RS256

}
