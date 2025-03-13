package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ser")
public class MyServlet extends HttpServlet {
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw  =response.getWriter();
		
		String data  =request.getParameter("data");
		
		if(data.equals("cloths"))
		{
			pw.append("<ul>");
			pw.append("<li>Cap</li>");
			pw.append("<li>Shirt</li>");
			pw.append("<li>Tshirt</li>");
			pw.append("</ul>");
		}
		else if(data.equals("electric"))
		{
			pw.append("<ul>");
			pw.append("<li>Fan</li>");
			pw.append("<li>tv</li>");
			pw.append("<li>mouse</li>");
			pw.append("</ul>");
		}
		else if(data.equals("sports"))
		{
			pw.append("<ul>");
			pw.append("<li>bat</li>");
			pw.append("<li>ball</li>");
			pw.append("<li>stump</li>");
			pw.append("</ul>");
		}
		else
		{
			pw.append("Invalid input");
		}
		
		
		
		
		
	
	
	
	}

	
}
