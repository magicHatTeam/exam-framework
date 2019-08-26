package com.boss.bes.core.data.pojo.basevo;

/**
 * 基础的修改VO，用于增加和删除
 *
 * @author 何家伟
 * @version 2.0
 * @date 2019-08-23 14:17
 */
public abstract class BaseModVO {
    /**
     * 字段id
     */
    private Long id;
    /**
     * 字段名
     */
    private String name;
    /**
     * 状态：是否启用
     */
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
