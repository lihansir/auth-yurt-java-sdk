package com.lihansir.authyurt.sdk.modules.management;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.TypeReference;
import com.lihansir.authyurt.sdk.constant.CommonConstant;
import com.lihansir.authyurt.sdk.model.AuthenticationResult;
import com.lihansir.authyurt.sdk.modules.BaseClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理客户端
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class ManagementClient extends BaseClient {

    public UserPoolManagementClient userPool() {
        return new UserPoolManagementClient(this);
    }

    public UserManagementClient user() {
        return new UserManagementClient(this);
    }

    public GroupManagementClient group() {
        return new GroupManagementClient(this);
    }

    public OrgManagementClient org() {
        return new OrgManagementClient(this);
    }

    public RoleManagementClient role() {
        return new RoleManagementClient(this);
    }

    public AclManagementClient acl() {
        return new AclManagementClient(this);
    }

    public PolicyManagementClient policy() {
        return new PolicyManagementClient(this);
    }

    public ApplicationManagementClient application() {
        return new ApplicationManagementClient(this);
    }

    protected <T> T get(String path, Class<T> dataClass) {
        return get(path, null, dataClass);
    }

    protected <T> T get(String path, Map<String, Object> queryMapStr, Class<T> dataClass) {
        checkToken();
        return super.baseGet(path, queryMapStr, dataClass);
    }

    protected <T> T get(String path, TypeReference<T> typeReference) {
        return get(path, null, typeReference);
    }

    protected <T> T get(String path, Map<String, Object> queryMapStr, TypeReference<T> typeReference) {
        checkToken();
        return super.baseGet(path, queryMapStr, typeReference);
    }

    protected String get(String path, Map<String, Object> queryMapStr) {
        checkToken();
        return super.baseGet(path, queryMapStr);
    }

    protected <T> T postForm(String path, Map<String, Object> formMapStr, Class<T> dataClass) {
        checkToken();
        return super.basePostForm(path, formMapStr, dataClass);
    }

    protected <T> T postForm(String path, Map<String, Object> formMapStr, TypeReference<T> typeReference) {
        checkToken();
        return super.basePostForm(path, formMapStr, typeReference);
    }

    protected String postForm(String path, Map<String, Object> formMapStr) {
        checkToken();
        return super.basePostForm(path, formMapStr);
    }

    protected <T> T post(String path, Object body, Class<T> dataClass) {
        checkToken();
        return super.basePost(path, body, dataClass);
    }

    protected <T> T post(String path, Object body, TypeReference<T> typeReference) {
        checkToken();
        return super.basePost(path, body, typeReference);
    }

    protected String post(String path, Object body) {
        checkToken();
        return super.basePost(path, body);
    }

    protected String put(String path) {
        checkToken();
        return super.basePut(path);
    }

    protected <T> T put(String path, Object body, Class<T> dataClass) {
        checkToken();
        return super.basePut(path, body, dataClass);
    }

    protected <T> T put(String path, Object body, TypeReference<T> typeReference) {
        checkToken();
        return super.basePut(path, body, typeReference);
    }

    protected <T> T patch(String path, Object body, Class<T> dataClass) {
        checkToken();
        return super.basePatch(path, body, dataClass);
    }

    protected <T> T patch(String path, Object body, TypeReference<T> typeReference) {
        checkToken();
        return super.basePatch(path, body, typeReference);
    }

    protected void delete(String path, Object body) {
        checkToken();
        super.baseDelete(path, body);
    }

    protected void deleteWithParam(String path, Map<String, Object> param) {
        checkToken();
        super.baseDeleteWithParam(path, param);
    }

    protected void delete(String path) {
        checkToken();
        super.baseDelete(path, null);
    }

    private void checkToken() {
        if (StrUtil.isBlank(getToken())) {
            requestToken();
        }
        Long accessTokenExpiresAt = getAccessTokenExpiresAt();
        if (accessTokenExpiresAt != null && accessTokenExpiresAt < DateUtil.current() + 3600 * 1000) {
            requestToken();
        }
    }

    private void requestToken() {
        String url = StrUtil.format("{}{}", CommonConstant.IDAAS_CONTEXT_PATH, "/api/authentication/getUserPoolAccessToken");
        Map<String, Object> data = new HashMap<>(2);
        data.put("userPoolId", getUserPoolId());
        data.put("secret", getSecret());
        AuthenticationResult authenticationResult = super.basePost(url, data, AuthenticationResult.class);
        setToken(authenticationResult.getAccessToken());
        setAccessTokenExpiresAt(DateUtil.current() + authenticationResult.getExpiresIn());
    }

    public ManagementClient(String userPoolId, String secret) {
        setUserPoolId(userPoolId);
        setSecret(secret);
    }

}
