package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmpManager;
import impl.EmpManagerServiceImpl;
import service.EmpManagerService;

@WebServlet("/login")
public class EmpmanagerLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		EmpManagerService empManagerService=new EmpManagerServiceImpl();
		EmpManager manager= empManagerService.login(username, password);
		if(manager!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("manager", manager);
			
			resp.sendRedirect(req.getContextPath()+"/showAllEmpControllersafe");
		}else {
			resp.sendRedirect(req.getContextPath()+"/login.html");
		}
			
		}
	}


