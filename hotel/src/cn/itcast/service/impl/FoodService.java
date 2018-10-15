package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IFoodDao;
import cn.itcast.entity.Food;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodService;
import cn.itcast.utils.PageBean;
/**
 * 业务服务接口实现类
 * @author shijiuchen1996
 *
 */
public class FoodService implements IFoodService {

	private IFoodDao foodDao = BeanFactory.getInstance("foodDao", IFoodDao.class);
	
	@Override
	public Food findById(int id) {
		try {
			return foodDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void getAll(PageBean<Food> pb) {
		try {
			foodDao.getAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertFood(Food food) {
		try {
			foodDao.insertFood(food);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Food> getAll() {
		try {
			return foodDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			foodDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Food food) {
		try {
			foodDao.update(food);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
