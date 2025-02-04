import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Swingdemo {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setLayout(null);
		
		
		JLabel l1 = new JLabel("Registration Form");
		l1.setBounds(150, 50, 300, 10);
		
		JLabel l2 = new JLabel("Username");
		l2.setBounds(100, 100, 70, 20);
		JTextField uname = new JTextField();
		uname.setBounds(200, 100, 150, 20);
		
		JLabel l3 = new JLabel("Email");
		l3.setBounds(100, 130, 70, 20);
		JTextField email = new JTextField();
		email.setBounds(200, 130, 150, 20);
		
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(100, 160, 70, 20);
		JRadioButton male = new  JRadioButton("Male");
		JRadioButton female = new JRadioButton("Female");
		male.setBounds(200, 160, 70, 20);
		female.setBounds(280, 160, 70, 20);
		ButtonGroup bg  =new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		JLabel l5 = new JLabel("Language");
		l5.setBounds(100, 190, 70, 20);
		JCheckBox guj = new JCheckBox("Gujarati");
		guj.setBounds(200, 190, 70, 20);
		JCheckBox hindi = new JCheckBox("Hindi");
		hindi.setBounds(280, 190, 70, 20);
		JCheckBox eng = new JCheckBox("English");
		eng.setBounds(200, 220, 70, 20);
		JCheckBox marathi = new JCheckBox("Marathi");
		marathi.setBounds(280, 220, 70, 20);
		
		frame.add(l1);
		frame.add(l2);
		frame.add(uname);
		frame.add(l3);
		frame.add(email);
		frame.add(l4);
		frame.add(male);
		frame.add(female);
		frame.add(guj);
		frame.add(marathi);
		frame.add(eng);
		frame.add(hindi);
		frame.add(l5);
		
		
		
		
	}
}
