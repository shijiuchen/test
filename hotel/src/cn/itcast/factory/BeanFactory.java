package cn.itcast.factory;

import java.util.ResourceBundle;

import cn.itcast.dao.IFoodTypeDao;

/**
 * 用于创建Dao和Service实例
 * @author shijiuchen1996
 *
 */
public class BeanFactory {
	
	// 用于加载配置文件
	private static ResourceBundle bundle;
	static {
		bundle = ResourceBundle.getBundle("instance");
	}

	/**
	 * 根据指定的key，读取配置文件获取类的全路径，创建对象
	 * @return 泛型方法
	 */
	public static <T> T getInstance(String key,Class<T> clazz) {
		String className = bundle.getString(key);//获取类的全名
		try {
			return (T) Class.forName(className).newInstance();//返回新创建的对象
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}










