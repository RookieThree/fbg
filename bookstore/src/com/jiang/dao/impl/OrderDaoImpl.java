package com.jiang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jiang.dao.IOrderDao;
import com.jiang.entity.OrderBean;
import com.jiang.entity.OrderItemBean;
import com.jiang.util.ConnectionManager;
import com.jiang.util.StringUtil;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public Long order(OrderBean order) throws Exception {
		Long res = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean autoCommit = true;
		try{
			conn = ConnectionManager.getConnection();
			autoCommit = conn.getAutoCommit();//获取默认的提交方式
			conn.setAutoCommit(false);//关闭自动提交
			StringBuilder sb1 = new StringBuilder("insert into t_order(id,user_id,realname,tel,addr");
			StringBuilder sb2 = new StringBuilder(") values(seq_order.nextval,?,?,?,?");
			List<Object> params = new ArrayList<>();
			params.add(order.getUser().getId());
			params.add(order.getUser().getRealname());
			params.add(order.getUser().getTel());
			params.add(order.getUser().getAddr());
			if (StringUtil.isNotBlank(order.getUser().getEmail())) {
				sb1.append(",email");
				sb2.append(",?");
				params.add(order.getUser().getEmail());
			}
			if (StringUtil.isNotBlank(order.getUser().getPostcode())) {
				sb1.append(",postcode");
				sb2.append(",?");
				params.add(order.getUser().getPostcode());
			}
			if (order.getAllPrice()!=null) {
				sb1.append(",all_price");
				sb2.append(",?");
				params.add(order.getAllPrice());
			}
			String sql = sb1.toString() +sb2.toString()+")";
			ps = conn.prepareStatement(sql);
			if (params!=null && params.size()>0) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i+1, params.get(i));
				}
			}
			int len = ps.executeUpdate();
			res = null;
			if (len>0) {
				ps = conn.prepareStatement("select seq_order.currval from dual");
				rs = ps.executeQuery();
				if (rs.next()) {
					res = rs.getLong(1);
				}
			}
			Set<OrderItemBean> items= order.getItems();
			sql = "insert into t_items(id,order_id,book_id,price,num) values(seq_item.nextval,?,?,?,?)";
			if (res!=null && items!=null && items.size()>0) {
				ps = conn.prepareStatement(sql);
				for (OrderItemBean temp : items) {
					ps.setLong(1, res);
					ps.setLong(2, temp.getBook().getId());
					ps.setDouble(3, temp.getBook().getPrice());
					ps.setInt(4, temp.getNum());
					ps.executeUpdate();
				}
			}
			conn.commit();
			ps.close();
			rs.close();
		}catch(Exception ex){
			if (conn!=null) {
				conn.rollback();
			}
			throw ex;
		}finally{
			if (conn!=null) {
				conn.setAutoCommit(autoCommit);
			}
			ConnectionManager.closeConnection(conn);
		}
		return res;
	}

}
