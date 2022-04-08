package com.sarthak.chattapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

import com.sarthak.chattapp.dto.userDto;
import com.sarthak.chattapp.utils.encryption;

//user CRUD operation
public class userDao {
	public boolean isLogin(userDto userdto) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Connection connection=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		final String sql="select userid,password from user where userid=? and password=?";
		try {
			connection=CommonDao.createConnection(); 
			pstm=connection.prepareStatement(sql);
			pstm.setString(1, userdto.getUserid());
			pstm.setString(2, encryption.passwordEncrpt(new String(userdto.getPassword())));
			rs=pstm.executeQuery();
			return rs.next();
		}
		finally {
			if(rs!=null) {
				rs.close();
				}
			if(pstm!=null) {
				pstm.close();
				}
				if(connection!=null) {
				connection.close();
				} 
				}
		}
	
	public int add(userDto userdto) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Connection connection=null;
		Statement stm=null;
		int result=0;
		try {
		connection=CommonDao.createConnection();       //connection created
		stm=connection.createStatement();
		String sql="insert into user (userid,password,phno,email,city) values('"+userdto.getUserid()+"','"+encryption.passwordEncrpt(new String(userdto.getPassword()))+"','"+userdto.getPhoneno()+"','"+userdto.getEmail()+"','"+userdto.getCity()+"')";
		result=stm.executeUpdate(sql);
		}
		
		finally {
			if(stm!=null) {
			stm.close();
			}
			if(connection!=null) {
			connection.close();
			} 
			}
		return result;
	}

}
