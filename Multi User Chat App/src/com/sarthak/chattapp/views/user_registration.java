package com.sarthak.chattapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sarthak.chattapp.dao.userDao;
import com.sarthak.chattapp.dto.userDto;

public class user_registration extends JFrame{
	private JTextField userid_text;
	private JPasswordField passwordField;
	private JTextField email_txt;
	private JTextField phn_txt;
	private JTextField city_txt;

//	public static void main(String[] args) {
//		user_registration reg=new user_registration();
//	}
	private void register() {
		String userid=userid_text.getText();
		char[] password=passwordField.getPassword();
		String email=email_txt.getText();
		String phn=phn_txt.getText();
		String city=city_txt.getText();
		userDao userdao=new userDao();
		userDto userdto=new userDto(userid,password,email,phn,city);
		String message="Welcome "+userid;
		try {
		int result=userdao.add(userdto);
		if(result>0) {
			JOptionPane.showMessageDialog(this, "Register Successfully");
			setVisible(false);
			dispose();
			DashBoard dashboard=new DashBoard(message);
			dashboard.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(this, "Register Failed");
		}
		}
		
		catch(Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}

	
	public user_registration() {
		setFont(new Font("Arial Black", Font.BOLD, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("REGISTRATION");
		getContentPane().setBackground(Color.PINK);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setBounds(257, 32, 208, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(149, 107, 69, 39);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(149, 169, 92, 39);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_2.setBounds(149, 222, 69, 39);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone No.");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_3.setBounds(149, 280, 92, 39);
		getContentPane().add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.ITALIC, 25));
		btnNewButton.setBounds(152, 428, 184, 50);
		getContentPane().add(btnNewButton);
		
		userid_text = new JTextField();
		userid_text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userid_text.setBounds(403, 107, 170, 39);
		getContentPane().add(userid_text);
		userid_text.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(403, 169, 170, 39);
		getContentPane().add(passwordField);
		
		email_txt = new JTextField();
		email_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email_txt.setColumns(10);
		email_txt.setBounds(403, 222, 170, 39);
		getContentPane().add(email_txt);
		
		phn_txt = new JTextField();
		phn_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phn_txt.setColumns(10);
		phn_txt.setBounds(403, 280, 170, 39);
		setSize(870, 554);
		getContentPane().add(phn_txt);
		
		JLabel city_lb = new JLabel("City");
		city_lb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		city_lb.setBounds(172, 342, 69, 39);
		getContentPane().add(city_lb);
		
		city_txt = new JTextField();
		city_txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		city_txt.setColumns(10);
		city_txt.setBounds(403, 329, 170, 39);
		getContentPane().add(city_txt);
		
		JButton clear_bt = new JButton("CLEAR");
		clear_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid_text.setText("");
				passwordField.setText("");
				email_txt.setText("");
				phn_txt.setText("");
				city_txt.setText("");
			}
		});
		clear_bt.setFont(new Font("Arial", Font.ITALIC, 25));
		clear_bt.setBounds(580, 428, 184, 50);
		getContentPane().add(clear_bt);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
