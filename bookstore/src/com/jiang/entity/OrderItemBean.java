package com.jiang.entity;

public class OrderItemBean extends BaseBean {
	private static final long serialVersionUID = 5294091482159439180L;
	private Long id;
	private BookBean book = new BookBean();
	private Double price;
	private Integer num;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BookBean getBook() {
		return book;
	}
	public void setBook(BookBean book) {
		this.book = book;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
