package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareDemo {
	public static void main(String[] args) {
		
		Scanner sc  =new Scanner(System.in);
		System.out.println("enter username : ");
		String name = sc.next();
		System.out.println("enter email : ");
		String email = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection cn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
			
			
			PreparedStatement ps = cn.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, name);
			ps.setString(3, email);
			
			int i =  ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Data inserted");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
