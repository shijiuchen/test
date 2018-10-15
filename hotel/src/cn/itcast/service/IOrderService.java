package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Order;
/**
 * 业务逻辑层订单接口
 * @author shijiuchen1996
 *
 */
public interface IOrderService {
	/**
	 * 更新是否结账状态
	 * @param orderType
	 */
	void update(Order orderType);
	
	/**
	 * 通过主键查找
	 * @param id
	 * @return
	 */
	Order findById(int id);
	
	/**
	 * 得到所有订单
	 * @return
	 */
	List<Order> getAll();
}
