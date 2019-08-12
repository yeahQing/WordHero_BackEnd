package com.pojo;

public class Admin {
	private int admin_id;
	private String admin_name;
	private String admin_password;
	
	public Admin() {}
	
	public Admin(int admin_id,String admin_name,String admin_password) {
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_password = admin_password;
	}
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
	
}
