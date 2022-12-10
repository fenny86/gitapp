package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AccountManager;
import impl.AccountManagerServiceImpl;
import service.AccountManagerService;

@WebServlet("/accountLogin")
public class AccountmanagerLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		AccountManagerService accountManagerService=new AccountManagerServiceImpl(); //從SQL裝到Bean
		AccountManager manager= accountManagerService.login(username, password);
		if(manager!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("manager", manager);
			
			resp.sendRedirect(req.getContextPath()+"/showAllAccountControllersafe");
		}else {
			resp.sendRedirect(req.getContextPath()+"/accountLogin.html"); // 如果是空返回原畫面
		}
			
		}
	}


