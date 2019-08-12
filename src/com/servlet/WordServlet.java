package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.factory.DaoFactory;
import com.pojo.User;
import com.pojo.Word;

/**
 * Servlet implementation class WordServlet
 */
@WebServlet("/Word")
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String action = request.getParameter("action");
		
		if(action.equals("addWord")) {
			
			String word_name = request.getParameter("word_name");
			String word_translate = request.getParameter("word_translate");
			
			Word obj = new Word(0,word_name,word_translate);
			int add = DaoFactory.getWordDao().add(obj);
			
			if(add > 0) {
				List<Word> wordList = DaoFactory.getWordDao().queryAll();	
				request.getSession().setAttribute("wordList",wordList);
				request.getRequestDispatcher("Word_Manager.jsp").forward(request, response);
			}
			
		}else if(action.equals("saveWordData")){
			
			String word_id = request.getParameter("word_id");
			Word wordData = DaoFactory.getWordDao().queryObject(Integer.parseInt(word_id));
			if(wordData != null) {
				request.setAttribute("wordData", wordData);
				request.getRequestDispatcher("update_Word.jsp").forward(request, response);
			}
			
		}else if(action.equals("updateWord")){
			
			String word_id = request.getParameter("word_id");
			String word_name = request.getParameter("word_name");
			String word_translate = request.getParameter("word_translate");
			
			Word obj = new Word(Integer.parseInt(word_id),word_name,word_translate);
			
			int updateWordAllData = DaoFactory.getWordDao().update(obj);
			if( updateWordAllData > 0) {
				List<Word> wordList = DaoFactory.getWordDao().queryAll();
				request.getSession().setAttribute("wordList",wordList);
				request.getRequestDispatcher("Word_Manager.jsp").forward(request, response);
			}
			
		}else if(action.equals("deleteWord")) {
			String word_id = request.getParameter("word_id");
			
			
			int delete = DaoFactory.getWordDao().delete(Integer.parseInt(word_id));
			
			if( delete > 0 ) {
				List<Word> wordList = DaoFactory.getWordDao().queryAll();
				request.getSession().setAttribute("wordList",wordList);
				request.getRequestDispatcher("Word_Manager.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
