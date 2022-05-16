## 认证客户端 AuthenticationClient

### 用户名密码登录

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.loginByUsername(new LoginByUsernameParam("test", "test"));
```

### LDAP 登录

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.loginByLdap(new LoginByLdapParam("test", "test"));
```

### 邮箱密码登录

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.LoginByEmailParam(new LoginByEmailParam("test@lihansir.com", "test"));
```

### 邮箱验证码登录

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.loginByEmailCode(new LoginByEmailCodeParam("test@lihansir.com", "1234"));
```

### 手机号验证码登录

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.loginByPhoneCode(new LoginByPhoneCodeParam("13188888888", "1234"));
```

### 手机号密码登录

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.loginByPhonePassword(new LoginByPhonePasswordParam("13188888888", "test"));
```

### 用户名注册

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.registerByUsername(new RegisterByUsernameParam("test", "test"));
```

### 邮箱注册

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.registerByEmail(new RegisterByEmailParam("test@lihansir.com", "test"));
```

### 手机号注册

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
AuthenticationResult authenticationResult = authenticationClient.registerByPhone(new RegisterByPhoneParam("13188888888", "test", "1234"));
```

### 发送验证码

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
authenticationClient.sendCaptcha("13188888888", VerificationCodePlatform.PHONE, VerificationCodeType.LOGIN);
```

### 生成 OIDC 授权链接

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
String authorizationUrl = authenticationClient.generateOidcAuthorizationUrl("profile", ResponseType.CODE, "http://127.0.0.1:8080", "state", "nonce");
```

### 授权码换取 token

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
authenticationClient.setSecret("APPLICATION_SECRET");
AccessToken accessToken = authenticationClientoidcCodeToToken("code", "http://127.0.0.1:8080");
```

### 刷新 token

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
authenticationClient.setSecret("APPLICATION_SECRET");
AccessToken accessToken = authenticationClient.oidcRefreshToken("refreshToken", "profile");
```

### token 自省

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
authenticationClient.setSecret("APPLICATION_SECRET");
boolean active = authenticationClient.oidcIntrospectionToken("access_token");
```

### 撤销 token

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
authenticationClient.setSecret("APPLICATION_SECRET");
authenticationClient.oidcRevokeToken("access_token");
```

### token 获取用户信息

```java
AuthenticationClient authenticationClient = new AuthenticationClient();
authenticationClient.setUserPoolId("USER_POOL_ID");
authenticationClient.setApplicationId("APPLICATION_ID");
authenticationClient.setSecret("APPLICATION_SECRET");
User user = authenticationClient.oidcUserInfo("access_token");
```