package com.jiang.dao;

import com.jiang.entity.OrderBean;

public interface IOrderDao {
	public Long order(OrderBean order) throws Exception;
}
