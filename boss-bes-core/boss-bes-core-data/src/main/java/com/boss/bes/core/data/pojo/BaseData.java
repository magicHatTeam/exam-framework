package com.boss.bes.core.data.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 基础的实体POJO，用版本号和id唯一标示一个信息对象
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019/8/30 10:11 上午
 */
@Valid
public class BaseData {
    /**
     * 字段id
     * 在新增字段时 id 可以为空
     */
    @NotNull(message = "id不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 数据版本
     */
    @NotNull(message = "版本不能为空")
    @JsonSerialize(using=ToStringSerializer.class)
    private Long version;

    /**
     * 当前数据的所属id，为空则是组织机构级别数据
     */
    private Long companyId;

    private Long orgId;

    public BaseData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
