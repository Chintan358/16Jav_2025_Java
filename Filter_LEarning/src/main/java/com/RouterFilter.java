package com;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/route")
public class RouterFilter extends HttpFilter {
	
	
	
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
	
		ServletContext cx = req.getServletContext();
		String wk = cx.getInitParameter("working");
		if(wk.equals("true"))
		{
			chain.doFilter(req, resp);
		}
		else
		{
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
	}
}
