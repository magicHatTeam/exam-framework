package com.boss.bes.core.data.dto;

import java.util.Date;

/**
 * 基础DTO
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-23 14:26
 */
public abstract class BaseDTO {
    private Long id;
    private String name;
    private String status;
    private Date createdTime;
    private Long createdBy;
    private Integer dataCount;

    public Long getId() {
        return id;
    }

    /**
     * 需要注意，这里要设置传入String类型的id，方便VO和DTO的id相互转换
     * @param id string类型的id，正常情况下由VO传入
     */
    public void setId(String id) {
        this.id = Long.valueOf(id);
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

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }
}
