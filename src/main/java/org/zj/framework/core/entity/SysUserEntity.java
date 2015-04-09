package org.zj.framework.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.zj.framework.core.config.GlobalSettings;



@Entity
@Table(name="C_SYS_USER",uniqueConstraints={@UniqueConstraint(columnNames={"ACCOUNTNO"})},schema=GlobalSettings.MYSQL_DB_SCHEMA)
//oralce - @SequenceGenerator(name="CORE_SEQ", catalog=GlobalConfig.ORACLE_SCHEMA , sequenceName="COMMON_SEQ",allocationSize=1,initialValue=1)
public class SysUserEntity extends AccessoryEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5345093207212535922L;

	private Long userId;

	private Integer version;

	/**
	 * 账号
	 */
	private String accountNo;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 电子邮箱
	 */
	private String email;

	/**
	 * 联系方式
	 */
	private String mobilephone;

	/**
	 * 上次登录时间
	 */
	private Date LastLoginTime;

	/**
	 * 当前登录时间
	 */
	private Date loginTime;

	/**
	 * 登录次数
	 */
	private Integer loginCount;

	@Id
	// oracle - @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CORE_SEQ")
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="ID", nullable=false,updatable=false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="EMAIL")
	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	@Column(name="ACCOUNTNO")
	public String getAccountNo(){
		return this.accountNo;
	}

	public void setAccountNo(String accountNo){
		this.accountNo = accountNo;
	}

	@Column(name="PASSWORD",updatable=false)
	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	@Column(name="MPHONE")
	public String getMobilephone(){
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone){
		this.mobilephone = mobilephone;
	}

	@Column(name="LASTLOGINTIME")
	public Date getLastLoginTime(){
		return this.LastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime){
		this.LastLoginTime = lastLoginTime;
	}

	@Column(name="LOGINTIME")
	public Date getLoginTime(){
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime){
		this.loginTime = loginTime;
	}

	@Column(name="LOGINCOUNT")
	public Integer getLoginCount(){
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount){
		this.loginCount = loginCount;
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
		// TODO Auto-generated method stub
		return userId;
	}

	@Override
	public String toString(){
		return "SysUserEntity [userId=" + this.userId + ", accountNo="
				+ this.accountNo + ", name=" + this.name + "]";
	}

}
