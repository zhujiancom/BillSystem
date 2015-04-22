package org.zj.framework.core.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.zj.framework.core.entity.BaseEntity;

/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：DictGroup
 *
 * 包名称：org.zj.framework.core.entity.base
 *
 * Create Time: 2015年4月22日 下午1:18:20
 *
 * remark (备注): 字典项组 
 *
 */
@Entity
@Table(name="core_tb_dict_group")
public class DictGroup extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 267286866602304271L;
	
	private Integer version;
	
	private Long dgId;
	
	/* 字典组编码 */
	private String groupCode;
	
	/* 字典组中文名称 */
	private String groupCname;
	
	/* 字典组英文名称 */
	private String groupEname;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="dgid", nullable=false,updatable=false)
	public Long getDgId() {
		return dgId;
	}

	public void setDgId(Long dgId) {
		this.dgId = dgId;
	}

	@Column(name="group_code")
	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	@Column(name="group_c_name")
	public String getGroupCname() {
		return groupCname;
	}

	public void setGroupCname(String groupCname) {
		this.groupCname = groupCname;
	}

	@Column(name="group_e_name")
	public String getGroupEname() {
		return groupEname;
	}

	public void setGroupEname(String groupEname) {
		this.groupEname = groupEname;
	}

	@Override
	@Transient
	public Serializable getId() {
		return dgId;
	}

	@Override
	public Integer getVersion() {
		return version;
	}

	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

}
