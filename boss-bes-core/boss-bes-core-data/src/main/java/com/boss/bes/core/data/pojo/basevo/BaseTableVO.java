package com.boss.bes.core.data.pojo.basevo;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 显示在表格中的VO
 *  基础的查询结果VO，由前端-->后端进行查询时，后端传给前端的查询结果
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 10:21
 */
public abstract class BaseTableVO<T extends BaseModVO> {
    /**
     * 显示在表格中的VO集合（因为表格中的单个VO和增加/删除VO类似）
     */
    private List<T> dataList;
    /**
     * 当前分页条件下，一页中拥有的数据条数
     */
    private Integer pageSize;
    /**
     * 当前分页条件下，一页中拥有的数据条数
     */
    private Integer pageNum;
    /**
     * 当前查询条件下总共的数据条数
     */
    private Integer dataCount;

    public BaseTableVO() {}

    public BaseTableVO(List<T> dataList, Integer pageSize, Integer pageNum, Integer dataCount) {
        this.dataList = dataList;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.dataCount = dataCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
