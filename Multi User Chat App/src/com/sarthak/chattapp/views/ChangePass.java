package com.sarthak.chattapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sarthak.chattapp.dao.userDao;
import com.sarthak.chattapp.dto.userDto;
import com.sarthak.chattapp.utils.UserInfo;
import com.sarthak.chattapp.utils.encryption;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	private JPasswordField newpass;
	private JPasswordField confirmpass;

	public static void main(String[] args) {
		
	}
	
	private void Changepass() throws HeadlessException, NoSuchAlgorithmException {
		char [] newPass=newpass.getPassword();
		char [] confirmPass=confirmpass.getPassword();
		
		if((Arrays.equals(newPass, confirmPass))) {
		userDto userdto=new userDto(newPass);
		userDao userdao=new userDao();
		try {
			int result=userdao.changePass(userdto);	
			if(result>0) {
				JOptionPane.showMessageDialog(this, "Password Changed Succesfully");
				setVisible(false);
				dispose();
		     }
			else {
				JOptionPane.showMessageDialog(this, "Password Changed- Unsuccesfull");
			}
		}
		catch(Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		}
		
	
		else {
			JOptionPane.showMessageDialog(this, "Password does not match");
		}
	}
	
	public ChangePass() {
		setBackground(Color.GRAY);
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(300, 44, 258, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(109, 170, 181, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirm Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(109, 284, 181, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JButton chn_pass_button = new JButton("Submit");
		chn_pass_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Changepass();
				} catch (HeadlessException | NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
			}
		});
		chn_pass_button.setForeground(Color.RED);
		chn_pass_button.setFont(new Font("Tahoma", Font.BOLD, 18));
		chn_pass_button.setBounds(568, 383, 123, 35);
		contentPane.add(chn_pass_button);
		
		newpass = new JPasswordField();
		newpass.setBounds(318, 170, 253, 42);
		contentPane.add(newpass);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(318, 284, 253, 42);
		contentPane.add(confirmpass);
		setVisible(true);
	}
}
