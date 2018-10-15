package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IOrderDao;
import cn.itcast.entity.Order;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IOrderService;
/**
 * 业务服务接口实现类
 * @author shijiuchen1996
 *
 */
public class OrderService implements IOrderService{

	
	private IOrderDao orderDao = BeanFactory.getInstance("orderDao", IOrderDao.class);
	@Override
	public void update(Order orderType) {
		// TODO Auto-generated method stub
		try {
			orderDao.update(orderType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		try {
			return orderDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		try {
			return orderDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
