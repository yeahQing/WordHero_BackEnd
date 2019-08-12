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
import com.pojo.Word;

/**
 * Servlet implementation class LibraryServlet
 */
@WebServlet("/Library")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryServlet() {
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
		
		if(action.equals("addLibrary")) {
			
			String ques_name = request.getParameter("ques_name");
			String level = request.getParameter("level");
			String options = request.getParameter("options");

			System.out.println(ques_name + " " + level + " " + options);
			String[] option = options.split(";");
			
			Library obj = new Library(0,option[0],option[1],option[2],option[3],Integer.parseInt(level));
			
			int add = DaoFactory.getLibraryDao().add(obj);
			if(add > 0) {
				List<Library> libraryList = DaoFactory.getLibraryDao().queryAll();
				request.getSession().setAttribute("libraryList",libraryList);
				request.getRequestDispatcher("Question_Lib_Manager.jsp").forward(request, response);
			}
			
		}else if(action.equals("saveLibraryData")){
			
			String ques_id = request.getParameter("ques_id");
			Library libraryData = DaoFactory.getLibraryDao().queryObject(Integer.parseInt(ques_id));
			String options = libraryData.getOption_1() +";"+ libraryData.getOption_2() +";"+  libraryData.getOption_3() +";"+ libraryData.getOption_4();
			
		
			if(libraryData != null) {
				request.setAttribute("libraryData", libraryData);
				request.setAttribute("options", options);
				request.getRequestDispatcher("update_Question_Lib.jsp").forward(request, response);
			}
			
		}else if(action.equals("updateLibrary")){
			
			String ques_id = request.getParameter("ques_id");
			String ques_name = request.getParameter("ques_name");
			String level = request.getParameter("level");
			String options = request.getParameter("options");

			System.out.println(ques_name + " " + level + " " + options);
			String[] option = options.split(";");
			
			Library obj = new Library(Integer.parseInt(ques_id),option[0],option[1],option[2],option[3],Integer.parseInt(level));
			
			int updateLibraryAllData = DaoFactory.getLibraryDao().update(obj);
			if( updateLibraryAllData > 0) {
				List<Library> libraryList = DaoFactory.getLibraryDao().queryAll();
				request.getSession().setAttribute("libraryList",libraryList);
				request.getRequestDispatcher("Question_Lib_Manager.jsp").forward(request, response);
			}
			
		}else if(action.equals("deleteLibrary")) {
			String ques_id = request.getParameter("ques_id");
			
			
			int delete = DaoFactory.getLibraryDao().delete(Integer.parseInt(ques_id));
			
			if( delete > 0 ) {
				List<Library> libraryList = DaoFactory.getLibraryDao().queryAll();
				request.getSession().setAttribute("libraryList",libraryList);
				request.getRequestDispatcher("Question_Lib_Manager.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
