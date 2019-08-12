package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.factory.DaoFactory;
import com.pojo.Library;
import com.pojo.User;
import com.pojo.Word;

/**
 * Servlet implementation class ReloadAllDataServlet
 */
@WebServlet("/ReloadAllData")
public class ReloadAllDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReloadAllDataServlet() {
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> userList = DaoFactory.getUserDao().queryUserList();
		List<Word> wordList = DaoFactory.getWordDao().queryAll();	
		List<Library> libraryList = DaoFactory.getLibraryDao().queryAll();
		request.getSession().setAttribute("userList",userList);
		request.getSession().setAttribute("wordList",wordList);
		request.getSession().setAttribute("libraryList",libraryList);
		
	}

}
