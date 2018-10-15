package cn.itcast.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.FoodType;
import cn.itcast.entity.Order;

public class OrderServlet extends BaseServlet{
	
	public Object list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object uri = null;
		
		List<Order> list = orderService.getAll();
		System.out.println(list.size());
		
		request.setAttribute("listOrderType", list);
		
		uri = request.getRequestDispatcher("/sys/orderList.jsp");

		return uri;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		String id = request.getParameter("id");
		Order order = orderService.findById(Integer.parseInt(request.getParameter("id")));
		
		if(order.getOrderStatus()==1)
			order.setOrderStatus(0);
		else
			order.setOrderStatus(1);
		
		orderService.update(order);
		uri = "/order?method=list";
		return uri;
	}
}
