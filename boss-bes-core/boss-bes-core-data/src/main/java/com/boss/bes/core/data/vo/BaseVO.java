package com.boss.bes.core.data.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 基础VO
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-23 14:17
 */
public abstract class BaseVO {
    private Long id;
    private String name;
    private String status;
    private Date createdTime;
    private Long createdBy;
    private Integer pageSize;
    private Integer pageNum;
    private Integer dataCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
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

}
