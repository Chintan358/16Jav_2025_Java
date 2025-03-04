package controller;

import java.io.IOException;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/useredit")
public class EditUser extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		User u = new User();
		u.setId(id);
		u.setUname(uname);
		u.setEmail(email);
		u.setPhone(phone);
		
		UserDao dao = new UserDao();
		int i = dao.updateUser(u);
		
		if(i>0)
		{
			req.setAttribute("msg", "Update success");
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
		
	}
}
