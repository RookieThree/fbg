package com.jiang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiang.dao.IUserDao;
import com.jiang.entity.UserBean;
import com.jiang.util.DaoFactory;
import com.jiang.util.StringUtil;



public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1966771482109384106L;
	private IUserDao udao = DaoFactory.getUserDao();
	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
		Map<String, String> errs = new HashMap<>();
		if (StringUtil.isBlank(username)) {
			errs.put("username","�û���������д");
		}
		if (StringUtil.isBlank(password)) {
			errs.put("password", "���������д");
		}
		HttpSession session = request.getSession();
		if (!errs.isEmpty()) {
			session.setAttribute("errors", errs);
			response.sendRedirect(url);
			return;
		}
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		try {
			boolean bb = udao.login(user);
			if (bb) {
				session.setAttribute("user", user);
			}else{
				session.setAttribute("msg", "��½ʧ�������µĵ�½");
			}
			response.sendRedirect(url);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	public void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		boolean bb = true;
		try {
			bb = udao.existsName(username);
		} catch (Exception e) {
			bb=true;
		}
		out.print(!bb);
		out.flush();
		out.close();
	}

		
	@Override
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> err= new HashMap<>();
		String username = request.getParameter("username");
		if (StringUtil.isBlank(username)){
			err.put("username","�û�������Ϊ��");	
		}else{
			boolean bb=true; 
			try {
				bb = udao.existsName(username);
			} catch (Exception e) {
				bb=true;
			}
			if (bb) 
				err.put("username","�û����Ѿ�����");
		}
		String password = request.getParameter("password");
		if (StringUtil.isBlank(password)) 
			err.put("password", "���벻��Ϊ��");
		String repassword = request.getParameter("repassword");
		if (StringUtil.isBlank(repassword)) 
			err.put("repassword", "ȷ�����벻��Ϊ��");
		else{
			if (!repassword.equals(password)) 
				err.put("repassword", "�������벻һ��");
		}
		String realname = request.getParameter("realname");
		if (StringUtil.isBlank(realname)) 
			err.put("realname", "��ʵ��������Ϊ��");
		String ssex = request.getParameter("sex");
		boolean sex = "true".equals(ssex);
		String addr = request.getParameter("addr");
		if (StringUtil.isBlank(addr))
			err.put("addr", "��ַ����Ϊ��");
		String postcode = request.getParameter("postcode");
		String tel = request.getParameter("tel");
		if (StringUtil.isBlank(tel)) 
			err.put("tel", "�绰����Ϊ��");
		String email = request.getParameter("email");
		if (!err.isEmpty()) {
			request.setAttribute("errors", err);
			request.getRequestDispatcher("/user/add.jsp").forward(request, response);
			return;
		}
		UserBean user = new UserBean();
		user.setUsername(username); 
		user.setPassword(password);
		user.setRealname(realname);
		user.setSex(sex);
		user.setAddr(addr);
		user.setPostcode(postcode);
		user.setTel(tel);
		user.setEmail(email);
		try {
			udao.create(user);
			response.sendRedirect(this.getServletContext().getContextPath()+"/user/info.jsp");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	public void toadd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/user/add.jsp")
				.forward(request, response);
	}

}
