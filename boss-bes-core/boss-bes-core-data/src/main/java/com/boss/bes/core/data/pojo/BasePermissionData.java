package com.boss.bes.core.data.pojo;

import java.io.Serializable;

/**
 * 基础的权限pojo
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019/9/9 2:57 下午
 */
public class BasePermissionData implements Serializable {
    private static final long serialVersionUID = -2042738983189251562L;
    /**
     * 当前登录用户所管理的公司id,为null则表示能管理当前组织机构所有公司
     */
    private Long loginCompanyId;

    /**
     * 当前登录用户所管理的组织机构id,为null则表示能管理所有组织机构
     */
    private Long loginOrgId;

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
