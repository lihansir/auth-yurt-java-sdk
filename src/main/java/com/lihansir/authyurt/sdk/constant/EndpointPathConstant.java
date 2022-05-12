package com.lihansir.authyurt.sdk.constant;

/**
 * 端点常量定义
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class EndpointPathConstant {

  public static final String LOGIN = "/login";
  
  public static final String AUTHORIZE = "/oidc/authorize";
  
  public static final String AUTHORIZE_AUTO_APPROVE = "/oidc/authorize/auto";
  
  public static final String TOKEN = "/oidc/token";
  
  public static final String REVOKE_TOKEN = "/oidc/token/revocation";
  
  public static final String INTROSPECTION_TOKEN = "/oidc/token/introspection";
  
  public static final String USER_INFO = "/oidc/userinfo";
  
  public static final String END_SESSION = "/logout";
  
  public static final String JWKS = "/oidc/.well-known/jwks.json";
  
  public static final String DISCOVERY = "/oidc/.well-known/openid-configuration";
  
  public static final String CONFIRM_PAGE = "/oidc/confirm";

}