package com.jiang.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.dao.IBookDao;
import com.jiang.dao.ICatalogDao;
import com.jiang.domain.PageBean;
import com.jiang.entity.BookBean;
import com.jiang.entity.CatalogBean;
import com.jiang.util.DaoFactory;
import com.jiang.util.StringUtil;

public class BooksAction extends BaseAction {
	private static final long serialVersionUID = 6597663461385225523L;
	private IBookDao bookDao = DaoFactory.getBookDao();
	private ICatalogDao catalogDao  =DaoFactory.getCatalogDao();
	
	@Override
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�������ڸ�ʽ
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime=null;
		//�����������л�ȡcookies
		Cookie[] cks = request.getCookies();
		//�жϣ������Ϊ�վͱ�����ͬʱ��ȥ����ֵ������ǰʱ��
		if (cks!=null && cks.length>0) {
			for (Cookie temp : cks) {
				if ("nowTime".equals(temp.getName())) {
					nowTime=temp.getValue();
					break;
				}
			}
		}
		String lastTime=null;
		//�жϣ������ǰʱ�䲻Ϊ�յĻ�,�ͽ���ǰʱ��任Ϊ�ϴε�½ʱ��
		if (StringUtil.isNotBlank(nowTime)) {
			lastTime=nowTime;
		}
		
		nowTime=df.format(new Date());
		Cookie ck1 = new Cookie("nowTime", nowTime);
		ck1.setMaxAge(Integer.MAX_VALUE);
		Cookie ck2 = new Cookie("lastTime", lastTime);
		ck2.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(ck1);
		response.addCookie(ck2);
		
		PageBean pages = new PageBean();
		String ss = request.getParameter("page");
		int pageNum=0;
		try {
			pageNum=Integer.parseInt(ss);
		} catch (Exception e) {
			pageNum=1;
		}
		pages.setPageNum(pageNum);
		pages.setRowsPerpage(2);
		ss = request.getParameter("cid");
		BookBean book = new BookBean();
		Long catalogId=null;
		try {
			catalogId = Long.parseLong(ss);
			if (catalogId!=null) {
				CatalogBean catalog = catalogDao.load(catalogId);
				request.setAttribute("catalog", catalog);
				book.setCatalog(catalog);
			}
		} catch (Exception e) {
			catalogId = null;
		}
		ss =request.getParameter("keyword");
		if (StringUtil.isNotBlank(ss)) {
			//��������һҳ��ʱ�򣬵�ַ�����ʹĬ��getת���ģ���˻�������ݻ��ǲ��ԣ�������Ҫ�ֶ�����get����ı���
			if ("get".equalsIgnoreCase(request.getMethod())) {
				ss = new String(ss.getBytes("iso8859-1"),"GBK");
			}
			request.setAttribute("keyword", ss);
			book.setTitle("%"+ss.trim()+"%");
		}
		try {
			List<BookBean> blist = bookDao.getByPage(book,pages);
			request.setAttribute("bookList", blist);
			request.setAttribute("pages", pages);
			request.getRequestDispatcher("/books/list.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
