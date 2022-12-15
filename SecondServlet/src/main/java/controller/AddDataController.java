package controller;

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

import bean.Active;
import service.ActiveService;
import service.ActiveServiceImpl;
import service.FileChange;
@MultipartConfig()
@WebServlet("/addController")
public class AddDataController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		System.out.println(name);
		InputStream in=req.getPart("img").getInputStream();
		long size = req.getPart("img").getSize();
		String description=req.getParameter("description");
		String startDate=req.getParameter("start");
		String endDate=req.getParameter("end");
		String location=req.getParameter("location");
		String host=req.getParameter("host");
		Active active=new Active(name, null, description, startDate, endDate, location, host);
		try {
			Blob image = FileChange.fileToBlob(in, size);
			
			if (req.getPart("img").getSize()!=0) {
                active.setActiveImg(image);
                System.out.println(active);
            }
			
			active.setActiveDescription(description);
			active.setActiveEndDate(endDate);
			active.setActiveHost(host);
			active.setActiveLocation(location);
			active.setActiveStartDate(startDate);
		
			 
//			Active active=new Active(name, description, startDate, endDate, location, host);
			
			ActiveService activeService=new ActiveServiceImpl();
			activeService.add(active);
			
			res.sendRedirect(req.getContextPath()+"/showAllActiveController");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
