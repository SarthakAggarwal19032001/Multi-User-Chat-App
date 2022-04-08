package com.sarthak.chattapp.dto;

public class userDto {
	private String userid;
	private char[] password;
	private String email;
	private String phoneno;
	private String city;
	
	public userDto(String userid,char[] password,String email,String phoneno,String city) {
		this.userid=userid;
		this.password=password;
		this.email=email;
		this.phoneno=phoneno;
		this.city=city;
		
	}
	public userDto(String userid,char[] password) {
		this.userid=userid;
		this.password=password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
