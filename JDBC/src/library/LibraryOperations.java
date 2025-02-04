package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryOperations {
	
	Connection cn = null;
	public LibraryOperations() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn  =DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addBook(String name, int qty) {
		
		try {
			
			PreparedStatement ps1 = cn.prepareStatement("select * from library where name=?");
			ps1.setString(1, name);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			{
				System.out.println("Book already exist !!!");
			}
			else
			{
				PreparedStatement ps = cn.prepareStatement("insert into library values(?,?,?)");
				ps.setInt(1, 0);
				ps.setString(2, name);
				ps.setInt(3, qty);
				int i = ps.executeUpdate();
				
				if(i>0)
				{
					System.out.println("Book inserted !!!");
				}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void viewBook() {
		
		try {
			PreparedStatement ps  =cn.prepareStatement("select * from library");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void deleteBook(String bname) {
		
		try {
			PreparedStatement ps = cn.prepareStatement("delete from library where name=?");
			ps.setString(1, bname);
			
			int i = ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Book deleted !!!!");
			}
			else
			{
				System.out.println("Something went wrong !!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong !!");
		}
		
		
	}

	public void issueBook(String name) {
		
		try {
			PreparedStatement ps = cn.prepareStatement("select * from library where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int qty = rs.getInt(3);
				if(qty>0)
				{
					qty--;
					PreparedStatement ps1 = cn.prepareStatement("update library set qty=? where name=?");
					ps1.setInt(1, qty);
					ps1.setString(2, name);
					int i = ps1.executeUpdate();
					if(i>0)
					{
						System.out.println("book issued !!!!");
					}
				}
				else
				{
					System.out.println("book currently not available !!!");
				}
			}
			else
			{
				System.out.println("Book not found !!!");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
