package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.FoodType;

/**
 * 业务逻辑层食物种类接口
 * @author shijiuchen1996
 *
 */
public interface IFoodTypeService {



	void save(FoodType foodType);
	

	void update(FoodType foodType);
	

	void delete(int id);
	

	FoodType findById(int id);
	
	FoodType findByName(String name);

	List<FoodType> getAll();
	
	List<FoodType> getAll(String typeName);
	
	
}









