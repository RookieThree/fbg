 package com.jiang.dao;

import java.util.List;

import com.jiang.entity.CatalogBean;

public interface ICatalogDao {
	public List<CatalogBean> getAll() throws Exception;
	
	public CatalogBean load(Long catalogId) throws Exception;
}
