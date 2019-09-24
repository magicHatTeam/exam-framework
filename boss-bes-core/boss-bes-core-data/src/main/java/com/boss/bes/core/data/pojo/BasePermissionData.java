package com.boss.bes.core.data.pojo;

/**
 * 基础的权限pojo
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019/9/9 2:57 下午
 */
public class BasePermissionData {
    /**
     * 当前登录用户所管理的公司id,为null则表示能管理当前组织机构所有公司
     */
    private Long loginCompanyId;

    /**
     * 当前登录用户所管理的组织机构id,为null则表示能管理所有组织机构
     */
    private Long loginOrgId;

    /**
     * 当前登录用户的级别
     */
    private Byte masterLevel;

    /**
     * 当前登录用户是否未管理员
     */
    private Boolean master;


    public Byte getMasterLevel() {
        return masterLevel;
    }

    public void setMasterLevel(Byte masterLevel) {
        this.masterLevel = masterLevel;
    }

    public Boolean getMaster() {
        return master;
    }

    public void setMaster(Boolean master) {
        this.master = master;
    }

    public BasePermissionData() {
    }

    public Long getLoginCompanyId() {
        return loginCompanyId;
    }

    public void setLoginCompanyId(Long loginCompanyId) {
        this.loginCompanyId = loginCompanyId;
    }

    public Long getLoginOrgId() {
        return loginOrgId;
    }

    public void setLoginOrgId(Long loginOrgId) {
        this.loginOrgId = loginOrgId;
    }
}
