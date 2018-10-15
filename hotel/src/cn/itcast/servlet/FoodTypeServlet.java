package cn.itcast.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.FoodType;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodTypeService;
import cn.itcast.utils.WebUtils;

/**
 * 菜系servlet
 * @author shijiuchen1996
 *
 */
public class FoodTypeServlet extends BaseServlet {

	// 添加菜系
	public Object addFoodType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		// 获取请求数据
		String foodTypeName = request.getParameter("foodTypeName");
		FoodType ft = new FoodType();
		ft.setTypeName(foodTypeName);

		// 调用service具体方法
		foodTypeService.save(ft);

		//进行跳转
		uri = request.getRequestDispatcher("/foodType?method=list");

		return uri;

	}

	// 列表展示
	public Object list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object uri = null;
		// 调用service类别
		List<FoodType> list = foodTypeService.getAll();
		// 添加数据
		request.setAttribute("listFoodType", list);
		//请求转发
		uri = request.getRequestDispatcher("/sys/type/foodtype_list.jsp");

		return uri;
	}

	// 更新菜系
	public Object viewUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		
		String id = request.getParameter("id");
		
		FoodType ft = foodTypeService.findById(Integer.parseInt(id));
		
		request.setAttribute("foodType", ft);
		
		uri = request.getRequestDispatcher("/sys/type/foodtype_update.jsp");
		return uri;
	}

	// 删除菜系
	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		
		String id = request.getParameter("id");
		
		foodTypeService.delete(Integer.parseInt(id));
		
		uri = "/foodType?method=list";
		return uri;
	}

	// 更新菜系
	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("foodTypeName");
		FoodType foodType = new FoodType();
		foodType.setId(id);
		foodType.setTypeName(name);

		foodTypeService.update(foodType);
		uri = "/foodType?method=list";
		return uri;
	}

}
