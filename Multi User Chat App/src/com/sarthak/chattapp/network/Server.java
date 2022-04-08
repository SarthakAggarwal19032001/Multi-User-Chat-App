package com.sarthak.chattapp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sarthak.chattapp.utils.ConfigReader;

public class Server {
	public Server() throws IOException {
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		ServerSocket serverSocket=new ServerSocket(PORT);
		System.out.println("Server Started, Waiting for Client.....");
		Socket socket =serverSocket.accept();// Handshaking
		System.out.println("Client Joins the server");
		socket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Server server=new Server();

	}

}
