package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;

@WebServlet("/showAllAccountJSPsafe")
public class showAllAccountJSP extends HttpServlet {
	// 編譯器叫我加的
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		@SuppressWarnings("unchecked") //編譯器
		List<Account> accounts=(List<Account>)req.getAttribute("accounts");
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>查詢所有員工頁面</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>編號</td>");
		out.println("<td>帳號</td>");
		out.println("<td>密碼</td>");
		out.println("<td>圖片</td>");
//		out.println("<td>年齡</td>");
		out.println("<td colspan='2'>操作</td>");
		out.println("</tr>");
		for (Account account : accounts) {
			out.println("<tr>");
			out.println("<td>"+account.getId()+"</td>");
			out.println("<td>"+account.getAccount()+"</td>");
//			out.println("<td>"+account.getSalary()+"</td>");
			out.println("<td>"+account.getPassword()+"</td>");
			out.println("<td>"+account.getImage()+"</td>");
			out.println("<td><a href='"+req.getContextPath()+"/removeAccountControllersafe?id="+account.getId()+"'>刪除</a></td>");		
			out.println("<td><a href='"+req.getContextPath()+"/showAccountControllersafe?id="+account.getId()+"'>修改</a></td>");		
			out.println("</tr>");	
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	

	}

}
