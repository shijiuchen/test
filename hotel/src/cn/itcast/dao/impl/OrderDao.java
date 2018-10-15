package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.IOrderDao;
import cn.itcast.entity.Order;
import cn.itcast.utils.JdbcUtils;
/**
 * OrderDao接口实现类
 * @author shijiuchen1996
 *
 */
public class OrderDao implements IOrderDao{

	@Override
	public void update(Order orderType) {
		String sql = "update orders set orderStatus=? where id = ?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, orderType.getOrderStatus(),orderType.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Order findById(int id) {
		String sql = "select * from orders where id = ?";
		
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<Order>(Order.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Order> getAll() {
		String sql = "select * from orders";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Order>(Order.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
