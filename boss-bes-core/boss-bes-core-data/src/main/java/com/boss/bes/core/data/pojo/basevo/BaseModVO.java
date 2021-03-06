package com.boss.bes.core.data.pojo.basevo;

import com.alibaba.fastjson.JSON;
import com.boss.bes.core.data.pojo.BasePermissionData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 基础的修改VO，用于增加和删除
 *
 * @author 何家伟
 * @version 2.0
 * @date 2019-08-23 14:17
 */
@Valid
public abstract class BaseModVO extends BasePermissionData {
    /**
     * 字段id
     * 在新增字段时 id 可以为空
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 字段名
     */
    @NotEmpty(message = "名字不能为空")
    private String name;
    /**
     * 状态：是否启用
     */
    @Min(value = 0, message = "只能用0和1表示是否启用")
    @Max(value = 1, message = "只能用0和1表示是否启用")
    private Byte status;
    /**
     * 数据版本
     */
    @JsonSerialize(using = com.fasterxml.jackson.databind.ser.std.ToStringSerializer.class)
    private Long version;

    /**
     * 当前数据的所属公司id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long belongedCompanyId;

    public BaseModVO() {}

    public BaseModVO(Long id, @NotNull(message = "名字不能为空") String name, @Min(value = 0, message = "只能用0和1表示是否启用") @Max(value = 1, message = "只能用0和1表示是否启用") Byte status, Long version) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBelongedCompanyId() {
        return belongedCompanyId;
    }

    public void setBelongedCompanyId(Long belongedCompanyId) {
        this.belongedCompanyId = belongedCompanyId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
