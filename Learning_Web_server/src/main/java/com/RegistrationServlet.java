package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
			
		 PrintWriter pw =  resp.getWriter();
		
		 resp.setContentType("text/html");
		 
		 String uname = req.getParameter("uname");
		 String email = req.getParameter("email");
		 String phone = req.getParameter("phone");
		
//		 System.out.println(uname+" "+email+" "+phone);
		 
//		 pw.write("<h1>Username : "+uname+"</h1>");
//		 pw.write("<h1>Email : "+email+"</h1>");
//		 pw.write("<h1>Phone : "+phone+"</h1>");
//		 
		 
		 try {
			Class .forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
			
			PreparedStatement ps  =cn.prepareStatement("insert into users values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, uname);
			ps.setString(3, email);
			ps.setString(4, phone);
			
			int i= ps.executeUpdate();
			if(i>0)
			{
				pw.write("<h1>Registration success</h1>");
				//req.getRequestDispatcher("registration.jsp").include(req, resp);
//				req.setAttribute("msg", "registration success");
//				req.getRequestDispatcher("registration.jsp").forward(req, resp);
				resp.sendRedirect("registration.jsp");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 
	}
}
