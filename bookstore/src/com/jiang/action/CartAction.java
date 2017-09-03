package com.jiang.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiang.action.BaseAction;
import com.jiang.dao.IBookDao;
import com.jiang.domain.ShopCart;
import com.jiang.entity.BookBean;
import com.jiang.util.DaoFactory;

public class CartAction extends BaseAction {
	private static final long serialVersionUID = -4839210346643183353L;
	private IBookDao bookDao = DaoFactory.getBookDao();

	@Override
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/cart/list.jsp").forward(request, response);
	}
	
	
	public void remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ss = request.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(ss);
		} catch (Exception e) {
			id = null;
		}
		ShopCart cart = null;
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("mycart");
		if (obj!=null&&obj instanceof ShopCart) {
			cart = (ShopCart)obj;
		}
		if (cart!=null && id!=null) {			
			cart.remove(id);
		}
		response.sendRedirect(this.getServletContext().
				getContextPath()+"/cart.do");
	}
	
	//修改商品数量
	public void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		String[] nums = request.getParameterValues("nums");
		ShopCart cart = null;
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("mycart");
		if (obj!=null && obj instanceof ShopCart) {
			cart = (ShopCart)obj;
		}
		if (ids!=null &&ids.length>0) {
			for (int i = 0; i < ids.length; i++) {
				try {
					Long id = Long.parseLong(ids[i]);
					Integer num = Integer.parseInt(nums[i]);
					cart.modify(id,num);
				} catch (Exception e) {
					throw new ServletException(e);
				}
			}
			response.sendRedirect(this.getServletContext().
					getContextPath()+"/cart.do");
		}
	}
	
	
	public void clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShopCart cart = null;
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("mycart");
		if (obj!=null&& obj instanceof ShopCart) {
			cart = (ShopCart)obj;
		}
		cart.clear();
		response.sendRedirect(this.getServletContext().getContextPath()+"/cart.do");
	}

	public void buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		try {
			Long id = Long.parseLong(sid);
			BookBean book = bookDao.load(id);
			ShopCart cart = new ShopCart();
			// 从session中找是否有购买的书
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("mycart");
			if (obj != null && obj instanceof ShopCart) {
				cart = (ShopCart) obj;
			}
			if (book != null) {
				cart.add(book);
			}
			session.setAttribute("mycart", cart);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/cart/info.jsp").forward(request,
				response);
	}

}
