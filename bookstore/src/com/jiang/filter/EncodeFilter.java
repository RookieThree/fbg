package com.jiang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jiang.util.StringUtil;

public class EncodeFilter implements Filter {
	private String encoding="UTF-8";
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);;
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		String ss = fConfig.getInitParameter("encoding");
		if (StringUtil.isNotBlank(ss)) {
			encoding = ss.trim();
		}
		
	}

}
