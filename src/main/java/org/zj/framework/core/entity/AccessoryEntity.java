package org.zj.framework.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AccessoryEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6343352866467233562L;

	private Long creator;

	private Long modifier;

	private Date createTime;

	private Date modifyTime;

	@Column(name = "CREATOR", insertable = true, updatable = false)
	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	@Column(name = "MODIFIER")
	public Long getModifier() {
		return modifier;
	}

	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}

	@Column(name="CREATE_TIME", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="MODIFY_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
