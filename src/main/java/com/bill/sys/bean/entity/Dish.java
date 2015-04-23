package com.bill.sys.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.zj.framework.core.entity.BaseEntity;

/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：Dish
 *
 * 包名称：com.bill.sys.bean.entity
 *
 * Create Time: 2015年4月22日 下午4:23:54
 *
 * remark (备注):  菜品    定期与收银机系统表[ cybr_bt_dish ]同步
 *
 */
@Entity
@Table(name="bus_tb_dish")
public class Dish extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1306827303631905471L;

	private Integer version;
	
	private Long did;
	
	/* 产品编号  */
	private String dishNo;
	
	/* 产品名称   */
	private String dishName;
	
	/* 产品价格  */
	private BigDecimal dishPrice;
	
	/* 产品类型  */
	private DishType dishType;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="did", nullable=false,updatable=false)
	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	@Column(name="dish_no")
	public String getDishNo() {
		return dishNo;
	}

	public void setDishNo(String dishNo) {
		this.dishNo = dishNo;
	}

	@Column(name="dish_name")
	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	@Column(name="dish_price")
	public BigDecimal getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(BigDecimal dishPrice) {
		this.dishPrice = dishPrice;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dish_type_id")
	public DishType getDishType() {
		return dishType;
	}

	public void setDishType(DishType dishType) {
		this.dishType = dishType;
	}

	@Override
	@Transient
	public Serializable getId() {
		return did;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
