package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Emp;
import dao.EmpDao;
import impl.EmpDaoImpl;
import impl.EmpServiceImpl;
import service.EmpService;

/**
 * Servlet implementation class ShowAllEmpController
 */
@WebServlet("/showAllEmpControllersafe")
public class ShowAllEmpController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpService empService=new EmpServiceImpl();
	   List<Emp> emps=empService.showAllEmp();
		   req.setAttribute("emps", emps);
		   req.getRequestDispatcher("showAllEmpsafe.jsp").forward(req, resp);
		
	}

}
