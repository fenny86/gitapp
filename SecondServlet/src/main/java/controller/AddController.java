package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import bean.Account;
import bean.Post;
//import dao.AccountDao;
import dao.PostDaoTest;
//import impl.AccountDaoImpl;
//import impl.AccountServiceImpl;
import impl.PostDaoImpl;
import impl.PostServiceImpl;
//import service.AccountService;
//import service.GlobalService;
import service.PostService;



@WebServlet("/AddController")
public class AddController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					
		String postTitle=req.getParameter("postTitle");
		String postDate=req.getParameter("postDate");
		String postContent=req.getParameter("postContent");
		String postLike=req.getParameter("postLike");
		String postDislike=req.getParameter("postDislike");
		String postComment=req.getParameter("postComment");

		Post post=new Post(null, postTitle, postDate, postContent, postLike, postDislike, postComment);
		
		PostService postService=new PostServiceImpl();
		
		postService.add(post);
		System.out.println(post.toString());
		
		req.setAttribute("add", post);
		req.getRequestDispatcher("/JSP/AddOK.jsp").forward(req, resp);
		return;		
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
