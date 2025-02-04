package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstConnecion {
	public static void main(String[] args) {
		
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivewr loaded");
			
			//define the connecion url
			String url  = "jdbc:mysql://localhost:3306/15janjava";
			String uname = "root";
			String pass = "root";
			
			//Establish the Connection
			Connection cn =  DriverManager.getConnection(url,uname,pass);
			System.out.println("connection established...");
			
			
			//create a statement
			Statement st = cn.createStatement();
			
			//execute query
			ResultSet rs  = st.executeQuery("select * from student");
			
			//Process the Result
			while(rs.next())
			{
				int id =  rs.getInt(1);
				String name =  rs.getString(2);
				String email =  rs.getString(3);
				
				System.out.println(id+" "+name+" "+email);
			}
			
			cn.close();
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
