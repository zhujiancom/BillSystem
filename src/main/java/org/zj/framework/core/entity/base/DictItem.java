package org.zj.framework.core.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：DictItem
 *
 * 包名称：org.zj.framework.core.entity.base
 *
 * Create Time: 2015年4月22日 下午1:20:26
 *
 * remark (备注):字典项 列表
 *
 */
@Entity
@Table(name="core_tb_dict_item")
public class DictItem extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2258275601343756117L;
	
	private Integer version;
	
	private Long dtId;
	
	/* 字典项编码 */
	private String itemCode;

	private String itemCname;
	
	private String itemEname;
	
	/* 所属组编码*/
	private String groupCode;
	
	/* 序号 */
	private Integer seq;
	
	/* 描述*/
	private String description;
	
	public DictItem(){}
	
	public DictItem(String groupCode,String itemCode){
		this.groupCode = groupCode;
		this.itemCode = itemCode;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="dtid", nullable=false,updatable=false)
	public Long getDtId() {
		return dtId;
	}

	public void setDtId(Long dtId) {
		this.dtId = dtId;
	}

	@Column(name="item_code")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name="item_c_name")
	public String getItemCname() {
		return itemCname;
	}

	public void setItemCname(String itemCname) {
		this.itemCname = itemCname;
	}

	@Column(name="item_e_name")
	public String getItemEname() {
		return itemEname;
	}

	public void setItemEname(String itemEname) {
		this.itemEname = itemEname;
	}

	@Column(name="group_code")
	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	@Column(name="seq")
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	@Transient
	public Serializable getId() {
		return dtId;
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
