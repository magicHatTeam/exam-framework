package com.boss.bes.core.data.pojo.basevo;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    private String id;
    /**
     * 字段名
     */
    @NotNull(message = "名字不能为空")
    private String name;
    /**
     * 状态：是否启用
     */
    @Min(value = 0, message = "只能用0和1表示是否启用")
    @Max(value = 1, message = "只能用0和1表示是否启用")
    private Byte status;

    public BaseModVO() {}

    public BaseModVO(String id, @NotNull(message = "名字不能为空") String name, @Min(value = 0, message = "只能用0和1表示是否启用") @Max(value = 1, message = "只能用0和1表示是否启用") Byte status) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
