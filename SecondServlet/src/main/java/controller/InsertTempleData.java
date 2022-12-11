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

import bean.templeBean;
import dao.TempleDao;
import service.TempleService;


@WebServlet("/InsertTempleData.do")
public class InsertTempleData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定義存放錯誤訊息的 Collection物件
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);
		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 memberId 欄位內的資料，注意大小寫
		String templeId = request.getParameter("templeId");
		
		if (templeId == null || templeId.trim().length() == 0) {
			errorMessage.add("帳號欄必須輸入");
		}
		
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String templeName = request.getParameter("templeName");
		
		// 讀取使用者所輸入，由瀏覽器送來的 name 欄位內的資料
		String deitiesName = request.getParameter("deitiesName");
		String administrative = request.getParameter("administrative");
		
		// 讀取使用者所輸入，由瀏覽器送來的 phone 欄位內的資料
		String address = request.getParameter("address");
		
		String register = request.getParameter("register");
		String sect = request.getParameter("sect");
		String phone = request.getParameter("phone");
		String principal = request.getParameter("principal");
		String other = request.getParameter("other");
		Double WGS84X = Double.valueOf(request.getParameter("wGS84X"));
		Double WGS84Y = Double.valueOf(request.getParameter("wGS84Y"));
		Integer uniformnumbers = Integer.valueOf(request.getParameter("uniformnumbers"));

		
//		 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			return;
		}
//		 MemberBean 扮演封裝輸入資料的角色
		templeBean tmpb = new templeBean(templeId, templeName, deitiesName, administrative, address, register, sect, phone, principal, other, WGS84X, WGS84Y, uniformnumbers);
				
		try {
			TempleDao tpDao= new TempleDao();
//			TempleService memberService = new TempleService();
//			memberService.insertTemple(tmpb);
			tpDao.insertTemple(tmpb);
			request.setAttribute("templeBean", tmpb);
			// 產生 RequestDispatcher 物件 rd
			RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
//			if (e.getMessage().indexOf("重複的索引鍵") != -1 || e.getMessage().indexOf("Duplicate entry") != -1) {
//				errorMessage.add("帳號重複，請重新輸入帳號");
//			} else {
//				errorMessage.add("資料庫存取錯誤:" + e.getMessage());
//			}
//			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
//			rd.forward(request, response);
//			return;
			e.printStackTrace();

		}
	}
}

