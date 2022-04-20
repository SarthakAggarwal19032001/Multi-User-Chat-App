package com.sarthak.chattapp.views;
//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;


public class SplashScreen extends JWindow {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		SplashScreen frame = new SplashScreen();
		frame.setVisible(true);
		frame.runProgressBar();
	}
	
	private Timer timer ;
	private void runProgressBar() {
		timer = new Timer(40, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				progressBar.setValue(count);
				count++;
				if(count>100) {
					if(timer!=null) {
					timer.stop();
					SplashScreen.this.setVisible(false);
					SplashScreen.this.dispose();
					userScreen UserScreen = new userScreen();
					UserScreen.setVisible(true);
					}
				}
				
			}
		});
		timer.start();
	}
	
	private int count=0;
	JProgressBar progressBar = new JProgressBar();

	public SplashScreen() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		progressBar.setFont(new Font("Tahoma", Font.ITALIC, 18));
		progressBar.setForeground(new Color(0, 120, 215));
		progressBar.setStringPainted(true);
		progressBar.setBounds(94, 400, 677, 18);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/SplashImg.jpg")));
		lblNewLabel.setBounds(94, 10, 688, 469);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
