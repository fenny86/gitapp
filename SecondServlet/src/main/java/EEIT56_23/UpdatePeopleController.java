package EEIT56_23;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updatePeopleControllersafe")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class UpdatePeopleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		InputStream in = request.getPart("photo").getInputStream();
		long size = request.getPart("photo").getSize();
		String type = request.getPart("photo").getContentType();

		try {
			PeopleService_23 peopleService = new PeopleServiceImpl_23();
			PeopleDao_23 peopleDao = new PeopleDaoImpl_23();

			Integer id = Integer.parseInt(request.getParameter("userId"));

			String name = request.getParameter("name");

			Integer age = Integer.valueOf(request.getParameter("age"));

			String sex = request.getParameter("gender");

			String address = request.getParameter("address");
	
			Blob image = GlobalService.fileToBlob(in, size);
			PeopleBean_23 pb = peopleDao.selectById(id);
			
			if(size!=0 && type.equals("image/jpeg")) {
				pb.setImages(image);
			}
			
			
			String star = request.getParameter("star_sign");
			
			String profession = request.getParameter("profession");
			
			String religion = request.getParameter("religion");
			
			Double income = Double.valueOf(request.getParameter("income"));
			
			String sex_in = request.getParameter("sex_in");
			
			String hobby = request.getParameter("hobby");
			
			String dream = request.getParameter("dream");

			String personality = request.getParameter("personality");
			
			String emotion = request.getParameter("emotion");
			
			String introduction = request.getParameter("introduction");
			
			pb.setUserID(id);
			pb.setName(name);
			pb.setAge(age);
			pb.setSex(sex);
			pb.setAddress(address);
			pb.setStar(star);
			pb.setEmotion(emotion);
			pb.setProfession(profession);
			pb.setPersonality(personality);
			pb.setHobby(hobby);
			pb.setDream(dream);
			pb.setIntroduction(introduction);
			pb.setReligion(religion);
			pb.setSex_in(sex_in);
			pb.setIncome(income);
			
			peopleService.modify(pb);
			
			response.sendRedirect(request.getContextPath() + "/showPeople.do");
			session.setAttribute("peopleBean", pb);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
