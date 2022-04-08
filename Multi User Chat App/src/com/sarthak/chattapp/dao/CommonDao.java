package com.sarthak.chattapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.sarthak.chattapp.utils.ConfigReader.getValue;
public interface CommonDao {
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName(getValue("DRIVER"));
		final String Connection_String=getValue("CONNECTION_URL");
		final String User_id=getValue("USER_ID");
		final String pass=getValue("PASSWORD");
		Connection con=DriverManager.getConnection(Connection_String,User_id,pass);
		
		return con;
	}


}
