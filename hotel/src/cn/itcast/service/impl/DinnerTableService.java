package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IDinnerTableDao;
import cn.itcast.dao.impl.DinnerTableDao;
import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IDinnerTableService;
/**
 * 业务服务接口实现类
 * @author shijiuchen1996
 *
 */
public class DinnerTableService implements IDinnerTableService {

	private IDinnerTableDao dinnerTableDao = BeanFactory.getInstance(
			"dinnerTableDao", IDinnerTableDao.class);

	@Override
	public DinnerTable findById(int id) {
		try {
			return dinnerTableDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<DinnerTable> findNoUseTable() {
		try {
			return dinnerTableDao.findByStatus(TableStatus.Free);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<DinnerTable> getAll() {
		try {
			return dinnerTableDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			dinnerTableDao.delete(id);;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(DinnerTable table) {
		// TODO Auto-generated method stub
		try {
			dinnerTableDao.update(table);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(DinnerTable table) {
		// TODO Auto-generated method stub
		try {
			dinnerTableDao.save(table);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
