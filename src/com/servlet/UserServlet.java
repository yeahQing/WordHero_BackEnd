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
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		
		if(action.equals("addUser")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String mobile = request.getParameter("mobile");
			User obj = new User(0,username,password,mobile);
			int addUser = DaoFactory.getUserDao().addUser(obj);
			if(addUser > 0) {
				List<User> userList = DaoFactory.getUserDao().queryUserList();
				request.getSession().setAttribute("userList", userList);
				request.getRequestDispatcher("User_Manager.jsp").forward(request, response);
			}
			
		}else if(action.equals("saveUserData")){
			String user_id = request.getParameter("user_id");
			User userdata = DaoFactory.getUserDao().queryObject(Integer.parseInt(user_id));
			if(userdata != null) {
				request.setAttribute("userData", userdata);
				request.getRequestDispatcher("update_User.jsp").forward(request, response);
			}
		}else if(action.equals("updateUser")){
			
			String user_id = request.getParameter("user_id");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String mobile = request.getParameter("mobile");
			String score = request.getParameter("score");
			String level = request.getParameter("level");
			
			User obj = new User(Integer.parseInt(user_id),username,password,mobile,Integer.parseInt(score),Integer.parseInt(level));
			int updateUserAllData = DaoFactory.getUserDao().updateUserAllData(obj);
			if( updateUserAllData > 0) {
				List<User> userList = DaoFactory.getUserDao().queryUserList();
				request.getSession().setAttribute("userList", userList);
				request.getRequestDispatcher("User_Manager.jsp").forward(request, response);
			}else {
				request.setAttribute("update_error", "用户名或手机号已被占用");
				request.getRequestDispatcher("update_User.jsp").forward(request, response);
			}
			
		}else if(action.equals("deleteUser")) {
			String user_id = request.getParameter("user_id");
			int delete = DaoFactory.getUserDao().delete(Integer.parseInt(user_id));
			
			if( delete > 0 ) {
				List<User> userList = DaoFactory.getUserDao().queryUserList();
				request.getSession().setAttribute("userList", userList);
				request.getRequestDispatcher("User_Manager.jsp").forward(request, response);
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
