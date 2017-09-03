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
			//ʹ�����÷�����ƣ���ȡ��BaseAction��������������࣬
			//ʹ��<? extends BaseAaction>����thisָ���Ķ���BaseAction���������������
			Class<? extends BaseAction> clz = this.getClass();
			//����һ�� Method ��������ӳ�� Class ��������ʾ�����ӿڵ�ָ��������Ա����
			Method method = clz.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//�Դ���ָ��������ָ����������ɴ� Method �����ʾ�ĵײ㷽��
			method.invoke(this,request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}
	
	public abstract void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
