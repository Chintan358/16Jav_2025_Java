package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/otp")
public class OtpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw  =resp.getWriter();
		String otp = req.getParameter("otp");
		//System.out.println("entered otp : "+otp);
		
		ServletContext cx = req.getServletContext();
		String r_otp = (String) cx.getAttribute("otp");
		//System.out.println("real otp : "+r_otp);
		
		if(otp.equals(r_otp))
		{
			pw.write("<h1>Success</h1>");
		}
		else
		{
			req.setAttribute("err", "Invalid otp");
			req.getRequestDispatcher("otp.jsp").forward(req, resp);
		}
	}
}
