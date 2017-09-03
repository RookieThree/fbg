package com.jiang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jiang.dao.IBookDao;
import com.jiang.domain.PageBean;
import com.jiang.entity.BookBean;
import com.jiang.util.ConnectionManager;

public class BookDaoImpl implements IBookDao {

	@Override
	public List<BookBean> getByPage(BookBean book,PageBean pages) throws Exception {
		Connection conn = null;
		List<BookBean> res = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs  =null;
		StringBuilder sql = new StringBuilder(
				"select b.*,c.title ctitle from t_books b left join t_catalogs c on b.catalog_id=c.id where 1=1 ");
		if (book!=null) {
			if (book.getCatalog().getId()!=null) {
				sql.append(" and b.catalog_id=").append(book.getCatalog().getId());
			}
			if (book.getTitle()!=null) {
				sql.append(" and b.title like '").append(book.getTitle()).append("'");
			}
		}
		try {
			conn = ConnectionManager.getConnection();
			if (pages!=null && pages.getRowsPerpage()>0) {
				if (pages.getPageNum()<1) {
					pages.setPageNum(1);
				}
				if (pages.getMaxPage()<1) {
					int rowsNum=0;
					String ss = "select count(*)"+ sql.substring(sql.indexOf(" from "));
					ps = conn.prepareStatement(ss);
					rs = ps.executeQuery();
					if (rs.next()) {
						rowsNum = rs.getInt(1);
					}
					if (rowsNum<1) {
						return res;
					}
					int maxPage = rowsNum/pages.getRowsPerpage();
					if (rowsNum%pages.getRowsPerpage()!=0) {
						maxPage++;
					}
					
					pages.setMaxPage(maxPage);
					pages.setRowsNum(rowsNum);
				}
				if (pages.getPageNum()>pages.getMaxPage()) {
					pages.setPageNum(pages.getMaxPage());
				}
				/**
				 * Oracle�з�ҳ��ѯ��ʽ������ʽ��ҳ����
				 * select * from (
				 * 		select rownum rn,t.*
				 * 				(����Ĳ���������select * from t_catalogs) t  ����������Ҫִ�еĲ�ѯ����
				 * 		where rownum<=(ҳ��ֵ)*ÿҳ����   Ŀ������ȥ��������������ݣ����ǰ���ǰ����������
				 * ) where rn >(ҳ��ֵ-1)* ÿҳ����   Ŀ������ȥ��ǰ����������
				 */
				sql.insert(0, "select * from (select rownum rn,t.* from (");
				sql.append(" order by b.id desc) t where rownum<=").append(pages.getPageNum()*pages.getRowsPerpage())
					.append(") where rn>").append((pages.getPageNum()-1)
						*pages.getRowsPerpage());
				/*sql = "select * from (select rownum rn,t.* from ("+sql
						+" order by b.id desc) t where rownum<="
						+(pages.getPageNum()*pages.getRowsPerpage())
						+") where rn>"+(pages.getPageNum()-1)
						*pages.getRowsPerpage();*/
			}
			//System.out.println(sql);
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				BookBean temp = new BookBean();
				temp.setId(rs.getLong("id"));
				temp.setTitle(rs.getString("title"));
				temp.getCatalog().setId(rs.getLong("catalog_id"));
				temp.setUnit(rs.getString("unit"));
				temp.setPrice(rs.getDouble("price"));
				temp.setPic(rs.getString("pic"));
				temp.getCatalog().setTitle(rs.getString("ctitle"));
				res.add(temp);
			}
			ps.close();
			rs.close();
		} finally {
			ConnectionManager.closeConnection(conn);;
		}
		return res;
	}
	
	/*public static void main(String[] args) throws Exception {
		IBookDao book  = DaoFactory.getBookDao();
		PageBean pages = new PageBean();
		pages.setPageNum(2);
		pages.setRowsPerpage(1);
		List<BookBean> blist = book.getByPage(null, pages);
		for (BookBean bookBean : blist) {
			//System.out.println(bookBean);
		}
	}*/

	@Override
	public BookBean load(Long id) throws Exception {
		BookBean res = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_books where id=?";
		try{
			conn = ConnectionManager.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				res = new BookBean();
				res.setId(rs.getLong("id"));
				res.setTitle(rs.getString("title"));
				res.getCatalog().setId(rs.getLong("catalog_id"));
				res.setPic(rs.getString("pic"));
				res.setPrice(rs.getDouble("price"));
				res.setUnit(rs.getString("unit"));
			}
			ps.close();
			rs.close();
		}finally{
			ConnectionManager.closeConnection(conn);
		}
		return res;
	}
}
