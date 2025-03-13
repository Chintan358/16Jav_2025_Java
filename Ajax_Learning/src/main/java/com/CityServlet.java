package com;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/cities")
public class CityServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw  =resp.getWriter();
		int sid = Integer.parseInt(req.getParameter("sid"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
			PreparedStatement ps  =cn.prepareStatement("select * from cities where state_id=?");
			ps.setInt(1, sid);
			
			
			ResultSet rs = ps.executeQuery();
			
			String options = "<option>---Select city---</option>";
			while(rs.next())
			{
				options+="<option value="+rs.getInt(1)+">"+rs.getString(2)+"</option>";
			}
			
			pw.append(options);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
