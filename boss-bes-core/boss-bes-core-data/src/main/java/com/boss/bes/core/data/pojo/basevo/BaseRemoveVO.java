package com.boss.bes.core.data.pojo.basevo;

import com.alibaba.fastjson.JSON;
import com.boss.bes.core.data.pojo.BaseData;
import com.boss.bes.core.data.pojo.BasePermissionData;

import javax.validation.Valid;
import java.util.List;

/**
 * 删除数据使用的VO
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 11:35
 */
@Valid
public abstract class BaseRemoveVO extends BasePermissionData {
    @Valid
    private List<BaseData> dataList;

    public BaseRemoveVO() {}

    public List<BaseData> getDataList() {
        return dataList;
    }

    public void setDataList(List<BaseData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
