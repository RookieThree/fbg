package com.jiang.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jiang.dao.ICatalogDao;
import com.jiang.entity.CatalogBean;
import com.jiang.util.DaoFactory;

public class CatalogListener implements ServletContextListener {
 
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext application = arg0.getServletContext();
		application.removeAttribute("catalogList");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext application = arg0.getServletContext();
		ICatalogDao cdao = DaoFactory.getCatalogDao();
		try {
			List<CatalogBean> clist = cdao.getAll();
			application.setAttribute("catalogList", clist);
		} catch (Exception e) {
			//将异常记录到系统日志中
			application.log(this.getClass().getName(),e);
		}
	}

}
