package com.jiang.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderBean extends BaseBean {
	private static final long serialVersionUID = 8464857763367454491L;
	private Long id;
	private UserBean user = new UserBean();
	private Double allPrice;
	private Date odate;
	private Set<OrderItemBean> items = new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public Double getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(Double allPrice) {
		this.allPrice = allPrice;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public Set<OrderItemBean> getItems() {
		return items;
	}
	public void setItems(Set<OrderItemBean> items) {
		this.items = items;
	}
	
}
