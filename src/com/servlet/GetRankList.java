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

/**
 * Servlet implementation class GetRankList
 */
@WebServlet("/GetRankList")
public class GetRankList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRankList() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<User> userlist = DaoFactory.getUserDao().queryAll();
		
		if(userlist != null) {
			String str = "";
			for(int i = 0;i < userlist.size();i++) {
				//System.out.println(userlist.get(i).getUsername());
				str += userlist.get(i).getUser_id() + "," + userlist.get(i).getUsername() + "," + userlist.get(i).getScore() + ";";
			}
			
			System.out.println(str);
			response.getWriter().write(str);
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
