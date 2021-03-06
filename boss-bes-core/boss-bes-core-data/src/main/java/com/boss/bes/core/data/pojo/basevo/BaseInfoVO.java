package com.boss.bes.core.data.pojo.basevo;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * 显示在表格中的VO
 *  基础的查询结果VO，由前端-->后端进行查询时，后端传给前端的查询结果
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 10:21
 */
@Valid
public abstract class BaseInfoVO<T extends BaseModVO> implements Serializable {
    private static final long serialVersionUID = -421671871218685809L;
    /**
     * 显示在表格中的VO集合（因为表格中的单个VO和增加/删除VO类似）
     */
    @Valid
    private List<T> dataList;
    /**
     * 当前查询条件下总共的数据条数
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long dataCount;

    public BaseInfoVO() {}

    public BaseInfoVO(List<T> dataList, Long dataCount) {
        this.dataList = dataList;
        this.dataCount = dataCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
