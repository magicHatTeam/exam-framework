package com.boss.bes.core.data.pojo;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * 基础的权限pojo
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019/9/9 2:57 下午
 */
@Valid
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

    /**
     * 当前登录用户的级别
     */
    private Byte masterLevel;


    public Byte getMasterLevel() {
        return masterLevel;
    }

    public void setMasterLevel(Byte masterLevel) {
        this.masterLevel = masterLevel;
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
