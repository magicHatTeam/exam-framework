package com.boss.bes.core.data.pojo.basedto;

import com.alibaba.fastjson.JSON;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 基础的查询DTO-->后端进行查询时，传给后端的查询条件
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-26 10:11
 */
@Valid
public abstract class BaseQueryDTO {
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

    /**
     * 查询时通过当前用户所属公司id来判断能够查询到的数据
     */
    private Long belongedCompanyId;

    public BaseQueryDTO() {}

    public BaseQueryDTO(@Min(value = 1, message = "分页时每页的数据数目不能小于1") Integer pageSize, @Min(value = 1, message = "分页时当前页码不能小于1") Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
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

    public Long getBelongedCompanyId() {
        return belongedCompanyId;
    }

    public void setBelongedCompanyId(Long belongedCompanyId) {
        this.belongedCompanyId = belongedCompanyId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
