package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserLoginDao;
import com.user.dao.UserLoginDaoImpl;
import com.user.model.UserLogin;

/**
 * Servlet implementation class UserLoginController
 */
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String usernm=request.getParameter("username");
		String pass=request.getParameter("pwd");
		
		UserLogin user=new UserLogin(usernm, pass);
		
		UserLoginDao loginDao=new UserLoginDaoImpl();
		String res=loginDao.validateUser(user);
		
		if(res.equalsIgnoreCase("valid"))
		{
			request.getRequestDispatcher("Home.html").forward(request, response);
		}
		else
		{
			out.print("<h3 style='color:red'>Invalid username or incorreect password</h3>");
			request.getRequestDispatcher("Login.html").include(request, response);
		
		}
		
		
		
	}

}
