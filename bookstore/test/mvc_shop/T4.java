package mvc_shop;

import com.jiang.dao.IOrderDao;
import com.jiang.entity.OrderBean;
import com.jiang.entity.OrderItemBean;
import com.jiang.util.DaoFactory;

public class T4 {
	public static void main(String[] args) throws Exception {
		IOrderDao orderDao = DaoFactory.getOrderDao();
		OrderBean order = new OrderBean();
		order.getUser().setId(7L);
		order.getUser().setAddr("»ªÉ½");
		order.getUser().setTel("12232");
		order.getUser().setRealname("Áîºü³¤´º");
		order.setAllPrice(8.0);
		OrderItemBean item1 = new OrderItemBean();
		item1.getBook().setId(3L);
		item1.getBook().setPrice(3.0d);
		item1.setNum(4);
		order.getItems().add(item1);
		long pid = orderDao.order(order);
		System.out.println(pid);
	}
}
