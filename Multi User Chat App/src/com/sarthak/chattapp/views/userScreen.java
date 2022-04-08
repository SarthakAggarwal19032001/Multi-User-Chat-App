package com.sarthak.chattapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.sarthak.chattapp.dao.userDao;
import com.sarthak.chattapp.dto.userDto;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userScreen extends JFrame{
	private JTextField userid_txt;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		userScreen window=new userScreen();
	}
	
	private void dologin() {
		String userid=userid_txt.getText();
		char[] password=passwordField.getPassword();
		userDao userdao=new userDao();
		userDto userdto=new userDto(userid,password);
		String message="Welcome "+userid;
		try {
			boolean result=userdao.isLogin(userdto);
			if(result) {
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose();
				DashBoard dashboard=new DashBoard(message);
				dashboard.setVisible(true);
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid Credentials");
			}
			}
			
			catch(Exception e) {
				System.out.print(e);
				e.printStackTrace();
			}
		}
	public userScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(303, 23, 120, 45);
		getContentPane().add(lblNewLabel);
		
		userid_txt = new JTextField();
		userid_txt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		userid_txt.setBounds(428, 119, 253, 39);
		getContentPane().add(userid_txt);
		userid_txt.setColumns(10);
		
		JLabel userid_lb = new JLabel("UserID");
		userid_lb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		userid_lb.setBounds(307, 117, 99, 39);
		getContentPane().add(userid_lb);
		
		JLabel psw_lb = new JLabel("Password");
		psw_lb.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		psw_lb.setBounds(307, 196, 99, 39);
		getContentPane().add(psw_lb);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField.setBounds(428, 196, 253, 39);
		getContentPane().add(passwordField);
		
		JButton login_bt = new JButton("LOGIN");
		login_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dologin();
			}
		});
		login_bt.setFont(new Font("Times New Roman", Font.BOLD, 25));
		login_bt.setBounds(56, 300, 144, 45);
		getContentPane().add(login_bt);
		
		JButton register_bt = new JButton("REGISTER");
		register_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new user_registration();
				setVisible(false);
				dispose();
			}
		});
		register_bt.setFont(new Font("Times New Roman", Font.BOLD, 25));
		register_bt.setBounds(303, 300, 179, 45);
		getContentPane().add(register_bt);
		
		JButton clear_bt = new JButton("Clear");
		clear_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid_txt.setText("");
				passwordField.setText("");
				
			}
		});
		clear_bt.setFont(new Font("Times New Roman", Font.BOLD, 25));
		clear_bt.setBounds(567, 300, 151, 45);
		getContentPane().add(clear_bt);
		setSize(833, 406);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
