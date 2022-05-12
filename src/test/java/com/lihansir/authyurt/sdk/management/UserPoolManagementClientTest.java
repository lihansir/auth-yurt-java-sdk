package com.lihansir.authyurt.sdk.management;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.model.CheckPasswordStrengthResult;
import com.lihansir.authyurt.sdk.model.Env;
import com.lihansir.authyurt.sdk.model.UpdateUserPoolParam;
import com.lihansir.authyurt.sdk.model.UserPool;
import com.lihansir.authyurt.sdk.modules.management.ManagementClient;
import com.lihansir.authyurt.sdk.modules.management.UserPoolManagementClient;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/**
 * 用户池管理客户端单元测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class UserPoolManagementClientTest {

    private UserPoolManagementClient userPoolManagementClient;

    @Before
    public void before() {
        ManagementClient managementClient = new ManagementClient(TestCommonConstant.TEST_USER_POOL_ID, TestCommonConstant.TEST_USER_POOL_SECRET);
        this.userPoolManagementClient = managementClient.userPool();
    }

    @Test
    public void detail() {
        UserPool detail = this.userPoolManagementClient.detail();
        Assert.notBlank(detail.getId());
    }

    @Test
    public void update() {
        String name = "test-update";
        UpdateUserPoolParam updateUserPoolParam = new UpdateUserPoolParam();
        updateUserPoolParam.setName(name);
        UserPool detail = this.userPoolManagementClient.update(updateUserPoolParam);
        Assert.isTrue(Objects.equals(detail.getName(), name));
    }

    @Test
    public void listEnv() {
        List<Env> envs = this.userPoolManagementClient.listEnv();
        Assert.isTrue(!envs.isEmpty());
    }

    @Test
    public void addEnv() {
        Env env = this.userPoolManagementClient.addEnv("name", "value");
        Assert.notBlank(env.getId());
    }

    @Test
    public void getEnv() {
        Env env = this.userPoolManagementClient.getEnv("name");
        Assert.notBlank(env.getId());
    }

    @Test
    public void removeEnv() {
        this.userPoolManagementClient.removeEnv("name");
    }

    @Test
    public void refreshSecret() {
        this.userPoolManagementClient.refreshSecret();
    }

    @Test
    public void checkPasswordStrength() {
        CheckPasswordStrengthResult checkPasswordStrengthResult = this.userPoolManagementClient.checkPasswordStrength("1234");
        Assert.isTrue(checkPasswordStrengthResult.isValid());
    }

}
