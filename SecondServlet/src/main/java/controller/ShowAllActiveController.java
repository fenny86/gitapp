package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Active;
import bean.Page;
import service.ActiveService;
import service.ActiveServiceImpl;



@WebServlet("/showAllActiveController")
public class ShowAllActiveController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String pageIndex =req.getParameter("pageIndex");
		
		
//		if(pageIndex==null) {
//			pageIndex="1";
//		}
//		Page page=new Page(Integer.valueOf(pageIndex));
		ActiveService activeService=new ActiveServiceImpl();
		   List<Active> actives=activeService.showAllActive();
			   req.setAttribute("actives", actives);
//			   req.setAttribute("page", page);
			   req.getRequestDispatcher("/love.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}

}
