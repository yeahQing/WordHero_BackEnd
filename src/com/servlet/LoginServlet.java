package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.factory.DaoFactory;
import com.pojo.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + password);
		User obj = new User(0, username, password);
		User user = DaoFactory.getUserDao().login(obj);
		
		
		
		if (user != null) {
			if(user.getPassword().equals(password)) {
				response.setStatus(200);
				request.getSession().setAttribute("user", user);
			}else {
				response.setStatus(201);
				response.getWriter().write("密码不正确");
			}
		}else {
			response.setStatus(201);
			response.getWriter().write("用户名不正确");
		}
	}

}
