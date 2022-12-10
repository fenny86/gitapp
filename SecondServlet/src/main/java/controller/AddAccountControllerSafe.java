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
import javax.servlet.http.Part;

import bean.Account;
import dao.AccountDao;
import impl.AccountDaoImpl;
import impl.AccountServiceImpl;
import service.AccountService;
import service.GlobalService;

@MultipartConfig()
@WebServlet("/AddAccountControllersafe") //接棒自ShowUpdateAccountInfoController
public class AddAccountControllerSafe extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.valueOf(req.getParameter("id"));
		String account=req.getParameter("account");
		String password=req.getParameter("password");
		Part photo = req.getPart("photo");
		InputStream in = photo.getInputStream();
		long size = photo.getSize();
		String type = photo.getContentType();
		try {
			Blob image = GlobalService.fileToBlob(in, size);
			AccountService accountService=new AccountServiceImpl();
			AccountDao accountDao = new AccountDaoImpl();
			Account accounts = new Account();
	
			if (type.equals("image/jpeg")) {
				accounts.setImage(image);
			}
			accounts.setAccount(account);
			accounts.setPassword(password);
			accounts.setId(id);
			accountService.add(accounts);
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
