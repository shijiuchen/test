package cn.itcast.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.dao.IFoodDao;
import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.utils.Condition;
import cn.itcast.utils.JdbcUtils;
import cn.itcast.utils.PageBean;
/**
 * FoodDao接口实现类
 * @author shijiuchen1996
 *
 */
public class FoodDao implements IFoodDao{

	@Override
	public Food findById(int id) {
		String sql = "select * from food where id = ?";
		
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<Food>(Food.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void getAll(PageBean<Food> pb) {
		Condition condition = pb.getCondition();
		int typeId = condition.getFoodTypeId();
		String foodName = condition.getFoodName();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select");
		sb.append("		f.id,");
		sb.append("		f.foodName,");
		sb.append("		f.price,");
		sb.append("		f.mprice,");
		sb.append("		f.remark,");
		sb.append("		f.img,");
		sb.append("		f.foodType_id,");
		sb.append("		t.typeName ");
		sb.append("from ");
		sb.append("		food f, ");
		sb.append("		foodtype t ");
		sb.append("where 1=1");
		sb.append("		and f.foodType_id=t.id ");
		List<Object> list = new ArrayList<Object>();
		if (typeId > 0) {
			sb.append("	and f.foodType_id=?");
			list.add(typeId);
		}
		if (foodName != null && !"".equals(foodName.trim())) {
			sb.append("  and f.foodName like ?");
			list.add(foodName);
		}
		
		sb.append(" LIMIT ?,?");
		
		
		int totalCount = getTotalCount(pb);
		pb.setTotalCount(totalCount);
		
		if(pb.getCurrentPage() < 1) {
			pb.setCurrentPage(1);
		} else if (pb.getCurrentPage() > pb.getTotalPage()) {
			pb.setCurrentPage(pb.getTotalPage());
		}
		
		int index = (pb.getCurrentPage() - 1) * pb.getPageCount();
	
		int count = pb.getPageCount();
		
		list.add(index);		   
		list.add(count);		   
		
		
	
		try {
			List<Food> pageData = JdbcUtils.getQuerrRunner().
				query(sb.toString(), new BeanListHandler<Food>(Food.class),list.toArray());
		
			pb.setPageData(pageData);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalCount(PageBean<Food> pb) {
		
		Condition condition = pb.getCondition();
		
		int typeId = condition.getFoodTypeId();
		
		String foodName = condition.getFoodName();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select");
		sb.append("		count(*) ");
		sb.append("from ");
		sb.append("		food f, ");
		sb.append("		foodtype t ");
		sb.append("where 1=1");
		sb.append("		and f.foodType_id=t.id ");
		
		List<Object> list = new ArrayList<Object>();
		
		if (typeId > 0) {
			sb.append("	and f.foodType_id=?");
			list.add(typeId);  
		}
		
		if (foodName != null && !"".equals(foodName.trim())) {
			sb.append("  and f.foodName like ?");
			list.add(foodName);    
		}
		
		try {
		
			Long num = JdbcUtils.getQuerrRunner().query(sb.toString(), new ScalarHandler<Long>(),list.toArray());
			return num.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertFood(Food food) {
		String sql = "INSERT INTO food(foodName, foodType_id, price, mprice, remark, img) "
				+ "VALUES(?, ?, ?, ?, ?, ?);";
		try {
			JdbcUtils.getQuerrRunner().update(sql,food.getFoodName(), food.getFoodType_id(), 
					food.getPrice(), food.getMprice(), food.getRemark(), food.getImg());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Food> getAll() {
		String sql = "select * from food";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Food>(Food.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		
		String sql = "delete from food where id = ?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Food food) {
		String sql = "update food set foodName=?, foodType_id=?, price=?, mprice=?,"
				+ "remark=?, img=? where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, food.getFoodName(), food.getFoodType_id(), 
					food.getPrice(), food.getMprice(), food.getRemark(), food.getImg(), food.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
