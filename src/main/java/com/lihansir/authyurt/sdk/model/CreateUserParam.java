package com.lihansir.authyurt.sdk.model;

import com.lihansir.authyurt.sdk.enums.GenderEnum;
import com.lihansir.authyurt.sdk.enums.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建用户参数
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserParam {

    /**
     * 用户状态
     */
    private UserStatusEnum status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱验证状态
     */
    private Boolean emailVerified;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 手机号验证状态
     */
    private Boolean phoneNumberVerified;

    /**
     * 用户名（登录名）
     */
    private String username;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * givenName
     */
    private String givenName;

    /**
     * familyName
     */
    private String familyName;

    /**
     * middleName
     */
    private String middleName;

    /**
     * preferenceUsername
     */
    private String preferenceUsername;

    /**
     * 用户描述
     */
    private String profile;

    /**
     * 头像
     */
    private String picture;

    /**
     * 密码
     */
    private String password;

    /**
     * 网站
     */
    private String website;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 时区信息
     */
    private String zoneinfo;

    /**
     * 语言
     */
    private String locale;

    /**
     * 生日（时间戳）
     */
    private Long birthdate;

    /**
     * 所在地
     */
    private String address;

    /**
     * 国家代码
     */
    private String country;

    /**
     * 公司
     */
    private String company;

    /**
     * 城市
     */
    private String city;

    /**
     * 省/区
     */
    private String province;

    /**
     * 街道地址
     */
    private String streetAddress;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 第三方 ID（用于关联原系统 ID）
     */
    private String externalId;

}
