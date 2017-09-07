package com.yan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.yan.util.MybatisSessionFactory;

@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try {
			MybatisSessionFactory.getSqlSession();
			chain.doFilter(request, response);
			MybatisSessionFactory.commitTransaction();//�������������������У�û�г����쳣���ֶ��ύ����
		} catch (Exception e) {
			MybatisSessionFactory.rollbackTransaction();//�������������������г����쳣��ع�����ע�⣺���ﲻҪ���ѵ��쳣
			throw new ServletException(e);
		} finally {
			MybatisSessionFactory.closeSqlSession();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
