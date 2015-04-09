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

/**
 * @Description
 * @author zj
 * @Date 2014年7月10日
 *	
 */
@Entity
@Table(name="C_SYS_MODULE",schema=GlobalSettings.MYSQL_DB_SCHEMA)
public class SysModuleEntity extends AccessoryEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6155035138825088561L;

	private Long moduleId;

	private Integer version;

	private String cname;

	private String ename;

	private String mcode;

	private String murl;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="ID", nullable=false,updatable=false)
	public Long getModuleId(){
		return this.moduleId;
	}

	public void setModuleId(Long moduleId){
		this.moduleId = moduleId;
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

	@Column(name="MCNAME")
	public String getCname(){
		return this.cname;
	}

	public void setCname(String cname){
		this.cname = cname;
	}

	@Column(name="MENAME")
	public String getEname(){
		return this.ename;
	}

	public void setEname(String ename){
		this.ename = ename;
	}

	@Column(name="MCODE")
	public String getMcode(){
		return this.mcode;
	}

	public void setMcode(String mcode){
		this.mcode = mcode;
	}

	@Column(name="MURL")
	public String getMurl(){
		return this.murl;
	}

	public void setMurl(String murl){
		this.murl = murl;
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
		return moduleId;
	}
}
