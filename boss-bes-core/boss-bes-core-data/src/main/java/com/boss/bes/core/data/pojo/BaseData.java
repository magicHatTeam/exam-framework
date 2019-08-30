package com.boss.bes.core.data.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

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
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    /**
     * 数据版本
     */
    @NotNull(message = "版本不能为空")
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long version;

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
}
