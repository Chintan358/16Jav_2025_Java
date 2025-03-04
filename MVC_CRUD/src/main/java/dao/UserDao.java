package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		try {
			PreparedStatement ps = cn.prepareStatement("delete from users where id=?");
			ps.setInt(1, id);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public User userById(int id)
	{
		User u = new User();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from users where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	public List<User> allUsers()
	{
		List<User> users = new ArrayList();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getString(4));
				
				users.add(u);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public int updateUser(User u) {
		int i=0;
		try {
			PreparedStatement ps = cn.prepareStatement("update users set name=?,email=?,phone=? where id=?");
			ps.setString(1, u.getUname());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPhone());
			ps.setInt(4, u.getId());
			i= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
