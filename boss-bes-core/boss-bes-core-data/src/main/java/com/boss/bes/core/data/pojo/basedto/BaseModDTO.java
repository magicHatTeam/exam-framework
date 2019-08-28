package com.boss.bes.core.data.pojo.basedto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 基础的修改DTO，在Controller收到ModVO，需要进行
 *
 * @author 何家伟
 * @version 1.0
 * @date 2019-08-27 14:41
 */
public abstract class BaseModDTO {
    /**
     * 字段id
     * 在新增字段时 id 可以为空
     */
    private Long id;
    /**
     * 字段名
     */
    @NotNull(message = "名字不能为空")
    private String name;
    /**
     * 状态：是否启用
     */
    @Min(value = 0, message = "只能用0和1表示是否启用")
    @Max(value = 1, message = "只能用0和1表示是否启用")
    private Byte status;
    private Long createdBy;
    private Date createdTime;
    private Long updatedBy;
    private Date updatedTime;
    private Long version;

    public BaseModDTO() {}

    public BaseModDTO(Long id, @NotNull(message = "名字不能为空") String name, @Min(value = 0, message = "只能用0和1表示是否启用") @Max(value = 1, message = "只能用0和1表示是否启用") Byte status, Long createdBy, Date createdTime, Long updatedBy, Date updatedTime, Long version) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Long.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "BaseModDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
