package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Emp;

@WebServlet("/showAllEmpJSPsafe")
public class showAllEmpJSP extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Emp> emps=(List<Emp>)req.getAttribute("emps");
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
		out.println("<td>姓名</td>");
		out.println("<td>工資</td>");
		out.println("<td>年齡</td>");
		out.println("<td colspan='2'>操作</td>");
		out.println("</tr>");
		for (Emp emp : emps) {
			out.println("<tr>");
			out.println("<td>"+emp.getId()+"</td>");
			out.println("<td>"+emp.getName()+"</td>");
			out.println("<td>"+emp.getSalary()+"</td>");
			out.println("<td>"+emp.getAge()+"</td>");
			out.println("<td><a href='"+req.getContextPath()+"/removeEmpControllersafe?id="+emp.getId()+"'>刪除</a></td>");		
			out.println("<td><a href='"+req.getContextPath()+"/showEmpControllersafe?id="+emp.getId()+"'>修改</a></td>");		
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	

	}

}
