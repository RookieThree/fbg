package com.jiang.util;

import com.jiang.dao.IBookDao;
import com.jiang.dao.ICatalogDao;
import com.jiang.dao.IOrderDao;
import com.jiang.dao.IUserDao;
import com.jiang.dao.impl.BookDaoImpl;
import com.jiang.dao.impl.CatalogDaoImpl;
import com.jiang.dao.impl.OrderDaoImpl;
import com.jiang.dao.impl.UserDaoImpl;

public class DaoFactory {
	public static IBookDao getBookDao(){
		return new BookDaoImpl();
	}
	
	public static ICatalogDao getCatalogDao(){
		return new CatalogDaoImpl();
	}
	
	public static IUserDao getUserDao(){
		return new UserDaoImpl();
	}
	
	public static IOrderDao getOrderDao(){
		return new OrderDaoImpl();
	}
}
