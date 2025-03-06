package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		
		User u = new User();
		u.setUname(uname);
		u.setPass(pass);
		
		UserDao dao = new UserDao();
		User user =  dao.loginCheck(u);
		if(user==null)
		{
			req.setAttribute("err", "Invalid credentials !!!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("uname", user.getUname());
			req.getRequestDispatcher("display").forward(req, resp);
		}
		
		
		
		
	}
}
