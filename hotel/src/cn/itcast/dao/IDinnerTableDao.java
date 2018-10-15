package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.FoodType;
import cn.itcast.entity.TableStatus;
/**
 * 餐桌Dao模式接口
 * @author shijiuchen1996
 *
 */
public interface IDinnerTableDao {

	/**
	 * 按照餐桌状态进行查找
	 * @param ts
	 * @return
	 */
	List<DinnerTable> findByStatus(TableStatus ts);

	/**
	 * 通过餐桌id进行查找
	 * @param id
	 * @return
	 */
	DinnerTable findById(int id);
	/**
	 * 显示所有餐桌信息
	 * @return
	 */
	List<DinnerTable> getAll( );
	/**
	 * 删除餐桌
	 * @param id
	 */
	void delete(int id);
	/**
	 * 更新餐桌
	 * @param table
	 */
	void update(DinnerTable table);
	/**
	 * 新增餐桌
	 * @param table
	 */
	void save(DinnerTable table);

}
