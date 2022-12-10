package EEIT56_23;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showPeople.do")
public class ShowAllPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PeopleService_23 peopleService = new PeopleServiceImpl_23();
		List<PeopleBean_23> beans = peopleService.showAll();
		
		request.setAttribute("peopleBeans", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/EEIT56_23/ShowPeople.jsp");
		rd.forward(request, response);
		return;
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
