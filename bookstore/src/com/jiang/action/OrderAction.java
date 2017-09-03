package com.jiang.action;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiang.dao.IOrderDao;
import com.jiang.domain.ShopCart;
import com.jiang.domain.ShopItem;
import com.jiang.entity.OrderBean;
import com.jiang.entity.OrderItemBean;
import com.jiang.entity.UserBean;
import com.jiang.util.DaoFactory;
import com.jiang.util.StringUtil;

public class OrderAction extends BaseAction {
	private static final long serialVersionUID = -122618760370089900L;
	private IOrderDao orderDao = DaoFactory.getOrderDao();
	@Override
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderBean order = new OrderBean();
		HttpSession session = request.getSession();
		ShopCart cart = null;
		Object obj = session.getAttribute("mycart");
		if (obj!=null && obj instanceof ShopCart) {
			cart = (ShopCart)obj;
		}
		if (cart.getAllItems()!=null && cart.getAllItems().size()>0) {
			Collection<ShopItem> items = cart.getAllItems();
			for (ShopItem it : items) {
				OrderItemBean temp = new OrderItemBean();
				temp.setBook(it.getBook());
				temp.setNum(it.getNum());
				temp.setPrice(it.getBook().getPrice());
				order.getItems().add(temp);
			}
			order.setAllPrice(cart.getAllPrice());
		}
		obj = session.getAttribute("user");
		UserBean user = null;
		if (obj!=null && obj instanceof UserBean) {
			user = (UserBean)obj;
		}
		String realname = request.getParameter("realname");
		user.setRealname(realname);
		String addr = request.getParameter("addr");
		user.setAddr(addr);
		String postcode= request.getParameter("postcode");
		if (StringUtil.isNotBlank(postcode)) {
			user.setPostcode(postcode);
		}
		String tel = request.getParameter("tel");
		user.setTel(tel);
		String email = request.getParameter("email");
		if (StringUtil.isNotBlank(email)) {
			user.setEmail(email);
		}
		order.setUser(user);
		try {
			Long orderId = orderDao.order(order);
			if (orderId!=null) {
				session.removeAttribute("mycart");
				response.sendRedirect(this.getServletContext().getContextPath()+"/order/info.jsp?id="+orderId);
			}else{
				request.getRequestDispatcher("/order/list.jsp").forward(request, response);
			}
		} catch (Exception e) {
			this.getServletContext().log(this.getClass().getName(),e);
			throw new ServletException(e);
		}
	}
	public void order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.getRequestDispatcher("/order/list.jsp").forward(request, response);
	}

}
