package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import dao.AccountDao;
import impl.AccountDaoImpl;
import impl.AccountServiceImpl;
import service.AccountService;
import service.GlobalService;

@MultipartConfig()
@WebServlet("/updateAccountControllersafe") //接棒自ShowUpdateAccountInfoController
public class updateAccountController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.valueOf(req.getParameter("id"));
		String account=req.getParameter("account");
			String password=req.getParameter("password");
			InputStream in = req.getPart("photo").getInputStream();
		long size = req.getPart("photo").getSize();
		try {
			Blob image = GlobalService.fileToBlob(in, size);
//			Account accounts=new Account(id,account,password,image);
//			Account accounts=new Account(id,account,password);
			AccountService accountService=new AccountServiceImpl();
			AccountDao accountDao = new AccountDaoImpl();
			Account accounts = accountDao.select(id);
			System.out.println(req.getPart("photo"));
			if (req.getPart("photo").getSize()!=0) {
				accounts.setImage(image);
			}
			accounts.setAccount(account);
			accounts.setPassword(password);
			accounts.setId(id);
			accountService.modify(accounts);
			resp.sendRedirect(req.getContextPath()+"/showAllAccountControllersafe");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
