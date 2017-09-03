package com.jiang.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jiang.util.StringUtil;

public abstract class BaseAction extends HttpServlet {
	private static final long serialVersionUID = -1809693648390904386L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (StringUtil.isBlank(action)) {
			action="list";
		}
		try {
			//使用利用反射机制，获取到BaseAction类或者这个类的子类，
			//使用<? extends BaseAaction>来让this指代的都是BaseAction类或者这个类的子类
			Class<? extends BaseAction> clz = this.getClass();
			//返回一个 Method 对象，它反映此 Class 对象所表示的类或接口的指定公共成员方法
			Method method = clz.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//对带有指定参数的指定对象调用由此 Method 对象表示的底层方法
			method.invoke(this,request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}
	
	public abstract void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
