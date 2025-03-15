package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/adduser")
public class AddUserController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw  =resp.getWriter();
		User u = new User();
		u.setUname(req.getParameter("uname"));
		u.setEmail(req.getParameter("email"));
		u.setPhone(req.getParameter("phone"));
		u.setPass(req.getParameter("pass"));
		
		UserDao dao = new UserDao();
		int i = dao.addUser(u);
		if(i>0)
		{
			pw.append("Registration successful !!!");
		}
		
		
	}
}
