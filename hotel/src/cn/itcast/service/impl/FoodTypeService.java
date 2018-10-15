package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IFoodTypeDao;
import cn.itcast.dao.impl.FoodTypeDao;
import cn.itcast.entity.FoodType;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodTypeService;

/**
 * 业务服务接口实现类
 * @author shijiuchen1996
 *
 */
public class FoodTypeService implements IFoodTypeService {

	//使用工厂创建对象，发生改变时不需要修改
	private IFoodTypeDao foodTypeDao = BeanFactory.getInstance("foodtypeDao", IFoodTypeDao.class);

	@Override
	public void delete(int id) {

		try {
			foodTypeDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public FoodType findById(int id) {

		try {
			return foodTypeDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll() {
		try {
			return foodTypeDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll(String typeName) {

		try {
			return foodTypeDao.getAll(typeName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(FoodType foodType) {
		try {
			foodTypeDao.save(foodType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(FoodType foodType) {
		try {
			foodTypeDao.update(foodType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public FoodType findByName(String name) {
		try {
			return foodTypeDao.findByName(name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
