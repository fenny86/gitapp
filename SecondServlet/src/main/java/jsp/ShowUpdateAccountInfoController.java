package jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;

@WebServlet("/showUpdateAccountInfoJSPsafe") //接棒自ShowAccountController
public class ShowUpdateAccountInfoController extends HttpServlet {
	
	//編譯器叫我加的
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account account=(Account)req.getAttribute("account");
		
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'");
		out.println("<title>修改帳號資訊頁面</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='/SecondServlet/updateAccountControllersafe' enctype = 'multipart/form-data' method='post'>");
		out.println("編號:<input type='text' name='id' readonly=\"readonly\" value='"+account.getId()+"'/><br/>");
		out.println("帳號:<input type='text' name='account' value='"+account.getAccount()+"'/><br/>");
		out.println("密碼:<input type='text' name='password' value='"+account.getPassword()+"'/><br/>");
		out.println("圖片:<input type='file' name='photo' /><br/>");
		out.println("<input type='submit' value='修改'/><br/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
