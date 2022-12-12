package EEIT56_23;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


//insert資料
@WebServlet("/EEIT56_23/ProcessPeopleServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ProcessPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");

//		Part part = request.getPart("photo");
//		InputStream in = part.getInputStream();
//		byte[] person_img = new byte[in.available()];
//		in.read(person_img);
//		in.close();

		InputStream in = request.getPart("photo").getInputStream();
		long size = request.getPart("photo").getSize();

		try {
			Integer userid = Integer.parseInt(request.getParameter("userId"));
//		if (userid == null ) {
//			errorMessage.put("id", "帳號欄必須輸入");
//		}

			String name = request.getParameter("name");
			if (name == null || name.trim().length() == 0) {
				errorMessage.put("name", "姓名欄必須輸入");
			}

			Integer age = Integer.valueOf(request.getParameter("age"));
			if (age == null) {
				errorMessage.put("age", "年齡欄必須輸入");
			}

			String sex = request.getParameter("gender");

			String address = request.getParameter("address");
			if (address == null) {
				errorMessage.put("address", "地區欄必須輸入");
			}
			Blob image = GlobalService.fileToBlob(in, size);
			
			String star = request.getParameter("star_sign");
			
			String profession = request.getParameter("profession");
			
			String religion = request.getParameter("religion");
			
			
			String value = request.getParameter("income");
			System.out.println(value);
			Double income = 0.0;
			if(!value.equals("")) {
				System.out.println(123456789);
				income = Double.valueOf(value);
			}
			System.out.println(income);
			
			String sex_in = request.getParameter("sex_in");
			
			String hobby = request.getParameter("hobby");
			System.out.println("hobby ="+hobby+"--");
			
			String dream = request.getParameter("dream");

			String personality = request.getParameter("personality");
			
			String emotion = request.getParameter("emotion");
			
			String introduction = request.getParameter("introduction");
			
			PeopleService_23 peopleService = new PeopleServiceImpl_23();
			PeopleBean_23 pb;
			if(income==0.0) {
				pb = new PeopleBean_23(userid, name, age, sex, address, star, emotion, profession, personality, hobby, dream, introduction, image, religion, sex_in);
				peopleService.saveNoIncome(pb);
			} else {
				pb = new PeopleBean_23(userid, name, age, sex, address, star, emotion, profession, personality, hobby, dream, introduction, image, religion, sex_in, income);
				peopleService.saveData(pb);
			}
			
			
			
//			PeopleBean_23 pb = new PeopleBean_23(userid, name, age, sex, address);
//			PeopleService_23 peopleService = new PeopleServiceImpl_23();
//			peopleService.saveTest(pb);
			
			response.sendRedirect(request.getContextPath() + "/EEIT56_23/InsertPeopleSuccess.jsp");
			session.setAttribute("peopleBean", pb);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/EEIT56_23/InsertPeopleForm_23.jsp");
			rd.forward(request, response);
			return;
		}

//		String contextPath = request.getContextPath();
//		response.sendRedirect(
//				response.encodeRedirectURL(
//						contextPath + "/EEIT56_23/InsertPeopleSuccess.jsp"
//						));
//		return;

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
