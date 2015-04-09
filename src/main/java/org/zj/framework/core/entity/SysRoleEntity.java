package org.zj.framework.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.config.GlobalSettings;

@Entity
@Table(name="C_SYS_ROLE",schema=GlobalSettings.MYSQL_DB_SCHEMA)
//oralce - @SequenceGenerator(name="CORE_SEQ", catalog=GlobalConfig.ORACLE_SCHEMA , sequenceName="COMMON_SEQ",allocationSize=1,initialValue=1)
public class SysRoleEntity extends AccessoryEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5780389341283740233L;

	private Long roleId;

	private Integer version;

	private String cname;

	private String ename;

	private String roleCode;

	@Id
	// oracle - @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CORE_SEQ")
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="ID", nullable=false,updatable=false)
	public Long getRoleId(){
		return this.roleId;
	}

	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	@Override
	@Version
	public Integer getVersion(){
		return this.version;
	}

	@Override
	public void setVersion(Integer version){
		this.version = version;
	}

	@Column(name="R_CNAME")
	public String getCname(){
		return this.cname;
	}

	public void setCname(String cname){
		this.cname = cname;
	}

	@Column(name="R_ENAME")
	public String getEname(){
		return this.ename;
	}

	public void setEname(String ename){
		this.ename = ename;
	}

	@Column(name="R_CODE")
	public String getRoleCode(){
		return this.roleCode;
	}

	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}

	/**
	 * @Function
	 * @return
	 * @author zj
	 * @Date 2014年7月24日
	 */
	@Override
	@Transient
	public Serializable getId(){
		return roleId;
	}


}
