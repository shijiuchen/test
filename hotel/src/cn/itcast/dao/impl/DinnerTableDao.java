package cn.itcast.dao.impl;

import java.util.List;


import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.IDinnerTableDao;
import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;
import cn.itcast.utils.JdbcUtils;
/**
 * IDinnerTableDao接口实现类
 * @author shijiuchen1996
 *
 */
public class DinnerTableDao implements IDinnerTableDao{

	@Override
	public DinnerTable findById(int id) {
		String sql = "select * from dinnerTable where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<DinnerTable>(DinnerTable.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<DinnerTable> findByStatus(TableStatus ts) {
		String sql = "select * from dinnerTable where tableStatus=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class), ts.ordinal());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<DinnerTable> getAll() {
		String sql = "select * from dinnerTable";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from dinnerTable where id = ?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(DinnerTable table) {
		// TODO Auto-generated method stub
		String sql = "update dinnerTable set tableStatus=? where id = ?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, table.getTableStatus(),table.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(DinnerTable table) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO dinnerTable(tableName,tableStatus,orderDate) VALUES(?,0,null)";
		try {
			JdbcUtils.getQuerrRunner().update(sql,table.getTableName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
