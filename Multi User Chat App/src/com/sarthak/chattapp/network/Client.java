package com.sarthak.chattapp.network;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;

import com.sarthak.chattapp.utils.ConfigReader;

public class Client {
	public Client() throws UnknownHostException, IOException {
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		Socket socket=new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		System.out.print("Client Comes....");
		socket.close();
		
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client=new Client();

	}

}
