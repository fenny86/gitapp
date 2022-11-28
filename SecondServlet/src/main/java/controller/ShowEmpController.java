package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Emp;
import impl.EmpServiceImpl;
import service.EmpService;

/**
 * Servlet implementation class ShowEmpController
 */
@WebServlet("/showEmpControllersafe")
public class ShowEmpController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.valueOf(req.getParameter("id"));
		EmpService empService=new EmpServiceImpl();
		Emp emp=empService.showEmp(id);
		
		req.setAttribute("emp", emp);
		req.getRequestDispatcher("/showUpdateEmpInfoJSPsafe").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
