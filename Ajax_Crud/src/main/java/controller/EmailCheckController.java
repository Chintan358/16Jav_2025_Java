package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emailcheck")
public class EmailCheckController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw  =resp.getWriter();
		String email = req.getParameter("value");
		
		UserDao dao = new UserDao();
		boolean b = dao.isEmailCheck(email);
		if(b)
		{
			pw.append("true");
		}
		else
		{
			pw.append("false");
		}
	}
	
}
