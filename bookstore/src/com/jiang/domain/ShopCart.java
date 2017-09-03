package com.jiang.domain;
/**
 * 购物车
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.jiang.entity.BookBean;

public class ShopCart implements Serializable {
	private static final long serialVersionUID = -2043873560397731956L;
	private Map<Long, ShopItem> cart = new HashMap<>();
	
	//添加商品
	public void add(BookBean book){
		ShopItem item = null;
		if (cart.containsKey(book.getId())) {
			item = cart.get(book.getId());
			item.setNum(item.getNum()+1);
		}else{
			item = new ShopItem(book);
		}
		cart.put(book.getId(), item);
	}
	
	//获取所有的商品
	public Collection<ShopItem> getAllItems(){
		return cart.values();
	}
	
	//获取所有的商品的总价格
	public double getAllPrice(){
		double res =0;
		for (ShopItem it : getAllItems()) {
			res+=it.getAllPrice();
		}
		return res;
	}
	
	//清空购物车
	public void clear(){
		cart.clear();
	}

	//修改商品数量
	public void modify(Long id, Integer num) {
		if (cart.containsKey(id)) {
			if (num>0) {
				ShopItem item = cart.get(id);
				item.setNum(num);
			}else{
				cart.remove(id);
			}
		}
	}

	public void remove(Long id) {
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		
	}
}
