package com.lihansir.authyurt.sdk.authentication;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.enums.ResponseType;
import com.lihansir.authyurt.sdk.enums.VerificationCodePlatform;
import com.lihansir.authyurt.sdk.enums.VerificationCodeType;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.modules.authentication.AuthenticationClient;
import org.junit.Before;
import org.junit.Test;

/**
 * 认证客户端测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class AuthenticationClientTest {

    private AuthenticationClient authenticationClient;

    @Before
    public void before() {
        this.authenticationClient = new AuthenticationClient();
        this.authenticationClient.setUserPoolId(TestCommonConstant.TEST_USER_POOL_ID);
        this.authenticationClient.setApplicationId(TestCommonConstant.TEST_APPLICATION_ID);
        this.authenticationClient.setSecret(TestCommonConstant.TEST_APPLICATION_SECRET);
    }

    @Test
    public void loginByAccount() {
        AuthenticationResult authenticationResult = this.authenticationClient.loginByAccount(new LoginByAccountParam("test", "test"));
        Assert.notBlank(authenticationResult.getAccessToken());
    }

    @Test
    public void loginByLdap() {
        AuthenticationResult authenticationResult = this.authenticationClient.loginByLdap(new LoginByLdapParam("test", "test"));
        Assert.notBlank(authenticationResult.getAccessToken());
    }

    @Test
    public void loginByEmailCode() {
        AuthenticationResult authenticationResult = this.authenticationClient.loginByEmailCode(
                new LoginByEmailCodeParam("test@lihansir.com", "1234"));
        Assert.notBlank(authenticationResult.getAccessToken());
    }

    @Test
    public void loginByPhoneCode() {
        AuthenticationResult authenticationResult = this.authenticationClient.loginByPhoneCode(
                new LoginByPhoneCodeParam("13188888888", "1234"));
        Assert.notBlank(authenticationResult.getAccessToken());
    }

    @Test
    public void registerByUsername() {
        User user = this.authenticationClient.registerByUsername(new RegisterByUsernameParam("test-register", "test"));
        Assert.notBlank(user.getId());
    }

    @Test
    public void registerByEmail() {
        User user = this.authenticationClient.registerByEmail(new RegisterByEmailParam("test@lihansir.com", "test"));
        Assert.notBlank(user.getId());
    }

    @Test
    public void registerByPhone() {
        User user = this.authenticationClient.registerByPhone(new RegisterByPhoneParam("13188888888", "test", "1234"));
        Assert.notBlank(user.getId());
    }

    @Test
    public void sendCaptcha() {
        this.authenticationClient.sendCaptcha("13188888888", VerificationCodePlatform.PHONE, VerificationCodeType.LOGIN);
    }

    @Test
    public void generateOidcAuthorizationUrl() {
        String authorizationUrl = this.authenticationClient.generateOidcAuthorizationUrl("profile", ResponseType.CODE,
                "http://127.0.0.1:8080", "state", "nonce");
        Assert.notBlank(authorizationUrl);
    }

    @Test
    public void oidcCodeToToken() {
        AccessToken accessToken = this.authenticationClient.oidcCodeToToken("yk05cpkr5wb9", "http://127.0.0.1:8080");
        Assert.notBlank(accessToken.getAccessToken());
    }

    @Test
    public void oidcRefreshToken() {
        String refreshToken = "7bcd69ed86d6c4f3cee43fdb0709cdf64bac608da0b941bb94d6167cb5196242";
        AccessToken accessToken = this.authenticationClient.oidcRefreshToken(refreshToken, "profile");
        Assert.notBlank(accessToken.getAccessToken());
    }

    @Test
    public void oidcIntrospectionToken() {
        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwOi8vMTI3LjAuMC4xOjgwODAvaWRhYXMvb2lkYyIsInN1YiI6IjE1MjIxNTM4MTMyMTIwMDg0NDgiLCJhdWQiOiIxNTIyMTQ4MDY1NTY4NDkzNTY4IiwiZXhwIjoxNjUxODAxMzM0LCJpYXQiOjE2NTE3NTgxMzQsIm5vbmNlIjoibm9uY2UiLCJzY29wZSI6ImVtYWlsIiwidXNlcm5hbWUiOiJ0ZXN0In0.onnLLEcbxXh-1MZbt5sg_sX_breqVUQZ1RIxvZ8n6g0NwQZq-vHEWXk02OhH3QxzAMcaPl3BD9A3CRCEOj9KjPR_Zc8Bgg70Sk5z397hbaE72N55cv9lwC_q7DF_qWBgRSPtG7HnrMSjikv4cOJKKYz6HVyZo9EjhX65B6Xyxd4";
        boolean active = this.authenticationClient.oidcIntrospectionToken(accessToken);
        Assert.isTrue(active);
    }

    @Test
    public void oidcRevokeToken() {
        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwOi8vMTI3LjAuMC4xOjgwODAvaWRhYXMvb2lkYyIsInN1YiI6IjE1MjIxNTM4MTMyMTIwMDg0NDgiLCJhdWQiOiIxNTIyMTQ4MDY1NTY4NDkzNTY4IiwiZXhwIjoxNjUxODAxMzM0LCJpYXQiOjE2NTE3NTgxMzQsIm5vbmNlIjoibm9uY2UiLCJzY29wZSI6ImVtYWlsIiwidXNlcm5hbWUiOiJ0ZXN0In0.onnLLEcbxXh-1MZbt5sg_sX_breqVUQZ1RIxvZ8n6g0NwQZq-vHEWXk02OhH3QxzAMcaPl3BD9A3CRCEOj9KjPR_Zc8Bgg70Sk5z397hbaE72N55cv9lwC_q7DF_qWBgRSPtG7HnrMSjikv4cOJKKYz6HVyZo9EjhX65B6Xyxd4";
        this.authenticationClient.oidcRevokeToken(accessToken);
    }

    @Test
    public void oidcUserInfo() {
        String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwOi8vMTI3LjAuMC4xOjgwODAvaWRhYXMvb2lkYyIsInN1YiI6IjE1MjIxNTM4MTMyMTIwMDg0NDgiLCJhdWQiOiIxNTIyMTQ4MDY1NTY4NDkzNTY4IiwiZXhwIjoxNjUxODAxMzM0LCJpYXQiOjE2NTE3NTgxMzQsIm5vbmNlIjoibm9uY2UiLCJzY29wZSI6ImVtYWlsIiwidXNlcm5hbWUiOiJ0ZXN0In0.onnLLEcbxXh-1MZbt5sg_sX_breqVUQZ1RIxvZ8n6g0NwQZq-vHEWXk02OhH3QxzAMcaPl3BD9A3CRCEOj9KjPR_Zc8Bgg70Sk5z397hbaE72N55cv9lwC_q7DF_qWBgRSPtG7HnrMSjikv4cOJKKYz6HVyZo9EjhX65B6Xyxd4";
        User user = this.authenticationClient.oidcUserInfo(accessToken);
        Assert.notBlank(user.getId());
    }

}
