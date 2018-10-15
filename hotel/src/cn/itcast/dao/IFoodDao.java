package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Food;
import cn.itcast.utils.PageBean;

/**
 * 食品Dao模式接口
 * @author shijiuchen1996
 *
 */
public interface IFoodDao {

	/**
	 * 得到所有的食物，分页模式
	 * @param pb
	 */
	void getAll(PageBean<Food> pb);
	
	/**
	 * 得到数据库中一共有多少种食物
	 * @param pb
	 * @return
	 */
	int getTotalCount(PageBean<Food> pb);
	
	/**
	 * 通过餐桌id进行查找
	 * @param id
	 * @return
	 */
	Food findById(int id);
	/**
	 * 插入食物
	 * @param food
	 */
	void insertFood(Food food);
	/**
	 * 获取所有食物
	 * @return
	 */
	List<Food> getAll();
	/**
	 * 删除食物
	 * @param id
	 */
	void delete(int id);
	/**
	 * 更新食物
	 * @param food
	 */
	void update(Food food);
}
