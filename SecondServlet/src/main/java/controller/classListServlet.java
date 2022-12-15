package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.ClassBean;
import dao.ClassDao;
import impl.ClassDaoImpl;



@WebServlet("/controller/classShoppingList")
public class classListServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(classListServlet.class);
	
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

		

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	
		ClassDao classService = new ClassDaoImpl(); 
		List<ClassBean> classlist = classService.selectAll();
		request.setAttribute("classList",classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/class/classList.jsp");
		rd.forward(request, response);
		return;
	}
}
	

