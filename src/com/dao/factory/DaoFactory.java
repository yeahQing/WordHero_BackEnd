package com.dao.factory;

import com.dao.AdminDao;
import com.dao.LibraryDao;
import com.dao.QuesDao;
import com.dao.UserDao;
import com.dao.WordDao;
import com.dao.impl.AdminDaoImpl;
import com.dao.impl.LibraryDaoImpl;
import com.dao.impl.QuesDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.WordDaoImpl;
import com.pojo.Word;

public class DaoFactory {
	public static UserDao getUserDao(){
		return new UserDaoImpl();
	}
	
	public static QuesDao getQuesDao() {
		return new QuesDaoImpl();
	}
	
	public static WordDao getWordDao() {
		return new WordDaoImpl();
	}
	
	public static AdminDao getAdminDao() {
		return new AdminDaoImpl();
	}
	
	public static LibraryDao getLibraryDao() {
		return new LibraryDaoImpl();
	}
}
