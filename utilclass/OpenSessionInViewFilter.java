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
			MybatisSessionFactory.commitTransaction();//如果在整个请求处理过程中，没有出现异常则手动提交事务
		} catch (Exception e) {
			MybatisSessionFactory.rollbackTransaction();//如果在整个请求处理过程中出现异常则回滚事务，注意：这里不要消费掉异常
			throw new ServletException(e);
		} finally {
			MybatisSessionFactory.closeSqlSession();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
