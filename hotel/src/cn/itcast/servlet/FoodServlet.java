package cn.itcast.servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.service.IFoodTypeService;
import cn.itcast.service.impl.FoodTypeService;
import cn.itcast.utils.Condition;
import cn.itcast.utils.PageBean;

public class FoodServlet extends BaseServlet {

	/**
	 * 查看菜品详情
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public Object foodDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("dinnerTable");
		
		if (obj == null){
			
			String tableId = request.getParameter("tableId");
			DinnerTable dt = dinnerTableService.findById(Integer.parseInt(tableId));
			
			session.setAttribute("dinnerTable", dt);
		
		}
		
		PageBean<Food> pb = new PageBean<Food>();
		
		String curPage = request.getParameter("currentPage");
		
		if (curPage == null || "".equals(curPage.trim())) {
			
			pb.setCurrentPage(1);
		} else {
			
			pb.setCurrentPage(Integer.parseInt(curPage));
		}
		
		
		Condition condition = new Condition();
		
		String foodTypeId = request.getParameter("foodTypeId");
		if (foodTypeId != null) {  
			
			condition.setFoodTypeId(Integer.parseInt(foodTypeId));
		}
		
		String foodName = request.getParameter("foodName");
		
		if(foodName != null){
			condition.setFoodName(foodName);
		}
		
		
		pb.setCondition(condition);

		
		foodService.getAll(pb);
		
		request.setAttribute("pb", pb);
		
	
		List<FoodType> listFoodType = foodTypeService.getAll();
		request.setAttribute("listFoodType", listFoodType);
		
		
		return request.getRequestDispatcher("/app/caidan.jsp");
	}

	/**
	 * 添加食物
	 */
	public Object add(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Food food = new Food();
		
		food.setFoodType_id(Integer.parseInt(request.getParameter("cid")));
		food.setFoodName(request.getParameter("foodName"));
		food.setPrice(Double.parseDouble(request.getParameter("price")));
		food.setMprice(Double.parseDouble(request.getParameter("mprice")));
		food.setRemark(request.getParameter("introduce"));
		//food.setImg(uploadImage(request, response));
		
		foodService.insertFood(food);
		return request.getRequestDispatcher("/food?method=list");
	}
	/**
	 * 显示食物
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public Object list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Object uri = null;
		// ����Service��ѯ���е����
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Food> foodList = foodService.getAll();
		
		for(Food f : foodList){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", f.getId());
			map.put("foodName", f.getFoodName());
			map.put("price", f.getPrice());
			map.put("mprice", f.getMprice());
			map.put("foodTypeName", foodTypeService.findById(f.getFoodType_id()).getTypeName());
			list.add(map);
		} 
		
		
		request.setAttribute("listFood", list);
		
		uri = request.getRequestDispatcher("/sys/foodList.jsp");
		
		return uri;
	}
	/**
	 * 删除食物
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		
		String id = request.getParameter("id");
		
		foodService.delete(Integer.parseInt(id));
		
		uri = "/food?method=list";
		return uri;
	}
	/**
	 * 执行更新
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public Object viewUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		Food food = foodService.findById(Integer.parseInt(id));
		
		request.setAttribute("food", food);
		
		uri = request.getRequestDispatcher("/sys/updateFood.jsp");
		return uri;
	}
	
	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object uri = null;
		Food food = foodService.findById(Integer.parseInt(request.getParameter("id")));
		
		food.setFoodType_id(Integer.parseInt(request.getParameter("cid")));
		food.setFoodName(request.getParameter("foodName"));
		food.setPrice(Double.parseDouble(request.getParameter("price")));
		food.setMprice(Double.parseDouble(request.getParameter("mprice")));
		food.setRemark(request.getParameter("introduce"));
		//food.setImg(uploadImage(request, response));

		
		foodService.update(food);
		
		uri = "/food?method=list";
		return uri;
	}
	
	/**
	 * 上载图片
	 * @param request
	 * @param response
	 * @return
	 */
	public String uploadImage(HttpServletRequest request, HttpServletResponse response){
		String filename = null;
		String path = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            factory.setSizeThreshold(1024 * 1024);
             
            List items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
  
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
  
                    
                    filename = request.getParameter("foodName") + ".jpg";
                    
                    String photoFolder =request.getServletContext().getRealPath("sys/style/images");
                    path = photoFolder + filename;
                    
                    File f = new File(photoFolder, filename);
                    
                    f.getParentFile().mkdirs();
  
                    InputStream is = item.getInputStream();
  
                  
                    FileOutputStream fos = new FileOutputStream(f);
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.close();
  
                } else {
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(value);
                }
            }
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(path);
        return path;
	}
}












