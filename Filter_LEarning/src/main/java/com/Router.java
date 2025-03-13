package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/route")
public class Router  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		if(name.equals("home"))
		{
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else if(name.equals("about"))
		{
			req.getRequestDispatcher("About.jsp").forward(req, resp);
		}
	}
}
