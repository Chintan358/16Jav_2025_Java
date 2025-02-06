package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calc {

	private JFrame frame;
	private JTextField a;
	private JTextField b;
	private JTextField c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
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
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		a = new JTextField();
		a.setBounds(162, 36, 86, 20);
		frame.getContentPane().add(a);
		a.setColumns(10);
		
		b = new JTextField();
		b.setColumns(10);
		b.setBounds(162, 67, 86, 20);
		frame.getContentPane().add(b);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(162, 98, 86, 20);
		frame.getContentPane().add(c);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			int	n1 =Integer.parseInt(a.getText());
			int	n2 =Integer.parseInt(b.getText());
			int r = n1+n2;
			c.setText(r+"");
			
			}
		});
		btnNewButton.setBounds(265, 35, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSub = new JButton("Sub");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int	n1 =Integer.parseInt(a.getText());
				int	n2 =Integer.parseInt(b.getText());
				int r = n1-n2;
				c.setText(r+"");
				
			}
		});
		btnSub.setBounds(265, 66, 89, 23);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("Mul");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int	n1 =Integer.parseInt(a.getText());
				int	n2 =Integer.parseInt(b.getText());
				int r = n1*n2;
				c.setText(r+"");
				
			}
		});
		btnMul.setBounds(265, 97, 89, 23);
		frame.getContentPane().add(btnMul);
		
		JButton btnDiv = new JButton("Div");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double	n1 =Double.parseDouble(a.getText());
				double	n2 =Double.parseDouble(b.getText());
				double r = n1/n2;
				c.setText(r+"");
				
			}
		});
		btnDiv.setBounds(265, 131, 89, 23);
		frame.getContentPane().add(btnDiv);
	}
}
