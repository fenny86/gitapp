package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Post;
import dao.PostDao;
import impl.PostDaoImpl;
import impl.PostServiceImpl;
import service.PostService;

@WebServlet("/SearchAllController")
public class SearchAllController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PostService postService = new PostServiceImpl();
		List<Post> post = postService.searchAll();
		req.setAttribute("post", post);
		req.getRequestDispatcher("/JSP/SearchAll.jsp").forward(req, resp);
		return;
	}

}
