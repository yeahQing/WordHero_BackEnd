package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.factory.DaoFactory;
import com.pojo.Ques_lib;
import com.pojo.User;

/**
 * Servlet implementation class GetQuestionLibs
 */
@WebServlet("/GetQuestionLibs")
public class GetQuestionLibs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQuestionLibs() {
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
		System.out.println("用户ID:" + user.getUser_id());
		User new_user = DaoFactory.getUserDao().query_userAllData(user.getUser_id());
		System.out.println("查询到新用户的题库等级:" + new_user.getLevel_id());
		Ques_lib queryQues = DaoFactory.getQuesDao().queryQues(new_user.getLevel_id());
		
		
		System.out.println(queryQues.getQues_name() +";"+ queryQues.getOption_1() + ";" + queryQues.getOption_2() + ";"+ queryQues.getOption_3() + ";"+ queryQues.getOption_4());
		
		if(queryQues != null) {
			response.setStatus(200);
			response.getWriter().write(queryQues.getQues_name() +";"+ queryQues.getOption_1() + ";" + queryQues.getOption_2() + ";"+ queryQues.getOption_3() + ";"+ queryQues.getOption_4());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
