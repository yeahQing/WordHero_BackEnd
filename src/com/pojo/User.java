package com.pojo;

public class User {
	private int user_id;
	private String username;
	private String password;
	private String mobile;
	private int score;
	private int level_id;
	
	public User() {}
	
	public User(int user_id,String username,String password) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}
	
	public User(int user_id,String username,String password,int score) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.score = score;
	}
	
	public User(int user_id,String username,String password,String mobile) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
	}
	
	public User(int user_id,String username,String password,String mobile,int score,int level_id) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.score = score;
		this.level_id = level_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	
	
}
