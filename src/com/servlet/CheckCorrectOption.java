package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.factory.DaoFactory;
import com.pojo.User;
import com.pojo.Word;

/**
 * Servlet implementation class CheckCorrectOption
 */
@WebServlet("/CheckCorrectOption")
public class CheckCorrectOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCorrectOption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		System.out.println("问题:" + question + " 选项:" + answer);
		User user = (User)request.getSession().getAttribute("user");
		
		Word queryWord = DaoFactory.getWordDao().queryWord(question);
		
		System.out.println(queryWord.getWord_translate());
		String res = " " + queryWord.getWord_translate();
		if(res.equals(answer)) {
			int update_score = DaoFactory.getUserDao().update_score(user.getUser_id());
			System.out.println(update_score);
			if(update_score > 0) {
				response.setStatus(200);
				response.getWriter().write("正确!");
			}
		}else {
			response.setStatus(201);
			response.getWriter().write("错误!");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
