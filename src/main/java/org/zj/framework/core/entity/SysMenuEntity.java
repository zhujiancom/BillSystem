package org.zj.framework.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.config.GlobalConstants;
import org.zj.framework.core.entity.base.AccessoryEntity;
import org.zj.framework.core.enums.CommonEnums.Validity;

/**
 * 
 * remark (备注): 菜单管理
 *
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：SysMenuEntity
 *
 * 包名称：org.zj.framework.core.entity
 *
 * Create Time: 2015年4月29日 下午3:09:46
 *
 */
@Entity
@Table(name="C_SYS_MENU",schema=GlobalConstants.DEFAULT_MYSQL_SCHEMA)
public class SysMenuEntity extends AccessoryEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7796457813203475807L;
	private Long menuId;
	
	private Integer version;
	
	private String cname;
	
	private String ename;
	
	private String url;
	
	private Integer sort;
	
	private Long parentId;
	
	private String icon;
	
	private Validity validity;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="menu_id", nullable=false,updatable=false)
	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	@Column(name="menu_cname")
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name="menu_ename")
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name="menu_url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name="sort")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Column(name="menu_parent_id")
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name="menu_icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="validity")
	public Validity getValidity() {
		return validity;
	}

	public void setValidity(Validity validity) {
		this.validity = validity;
	}

	@Override
	@Transient
	public Serializable getId() {
		return menuId;
	}

	@Override
	@Version
	public Integer getVersion() {
		return version;
	}

	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

}
