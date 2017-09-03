package com.jiang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jiang.dao.ICatalogDao;
import com.jiang.entity.CatalogBean;
import com.jiang.util.ConnectionManager;

public class CatalogDaoImpl implements ICatalogDao {
	@Override
	public List<CatalogBean> getAll() throws Exception {
		List<CatalogBean> res = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_catalogs";
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CatalogBean cat = new CatalogBean();
				cat.setId(rs.getLong("id"));
				cat.setTitle(rs.getString("title"));
				res.add(cat);
			}
		} finally{
			ConnectionManager.closeConnection(conn);
		}
		return res;
	}

	@Override
	public CatalogBean load(Long catalogId) throws Exception {
		CatalogBean res = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_catalogs where id=?";
		try {
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, catalogId);
			rs = ps.executeQuery();
			if (rs.next()) {
				res = new CatalogBean();
				res.setId(rs.getLong("id"));
				res.setTitle(rs.getString("title"));
			}
			ps.close();
			rs.close();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return res;
	}

}
