package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.factory.DaoFactory;
import com.pojo.User;

/**
 * Servlet implementation class LoginUserName
 */
@WebServlet("/GetUserData")
public class GetUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user = (User)request.getSession().getAttribute("user");
		User new_user = DaoFactory.getUserDao().query_userAllData(user.getUser_id());
		int level_id = user.getLevel_id();
		String level_name = DaoFactory.getQuesDao().queryLevel_name(new_user.getLevel_id());
		int score = DaoFactory.getUserDao().query_score(user.getUser_id());
		
		System.out.println("用户名:" + new_user.getUsername()+ " 积分:" + score + " 题库等级:" + level_name);
		response.setStatus(200);
		response.getWriter().write(new_user.getUsername()+";"+score+";"+level_name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
