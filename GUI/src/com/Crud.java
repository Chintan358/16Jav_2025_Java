package com;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crud {

	private JFrame frame;
	private JTextField uname;
	private JTextField email;
	private JTextField phone;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crud window = new Crud();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Crud() {
		initialize();
		connect();
	}
	
	Connection cn= null;
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/15janjava","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(45, 25, 135, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(34, 62, 78, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(34, 96, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setBounds(34, 128, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		uname = new JTextField();
		uname.setBounds(101, 59, 98, 20);
		frame.getContentPane().add(uname);
		uname.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(101, 93, 98, 20);
		frame.getContentPane().add(email);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(101, 125, 98, 20);
		frame.getContentPane().add(phone);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String myuname = uname.getText();
				String myemail = email.getText();
				String myphone = phone.getText();
				String sql = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";
				try {
					PreparedStatement pst=cn.prepareStatement(sql);
					pst.setString(1, myuname);
                    pst.setString(2, myemail);
                    pst.setString(3, myphone);
                    int i = pst.executeUpdate();
                    if(i>0)
                    {
                    	JOptionPane.showMessageDialog(frame, "User Inserted!!!!");
                    	uname.setText("");
                    	email.setText("");
                    	phone.setText("");
                    }
                    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				
				
			}
		});
		btnNewButton.setBounds(34, 164, 78, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(121, 164, 78, 23);
		frame.getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 38, 295, 149);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 231, 505, 108);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 41, 98, 20);
		panel.add(textField);
		
		JLabel lblNewLabel_1_3 = new JLabel("User Id");
		lblNewLabel_1_3.setBounds(10, 44, 48, 14);
		panel.add(lblNewLabel_1_3);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(194, 38, 78, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(281, 38, 78, 23);
		panel.add(btnDelete);
	}
}
