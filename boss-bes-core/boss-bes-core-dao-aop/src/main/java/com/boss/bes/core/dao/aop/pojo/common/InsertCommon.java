package com.boss.bes.core.dao.aop.pojo.common;

import java.util.Date;

/**
 * 插入的公共属性类
 * 通过此类的属性进行填值
 * @author Lynch
 * @date 2019/8/15 -13:46
 */
public class InsertCommon {

	/**
	 * ID
	 */
	private Long id;
	/**
	 * 状态
	 */
	private Byte status;
	/**
	 * 组织机构ID
	 */
	private Long orgId;
	/**
	 * 公司ID
	 */
	private Long companyId;
	/**
	 * 创建人
	 */
	private Long createdBy;
	/**
	 * 创建时间
	 */
	private Date createdTime;
	/**
	 * 修改人
	 */
	private Long updatedBy;
	/**
	 * 修改时间
	 */
	private Date updatedTime;
	/**
	 * 版本
	 */
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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

	public InsertCommon() {
	}

	public InsertCommon(Long createdBy, Date createdTime, Long updatedBy, Date updatedTime, Long version) {
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
		this.version = version;
	}

	public InsertCommon(Long orgId, Long companyId, Long createdBy, Date createdTime, Long updatedBy, Date updatedTime, Long version) {
		this.orgId = orgId;
		this.companyId = companyId;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
		this.version = version;
	}

	public InsertCommon(Long id, Long orgId, Long companyId, Long createdBy, Date createdTime, Long updatedBy, Date updatedTime, Long version) {
		this.id = id;
		this.orgId = orgId;
		this.companyId = companyId;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
		this.version = version;
	}

	@Override
	public String toString() {
		return "InsertCommon{" +
				"id=" + id +
				", status=" + status +
				", orgId=" + orgId +
				", companyId=" + companyId +
				", createdBy=" + createdBy +
				", createdTime=" + createdTime +
				", updatedBy=" + updatedBy +
				", updatedTime=" + updatedTime +
				", version=" + version +
				'}';
	}
}
