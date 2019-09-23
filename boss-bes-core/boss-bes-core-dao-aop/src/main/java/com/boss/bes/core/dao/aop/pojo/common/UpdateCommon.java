package com.boss.bes.core.dao.aop.pojo.common;

import java.util.Date;

/**
 * 修改的公共属性类
 * 通过此类的属性进行填值
 * @author Lynch
 * @date 2019/8/15 -13:45
 */
public class UpdateCommon {

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

	public UpdateCommon() {
	}

	public UpdateCommon(Long updatedBy, Date updatedTime, Long version) {
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
		this.version = version;
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
		return "UpdateCommon{" +
				"updatedBy=" + updatedBy +
				", updatedTime=" + updatedTime +
				", version=" + version +
				'}';
	}
}
