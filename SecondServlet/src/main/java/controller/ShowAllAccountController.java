package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import dao.AccountDao;
import impl.AccountDaoImpl;
import impl.AccountServiceImpl;
import service.AccountService;

/**
 * Servlet implementation class ShowAllAccountController
 */
@WebServlet("/showAllAccountControllersafe") //接棒AccountmanagerLoginController
public class ShowAllAccountController extends HttpServlet {
	
	//這個是編譯器叫我加的
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountService accountService=new AccountServiceImpl();
	    List<Account> accounts=accountService.showAllAccount();
		   req.setAttribute("accounts", accounts);
//		   resp.sendRedirect(req.getContextPath()+"/controller/toImage");
		   req.getRequestDispatcher("/showAllAccountsafe.jsp").forward(req, resp);
		return;
	}

}
