package com.boss.bes.common.utils.constants;

/**
 * 公用缓存中属性的常量类
 * 即，在redis中key的值
 * @author likang
 * @date 2019/9/2 11:37
 */
public class CommonCacheConstants {
    /**
     * 请求头中，token的名称
     */
    public static final String REQUEST_TOKEN = "token";

    /**
     * 用户ID
     */
    public static final String USER_ID = "id";
    /**
     * 用户名
     */
    public static final String USER_NAME = "name";
    /**
     * 用户性别
     */
    public static final String USER_SEX = "sex";
    /**
     * 用户头像
     */
    public static final String USER_AVATAR = "avatar";
    /**
     * 公司ID
     */
    public static final String COMPANY_ID = "companyId";
    /**
     * 公司名
     */
    public static final String COMPANY_NAME = "companyName";
    /**
     * 组织机构ID
     */
    public static final String ORG_ID = "orgId";
    /**
     * 组织机构名
     */
    public static final String ORG_NAME = "orgName";
    /**
     * 角色名
     */
    public static final String ROLES = "roles";

    /**
     * 用户是否拥有管理员权限
     */
    public static final String MASTER = "master";

    /**
     * 用户管理员级别
     */
    public static final String MASTER_LEVEL = "masterLevel";

    /**
     * 公司管理员
     */
    public static final Byte COMPANY_MASTER = 0;

    /**
     * 组织机构管理员
     */
    public static final Byte ORG_MASTER = 1;

    /**
     * 超级管理员
     */
    public static final Byte SUPER_MASTER = 2;
}
