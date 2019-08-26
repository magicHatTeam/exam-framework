package com.boss.bes.core.data.pojo.basevo;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 基础的查询VO，由前端-->后端进行查询时，传给后端的查询条件
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 10:11
 */
@Valid
public abstract class BaseQueryVO {
    /**
     * 当前分页条件下，一页中拥有的数据条数
     */
    @Min(value = 1, message = "分页时每页的数据数目不能小于1")
    private Integer pageSize;
    /**
     * 当前分页条件下，一页中拥有的数据条数
     */
    @Min(value = 1, message = "分页时当前页码不能小于1")
    private Integer pageNum;

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
}
