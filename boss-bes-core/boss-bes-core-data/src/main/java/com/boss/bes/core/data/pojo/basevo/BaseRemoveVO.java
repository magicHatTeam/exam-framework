package com.boss.bes.core.data.pojo.basevo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 删除数据使用的VO
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 11:35
 */
@Valid
public abstract class BaseRemoveVO {
    @NotNull(message = "待删除的id集合不能为空")
    @JSONField(serializeUsing = ToStringSerializer.class)
    private List<Long> idList;

    @NotNull(message = "版本不能为空")
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long version;

    public BaseRemoveVO() {}

    public BaseRemoveVO(@NotNull(message = "待删除的id集合不能为空") List<Long> idList, Long version) {
        this.idList = idList;
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
