package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.FoodType;
/**
 * 业务逻辑层餐桌接口
 * @author shijiuchen1996
 *
 */
public interface IDinnerTableService {

	List<DinnerTable> findNoUseTable();
	
	DinnerTable findById(int id);
	
	List<DinnerTable> getAll();
	
	void delete(int id);
	
	void update(DinnerTable table);
	
	void save(DinnerTable table);
}
