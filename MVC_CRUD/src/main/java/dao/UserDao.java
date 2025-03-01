package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
	
	Connection cn = null;
	public UserDao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn  =DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}
		
	public int addUser(User u)
	{
		int i=0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into users values(?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, u.getUname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPhone());
			i = ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public int deleteUser(int id)
	{
		int i = 0;
		return i;
	}
	
	public User userById(int id)
	{
		User u = new User();
		return u;
	}
	
	public List<User> allUsers()
	{
		List<User> users = new ArrayList();
		return users;
	}
}
