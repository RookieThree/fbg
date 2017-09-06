package com.jiang.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action==null|| action.trim().length()<1) {
			action = "list";
		}
		Class<? extends BaseAction> clz = this.getClass();
		try {
			Method method = clz.getMethod(action,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	public abstract void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
