package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Active;
import service.ActiveService;
import service.ActiveServiceImpl;

@WebServlet("/showActiveController")
public class ShowActiveController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.valueOf(req.getParameter("id"));
		ActiveService activeService=new ActiveServiceImpl();
		Active active=activeService.showActive(id);
		
		req.setAttribute("active", active);
		req.getRequestDispatcher("/showUpdateActiveInfo.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
