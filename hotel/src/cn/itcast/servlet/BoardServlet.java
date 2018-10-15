package cn.itcast.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.service.IDinnerTableService;
/**
 * 餐桌操作servlet
 * @author shijiuchen1996
 *
 */
public class BoardServlet extends BaseServlet {
	
	public Object list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Object uri = null;
		List<DinnerTable> boardList = dinnerTableService.getAll( );
		request.setAttribute("boardList", boardList);
		uri = request.getRequestDispatcher("/sys/boardList.jsp");		
		return uri;
	}
	
	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		
		String id = request.getParameter("id");
	
		dinnerTableService.delete(Integer.parseInt(id));

		uri = "/board?method=list";
		return uri;
	}
	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		String id = request.getParameter("id");
		DinnerTable table = dinnerTableService.findById(Integer.parseInt(request.getParameter("id")));
		
		if(table.getTableStatus()==1)
			table.setTableStatus(0);
		else
			table.setTableStatus(1);
		

		dinnerTableService.update(table);
		
		uri = "/board?method=list";
		return uri;
	}
	/**
	 * 添加新的餐桌
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public Object addBoardType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		
		String BoardName = request.getParameter("bName");
		DinnerTable table = new DinnerTable();
		table.setTableName(BoardName);

		dinnerTableService.save(table);
		//System.out.println("aaa");

		uri = request.getRequestDispatcher("/board?method=list");

		return uri;

	}
}
