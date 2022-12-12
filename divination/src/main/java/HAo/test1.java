package HAo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public test1() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("car");
		request.setAttribute("yourCar",s);
		RequestDispatcher rd = request.getRequestDispatcher("/TEST/test2.jsp");
		rd.forward(request, response);
		return;
	}

}
