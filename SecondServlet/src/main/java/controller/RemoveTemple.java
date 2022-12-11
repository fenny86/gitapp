package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TempleDao;
import service.TempleService;

@WebServlet("/RemoveTemple.do")
public class RemoveTemple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RemoveTemple() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		String templeId=request.getParameter("templeId");
		if (templeId == null || templeId.trim().length() == 0) {
			errorMessage.add("帳號欄必須輸入");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			return;
		}
		TempleDao tpDao= new TempleDao();
		try {
			tpDao.removeTmp(templeId);
			RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
