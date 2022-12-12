package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import impl.AccountServiceImpl;
import service.AccountService;

/**
 * Servlet implementation class ShowAccountController
 * 有接棒自showAllAccountsafe
 */
@WebServlet("/showAccountControllersafe")
public class ShowAccountController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
		AccountService accountService=new AccountServiceImpl(); //第幾項的BEAN
		Account account=accountService.showAccount(id);
		
		req.setAttribute("account", account);
//		req.getRequestDispatcher("/showUpdateAccountInfoJSPsafe").forward(req, resp);
//		req.getRequestDispatcher("/updateAccount.jsp").forward(req, resp);
		req.getRequestDispatcher("/showAllAccounts.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
