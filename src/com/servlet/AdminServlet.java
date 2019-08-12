package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.factory.DaoFactory;
import com.pojo.Admin;
import com.pojo.Library;
import com.pojo.User;
import com.pojo.Word;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String action = request.getParameter("action");
		if(action.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("登陆信息" + username + password);
			
			Admin obj = new Admin(0,username,password);
			
			Admin admin = DaoFactory.getAdminDao().login(obj);
			List<User> userList = DaoFactory.getUserDao().queryUserList();
			List<Word> wordList = DaoFactory.getWordDao().queryAll();	
			List<Library> libraryList = DaoFactory.getLibraryDao().queryAll();
			if (admin != null) {
				if(admin.getAdmin_password().equals(password)) {
					
					request.getSession().setAttribute("user", admin);
					request.getSession().setAttribute("userList",userList);
					request.getSession().setAttribute("wordList",wordList);
					request.getSession().setAttribute("libraryList",libraryList);
					request.getRequestDispatcher("main.jsp").forward(request, response);
					
				}else {
					
					request.setAttribute("error", "密码不正确");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else {
				
				request.setAttribute("error", "用户名不存在或不正确");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
			
		}else if(action.equals("register")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("注册信息:" + username + password);
			Admin obj = new Admin(0,username,password);
			int add = DaoFactory.getAdminDao().add(obj);
			
			if (add > 0) {
				request.setAttribute("info", "注册成功");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "注册失败");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if(action.equals("updateAdmin")) {
			String admin_id = request.getParameter("admin_id");
			String admin_name = request.getParameter("username");
			String admin_password = request.getParameter("password");
			Admin obj = new Admin(Integer.parseInt(admin_id),admin_name,admin_password);
			
			int update = DaoFactory.getAdminDao().update(obj);
			if(update > 0) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
		
	}

}
