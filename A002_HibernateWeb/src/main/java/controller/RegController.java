package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import doa.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.User;

@WebServlet("/reg")
@MultipartConfig
public class RegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		String uname  =req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		Part img = req.getPart("file");
		
		String imgName = Paths.get(img.getSubmittedFileName()).getFileName().toString();
		String fileToStore = uname+"_"+System.currentTimeMillis()+"_"+imgName;
		String path = req.getServletContext().getRealPath("")+File.separator+"img";
		System.out.println(path);
		
		File file = new File(path);
		if(!file.exists())
		{
			file.mkdir();
		}
		
		img.write(path+File.separator+fileToStore);
		
		
		User u = new User();
		u.setUsername(uname);
		u.setEmail(email);
		u.setPassword(pass);
		u.setImage(fileToStore);
		
		if(!id.equals(""))
		{
			u.setId(Integer.parseInt(id));
		}
		
		UserDao dao = new UserDao();
		int i = dao.addorUpdateUser(u);
		
		if(i>0)
		{
			if(!id.equals(""))
			{
				req.setAttribute("msg", "Update successful");
			}
			else
			{
				req.setAttribute("msg", "Registration successful");
			}
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
}
