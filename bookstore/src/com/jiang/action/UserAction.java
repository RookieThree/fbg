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
			errs.put("username","用户名必须填写");
		}
		if (StringUtil.isBlank(password)) {
			errs.put("password", "密码必须填写");
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
				session.setAttribute("msg", "登陆失败请重新的登陆");
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
			err.put("username","用户名不能为空");	
		}else{
			boolean bb=true; 
			try {
				bb = udao.existsName(username);
			} catch (Exception e) {
				bb=true;
			}
			if (bb) 
				err.put("username","用户名已经存在");
		}
		String password = request.getParameter("password");
		if (StringUtil.isBlank(password)) 
			err.put("password", "密码不能为空");
		String repassword = request.getParameter("repassword");
		if (StringUtil.isBlank(repassword)) 
			err.put("repassword", "确认密码不能为空");
		else{
			if (!repassword.equals(password)) 
				err.put("repassword", "两次密码不一致");
		}
		String realname = request.getParameter("realname");
		if (StringUtil.isBlank(realname)) 
			err.put("realname", "真实姓名不能为空");
		String ssex = request.getParameter("sex");
		boolean sex = "true".equals(ssex);
		String addr = request.getParameter("addr");
		if (StringUtil.isBlank(addr))
			err.put("addr", "地址不能为空");
		String postcode = request.getParameter("postcode");
		String tel = request.getParameter("tel");
		if (StringUtil.isBlank(tel)) 
			err.put("tel", "电话不能为空");
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
