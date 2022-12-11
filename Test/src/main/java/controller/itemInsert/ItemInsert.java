package controller.itemInsert;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ItemDao;
import dao.ItemDaoImpl;
import model.Item;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
* 1024 * 500 * 5)
@WebServlet("/ItemInsert.do")
public class ItemInsert extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Collection<Part> parts = request.getParts();
		Item item = new Item();
		int count=0;
		for (Part part : parts) {			
			String value = request.getParameter(part.getName());
			System.out.println(value);
			if(count==0)item.setPd_name(value);
			else if(count==1)item.setPd_description(value);
			else if(count==2)item.setPd_price(Integer.parseInt(value));
			else if(count==3)item.setPd_qty(Integer.parseInt(value));
			count++;
		}
		ItemDao iDao = new ItemDaoImpl();
		iDao.insert(item);
		request.setAttribute("Item", item);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/ItemList/result.jsp");
		rd.forward(request, response);
		return;
		
	}
}
