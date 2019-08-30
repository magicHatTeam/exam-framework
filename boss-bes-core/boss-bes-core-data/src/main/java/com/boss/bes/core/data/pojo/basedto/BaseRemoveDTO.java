package com.boss.bes.core.data.pojo.basedto;

import com.alibaba.fastjson.JSON;
import com.boss.bes.core.data.pojo.BaseData;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 删除数据使用的DTO
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 11:35
 */
@Valid
public abstract class BaseRemoveDTO {
    @Valid
    private List<BaseData> dataList;

    public BaseRemoveDTO() {}

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
