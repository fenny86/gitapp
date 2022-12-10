package jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Emp;

@WebServlet("/showUpdateEmpInfoJSPsafe")
public class ShowUpdateEmpInfoController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Emp emp=(Emp)req.getAttribute("emp");
		
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UF-8'");
		out.println("<title>修改員工資訊頁面</title>");
		out.println("</head>");
		out.println("body");
		out.println("<form action='/SecondServlet/updateEmpControllersafe' method='post'>");
		out.println("編號:<input type='text' name='id' readonly=\"readonly\" value='"+emp.getId()+"'/><br/>");
		out.println("名字:<input type='text' name='name' value='"+emp.getName()+"'/><br/>");
		out.println("薪水:<input type='text' name='salary' value='"+emp.getSalary()+"'/><br/>");
		out.println("年齡:<input type='text' name='age' value='"+emp.getAge()+"'/><br/>");
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
