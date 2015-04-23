package com.bill.sys.bean.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.entity.BaseEntity;
import org.zj.framework.core.enums.CommonEnums;
/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：DishType
 *
 * 包名称：com.bill.sys.bean.entity
 *
 * Create Time: 2015年4月22日 下午4:25:08
 *
 * remark (备注):菜品类型
 *
 */
@Entity
@Table(name="bus_tb_dish_type")
public class DishType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6506342777961564482L;
	private Integer version;
	
	private Long dtid;
	
	/* 类型编号  */
	private String dtNo;
	
	/* 类型名称  */
	private String dtName;
	
	private List<Dish> dishes;
	
	private CommonEnums.YOrN beDiscount;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="dtid", nullable=false,updatable=false)
	public Long getDtid() {
		return dtid;
	}

	public void setDtid(Long dtid) {
		this.dtid = dtid;
	}

	@Column(name="dish_type_no")
	public String getDtNo() {
		return dtNo;
	}

	public void setDtNo(String dtNo) {
		this.dtNo = dtNo;
	}

	@Column(name="dish_type_name")
	public String getDtName() {
		return dtName;
	}

	public void setDtName(String dtName) {
		this.dtName = dtName;
	}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="dishType")
	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="be_discount")
	public CommonEnums.YOrN getBeDiscount() {
		return beDiscount;
	}

	public void setBeDiscount(CommonEnums.YOrN beDiscount) {
		this.beDiscount = beDiscount;
	}

	@Override
	@Transient
	public Serializable getId() {
		return dtid;
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
