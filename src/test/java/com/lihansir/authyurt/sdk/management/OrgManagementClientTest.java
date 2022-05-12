package com.lihansir.authyurt.sdk.management;

import cn.hutool.core.lang.Assert;
import com.lihansir.authyurt.sdk.common.TestCommonConstant;
import com.lihansir.authyurt.sdk.model.*;
import com.lihansir.authyurt.sdk.modules.management.ManagementClient;
import com.lihansir.authyurt.sdk.modules.management.OrgManagementClient;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 机构管理客户端单元测试
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class OrgManagementClientTest {

    private OrgManagementClient orgManagementClient;

    @Before
    public void before() {
        ManagementClient managementClient = new ManagementClient(TestCommonConstant.TEST_USER_POOL_ID, TestCommonConstant.TEST_USER_POOL_SECRET);
        this.orgManagementClient = managementClient.org();
    }

    @Test
    public void create() {
        String orgName = "测试创建机构";
        CreateOrgParam param = new CreateOrgParam(orgName);
        Org org = this.orgManagementClient.create(param);
        Assert.isTrue(Objects.equals(orgName, org.getOrgName()));
    }

    @Test
    public void update() {
        String orgName = "测试修改机构";
        UpdateOrgParam param = new UpdateOrgParam();
        param.setOrgName(orgName);
        Org org = this.orgManagementClient.update("1522569204526616576", param);
        Assert.isTrue(Objects.equals(orgName, org.getOrgName()));
    }

    @Test
    public void detailById() {
        Org org = this.orgManagementClient.detailById("1522569204526616576");
        Assert.notBlank(org.getId());
    }

    @Test
    public void detailByOrgId() {
        Org org = this.orgManagementClient.detailByOrgId("1522569496211099648");
        Assert.notBlank(org.getId());
    }

    @Test
    public void deleteById() {
        this.orgManagementClient.deleteById("1522569204526616576");
    }

    @Test
    public void deleteByOrgId() {
        this.orgManagementClient.deleteByOrgId("1522569496211099648");
    }

    @Test
    public void all() {
        List<Org> all = this.orgManagementClient.all();
        Assert.notEmpty(all);
    }

    @Test
    public void listByIds() {
        List<Org> orgs = this.orgManagementClient.listByIds(Collections.singletonList("1522563872668651520"));
        Assert.notEmpty(orgs);
    }

    @Test
    public void search() {
        List<Org> result = this.orgManagementClient.search("test");
        Assert.notEmpty(result);
    }

    @Test
    public void listUserOrgNodeIds() {
        List<String> nodeIds = this.orgManagementClient.listUserOrgNodeIds("1522418228675088384");
        Assert.notEmpty(nodeIds);
    }

    @Test
    public void addMembers() {
        this.orgManagementClient.addMembers("1522563872668651520", Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void removeMembers() {
        this.orgManagementClient.removeMembers("1522563872668651520", Collections.singletonList("1522418228675088384"));
    }

    @Test
    public void updateUserOrgs() {
        this.orgManagementClient.updateUserOrgs("1522418228675088384", Collections.singletonList("1522563872668651520"));
    }

    @Test
    public void removeUserAllOrgs() {
        this.orgManagementClient.removeUserAllOrgs("1522418228675088384");
    }

    @Test
    public void listOrgUsers() {
        PageResult<User> userPageResult = this.orgManagementClient.listOrgUsers("1522563872668651520", 1, 10);
        Assert.notEmpty(userPageResult.getData());
    }

}
