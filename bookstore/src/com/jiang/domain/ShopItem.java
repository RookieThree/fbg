package com.jiang.domain;

import java.io.Serializable;

import com.jiang.entity.BookBean;

//购买项，其中封装具体购买的商品和对应的数量
public class ShopItem implements Serializable {
	private static final long serialVersionUID = 5890820405841688584L;
	private BookBean book;
	private int num;
	
	public double getAllPrice(){
		return this.num*this.book.getPrice();
	}
	public ShopItem() {
	}

	public ShopItem(BookBean book) {
		this.book = book;
		this.num = 1;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
