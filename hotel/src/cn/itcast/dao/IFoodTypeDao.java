package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.FoodType;

/**
 * 食物品种Dao模式接口
 * @author shijiuchen1996
 *
 */
public interface IFoodTypeDao {

	/**
	 * 添加菜系
	 * @param foodType
	 */
	void save(FoodType foodType);
	
	/**
	 * 更新菜系
	 * @param foodType
	 */
	void update(FoodType foodType);
	
	/**
	 * 删除菜系
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 通过id找菜系
	 * @param id
	 * @return
	 */
	FoodType findById(int id);
	/**
	 * 通过名字找菜系
	 * @param name
	 * @return
	 */
	FoodType findByName(String name);
	
	
	List<FoodType> getAll();
	
	
	List<FoodType> getAll(String typeName);
	
	
}








