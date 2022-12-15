package EEIT56_23;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removePeople.do")
public class DeletePeopleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		PeopleService_23 peopleService = new PeopleServiceImpl_23();
		peopleService.removeById(id);
		response.sendRedirect(request.getContextPath()+"/showPeople.do");
	}

}
