package com.sarthak.chattapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sarthak.chattapp.network.Client;
import com.sarthak.chattapp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ClientChatScreen extends JFrame {
	private JTextArea textArea;
	private JPanel contentPane;
	private JTextField textField;
	private Client client;

	public static void main(String[] args){
					try {
						ClientChatScreen frame = new ClientChatScreen();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
	}
	public void sendIt(){
		String message=textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME+" - "+message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea=new JTextArea();
		client=new Client(textArea);
		setTitle("Online");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 768, 313);
		contentPane.add(scrollPane);
		
		//JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.ITALIC, 16));
		textArea.setBounds(10, 24, 713, 280);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(10, 351, 559, 63);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sended = new JButton("SEND MESSAGE");
		sended.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sended.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
				textField.setText("");
			}
		});
		sended.setBounds(618, 351, 135, 49);
		contentPane.add(sended);
		
		setVisible(true);
	}
}
