package EEIT56_23;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userSelectControllersafe")
public class UserSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//用戶搜尋ID或名字
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PeopleService_23 peopleService = new PeopleServiceImpl_23();
		List<PeopleBean_23> bean;
		int id = 0;
		String name = null;
		boolean isLetter = false;// 定義一個boolean值,用來表示是否包含字母
		String str = request.getParameter("userId");
		if(str=="") {
			bean = peopleService.showAll();
		}else {
			
			for (int i = 0; i < str.length(); i++) { // 迴圈遍歷字串
				if (Character.isLetter(str.charAt(i))) { // 用char包裝類中的判斷字母的方法判斷每一個字元
					isLetter = true;
				}
			}
			if(isLetter == true) {
				name = str;
			} else {
				id = Integer.valueOf(str);
			}
			bean = peopleService.selectByIdOrName(id, name);
		}
		request.setAttribute("peopleBeans", bean);
		request.getRequestDispatcher("/EEIT56_23/ShowUserSelect.jsp").forward(request, response);
	}

}
