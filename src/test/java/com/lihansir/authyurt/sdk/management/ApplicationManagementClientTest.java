package com.lihansir.authyurt.sdk.management;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.modules.management.ApplicationManagementClient;
import com.lihansir.authyurt.sdk.modules.management.ManagementClient;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 应用客户端单元测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class ApplicationManagementClientTest {

    private ApplicationManagementClient applicationManagementClient;

    @Before
    public void before() {
        ManagementClient managementClient = new ManagementClient(TestCommonConstant.TEST_USER_POOL_ID, TestCommonConstant.TEST_USER_POOL_SECRET);
        this.applicationManagementClient = managementClient.application();
    }

    @Test
    public void create() {
        String name = "test-app";
        CreateApplicationParam param = new CreateApplicationParam(name, "test-app");
        Application application = this.applicationManagementClient.create(param);
        Assert.isTrue(Objects.equals(name, application.getName()));
    }

    @Test
    public void update() {
        String name = "test-app-update";
        UpdateApplicationParam param = new UpdateApplicationParam();
        param.setName(name);
        Application application = this.applicationManagementClient.update("1522764090840322048", param);
        Assert.isTrue(Objects.equals(name, application.getName()));
    }

    @Test
    public void detail() {
        Application detail = this.applicationManagementClient.detail("1522764090840322048");
        Assert.notBlank(detail.getId());
    }

    @Test
    public void defaultApplication() {
        Application application = this.applicationManagementClient.defaultApplication();
        Assert.isTrue(Objects.equals(application.getUserPoolId(), TestCommonConstant.TEST_USER_POOL_ID));
    }

    @Test
    public void delete() {
        this.applicationManagementClient.delete("1522764090840322048");
    }

    @Test
    public void all() {
        List<Application> all = this.applicationManagementClient.all();
        Assert.notEmpty(all);
    }

    @Test
    public void search() {
        PageResult<Application> result = this.applicationManagementClient.search("测试");
        Assert.notEmpty(result.getData());
    }

    @Test
    public void refreshSecret() {
        this.applicationManagementClient.refreshSecret("1522148065568493568");
    }

    @Test
    public void activeUsers() {
        PageResult<User> userPageResult = this.applicationManagementClient.activeUsers("1522148065568493568");
        Assert.notEmpty(userPageResult.getData());
    }

    @Test
    public void kickActiveUsers() {
        this.applicationManagementClient.kickActiveUsers("1522148065568493568", Collections.singletonList("1522418173473853440"));
    }

}
