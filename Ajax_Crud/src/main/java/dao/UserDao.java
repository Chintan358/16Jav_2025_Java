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
	
	Connection cn  = null;
	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn  =DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int addUser(User u)
	{
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("insert into users values(?,?,?,?,?)");
			ps.setInt(1,0);
			ps.setString(2, u.getUname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPhone());
			ps.setString(5, u.getPass());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
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
				u.setPass(rs.getString(5));
				
				users.add(u);
			}
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public User userById(int id)
	{
		User u = new User();
		try {
			PreparedStatement ps = cn.prepareStatement("select * from users where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getString(4));
				u.setPass(rs.getString(5));
				
				
			}
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public int  deleteUser(int id)
	{
		int i=0;
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
	
	public int updateUser(User u)
	{
		int i = 0;
		try {
			PreparedStatement ps = cn.prepareStatement("update users set name=?,email=?,phone=?,pass=? where id=?");
			ps.setInt(5,u.getId());
			ps.setString(1, u.getUname());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPhone());
			ps.setString(4, u.getPass());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
}
