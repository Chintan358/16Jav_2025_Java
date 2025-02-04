package com;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetadataDemo {
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection cn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
		
			
//			DatabaseMetaData dmt = cn.getMetaData();
//			System.out.println(dmt.getDatabaseMajorVersion());
//			System.out.println(dmt.getDriverName());
//			System.out.println(dmt.getDatabaseProductName());
//			System.out.println(dmt.getJDBCMajorVersion());
			
			Statement st  =cn.createStatement();
			ResultSet rs = st.executeQuery("select * from student");
			
			ResultSetMetaData rmt = rs.getMetaData();
			System.out.println(rmt.getColumnCount());
//			System.out.println(rmt.getColumnType(2));
			System.out.println(rmt.getColumnLabel(2));
			System.out.println(rmt.getColumnTypeName(2));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
}
