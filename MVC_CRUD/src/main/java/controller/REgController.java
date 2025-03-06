package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/reg")
public class REgController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String pass = req.getParameter("pass");
		
		User u = new User();
		u.setPass(pass);
		u.setUname(uname);
		u.setEmail(email);
		u.setPhone(phone);
		
		UserDao dao = new UserDao();
		
		if(dao.isUsernameExist(u))
		{
			req.setAttribute("err", "User alredy exist!!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else
		{
			int i = dao.addUser(u);
			if(i>0)
			{
				req.setAttribute("msg", "Registration success");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}
		
		
	}
}
