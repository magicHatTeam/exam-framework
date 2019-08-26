package com.boss.bes.core.data.pojo.basevo;

/**
 * 基础的查询VO，由前端-->后端进行查询时，传给后端的查询条件
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 10:11
 */
public abstract class BaseQueryVO {
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
}
