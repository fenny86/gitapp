package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileSvl")
@MultipartConfig(maxFileSize = 300 * 1024)
public class FileSvl extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/uploadFile.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String fname = request.getParameter("fname");
    try {
      Part part = request.getPart("file");
      String picPath = request.getServletContext().getRealPath("/") + "pic";
      part.write(picPath + "/" + fname);
      request.setAttribute("msg","上傳成功");
    }catch(Exception e) {
      e.printStackTrace();
      request.setAttribute("msg", e.getMessage());
    }
    request.getRequestDispatcher("/uploadFile.jsp").forward(request, response);
  }
}