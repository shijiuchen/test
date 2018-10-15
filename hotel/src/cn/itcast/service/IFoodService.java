package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Food;
import cn.itcast.utils.PageBean;
/**
 * 业务逻辑层食物接口
 * @author shijiuchen1996
 *
 */
public interface IFoodService {

	Food findById(int id);

	void getAll(PageBean<Food> pb);
	
	void insertFood(Food food);
	
	List<Food> getAll();
	
	void delete(int id);
	
	void update(Food food);
}
