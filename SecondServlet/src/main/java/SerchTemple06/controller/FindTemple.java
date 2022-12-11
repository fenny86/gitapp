package SerchTemple06.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.templeBean;
import dao.TempleDao;

@WebServlet("/FindTemple")
public class FindTemple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String templeId = request.getParameter("templeId");
		TempleDao tpDao= new TempleDao();
		List<templeBean> beans = tpDao.selectAll(templeId);
		request.setAttribute("tmp", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/serchTemple/ContralData.jsp");
		rd.forward(request, response);
		return;
	}
	
}
