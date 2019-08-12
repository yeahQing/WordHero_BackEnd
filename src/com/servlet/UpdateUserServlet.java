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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		if(action.equals("getUserData")) {
			User user = (User)request.getSession().getAttribute("user");			
			User new_user = DaoFactory.getUserDao().query_userAllData(user.getUser_id());
			response.setStatus(200);
			response.getWriter().write(new_user.getUsername()+";"+new_user.getPassword()+";"+new_user.getMobile());
		}else if(action.equals("updateUserData")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String mobile = request.getParameter("mobile");
			User user = (User)request.getSession().getAttribute("user");
			System.out.println(user.getUser_id());
			System.out.println("修改信息:" + user.getUser_id() + username + password + mobile);
			User obj = new User(user.getUser_id(), username, password,mobile);
			int update = DaoFactory.getUserDao().update(obj);
			
			if (update> 0) {
				response.setStatus(200);
			}else {
				response.setStatus(201);
				response.getWriter().write("修改失败");
			}
		}
		

	}

}
