package com.jiang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jiang.dao.IUserDao;
import com.jiang.entity.UserBean;
import com.jiang.util.ConnectionManager;

public class UserDaoImpl implements IUserDao {

	@Override
	public void create(UserBean user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = ConnectionManager.getConnection();
			StringBuilder sb1 = new StringBuilder("insert into t_users(id,username,password,realname,addr,tel");
			StringBuilder sb2 = new StringBuilder(" ) values(seq_users.nextval,?,?,?,?,?");
			List<Object> params = new ArrayList<>();
			params.add(user.getUsername());
			params.add(user.getPassword());
			params.add(user.getRealname());
			params.add(user.getAddr());
			params.add(user.getTel());
			if (user.getSex()!=null) {
				sb1.append(",sex");
				sb2.append(",?");
				params.add(user.getSex());
			}
			if (user.getPostcode()!=null && user.getPostcode().trim().length()>0) {
				sb1.append(",postcode");
				sb2.append(",?");
				params.add(user.getPostcode());
			}
			if (user.getEmail()!=null && user.getEmail().trim().length()>0) {
				sb1.append(",email");
				sb2.append(",?");
				params.add(user.getEmail());
			}
		
			String sql = sb1.toString()+sb2.toString()+" ) ";
			ps = conn.prepareStatement(sql);
			if (params!=null && params.size()>0) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i+1, params.get(i));
				}
			}
			ps.executeUpdate();
			ps.close();
		}finally{
			ConnectionManager.closeConnection(conn);
		}
		
	}

	@Override
	public boolean existsName(String username) throws Exception {
		boolean res = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = ConnectionManager.getConnection();
			String sql = "select * from t_users where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			res = rs.next();
			ps.close();
			rs.close();
		}finally{
			ConnectionManager.closeConnection(conn);
		}
		return res;
	}

	@Override
	public boolean login(UserBean user) throws Exception{
		boolean res = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_users where username=? and password=? and locked=0";
		try {
			conn = ConnectionManager.getConnection();
			ps =conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getLong("id"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));
				user.setLocked(rs.getBoolean("locked"));
				user.setRealname(rs.getString("realname"));
				user.setSex(rs.getBoolean("sex"));
				user.setPostcode(rs.getString("postcode"));
				user.setTel(rs.getString("tel"));
				res = true;
			}
			ps.close();
			rs.close();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return res;
	}

}
