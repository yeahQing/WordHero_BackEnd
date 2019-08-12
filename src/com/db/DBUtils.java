package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		try {//47.104.192.19
			//return DriverManager.getConnection("jdbc:mysql://47.104.192.19:3306/word_hero?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull", "root", "Ni1SHi5SHa6BiBac");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/word_hero?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull", "root", "yeahqing919");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
