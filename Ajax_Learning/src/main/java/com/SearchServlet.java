package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw  =resp.getWriter();
		String value = req.getParameter("value");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
			PreparedStatement ps  =cn.prepareStatement("select * from products where name like ?");
			ps.setString(1, value+"%");
			
			ResultSet rs = ps.executeQuery();
			pw.append("<ul>");
			while(rs.next())
			{
				pw.append("<li>"+rs.getString(2)+"</li>");
			}
			pw.append("</ul>");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
