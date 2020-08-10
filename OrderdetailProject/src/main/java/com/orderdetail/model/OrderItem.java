package com.orderdetail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ORDERS")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "productcode")
	@NotNull
	private String pcode;
	@Column(name = "productname")
	@NotNull
	private String pname;
	@Column(name = "quantity")
	@NotNull
	private Integer quantity;
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public OrderItem(String pcode, String pname, Integer quantity) {
		super();
		this.pcode = pcode;
		this.pname = pname;
		this.quantity = quantity;
	}
	public OrderItem() {

	}
	
}
