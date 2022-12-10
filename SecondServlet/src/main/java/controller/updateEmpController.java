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

@WebServlet("/updateEmpControllersafe")
public class updateEmpController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.valueOf(req.getParameter("id"));
		String name=req.getParameter("name");
		Double salary=Double.valueOf(req.getParameter("salary"));
		Integer age=Integer.valueOf(req.getParameter("age"));
		
		Emp emp=new Emp(id, name, salary, age);
		
		EmpService empService=new EmpServiceImpl();
		empService.modify(emp);
		
		resp.sendRedirect(req.getContextPath()+"/showAllEmpControllersafe");
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
