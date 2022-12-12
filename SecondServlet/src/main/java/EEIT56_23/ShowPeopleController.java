package EEIT56_23;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showPeopleControllersafe")
public class ShowPeopleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//用ID搜尋

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		PeopleService_23 peopleService = new PeopleServiceImpl_23();
		PeopleBean_23 bean = peopleService.showById(id);
		
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/EEIT56_23/ShowUpdatePeopleForm.jsp").forward(request, response);
	}

}
