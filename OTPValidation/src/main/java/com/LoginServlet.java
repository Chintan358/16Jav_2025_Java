package com;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		Random r = new Random();
		int otp = r.nextInt(100,999);
		
		
		EmailSending.send(email, "OTP Varification", "Your OTP is :"+otp);
		
		ServletContext cx = req.getServletContext();
		cx.setAttribute("otp", otp+"");
		
		req.getRequestDispatcher("otp.jsp").forward(req, resp);
		
		
	}
}
