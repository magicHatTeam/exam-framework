package com.boss.bes.core.data.pojo.basevo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 基础的修改VO，用于增加和删除
 *
 * @author 何家伟
 * @version 2.0
 * @date 2019-08-23 14:17
 */
@Valid
public abstract class BaseModVO {
    /**
     * 字段id
     * 在新增字段时 id 可以为空
     */
    private Long id;
    /**
     * 字段名
     */
    @NotNull(message = "名字不能为空")
    private String name;
    /**
     * 状态：是否启用
     */
    @NotNull(message = "状态标记为不能为空")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
