package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserRegisterDao;
import com.user.dao.UserRegisterDaoImpl;
import com.user.model.UserRegister;

/**
 * Servlet implementation class UserRegisterController
 */
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String nm=request.getParameter("uname");
		String usernm=request.getParameter("username");
		String pass=request.getParameter("pwd");
		String c_pass=request.getParameter("c_pwd");
		String email=request.getParameter("mail");
		String phone=request.getParameter("ph");
		
		Long ph1=Long.parseLong(phone);
		
		
		
		if(pass.equals(c_pass))
		{
			//creat model object
			UserRegister user=new UserRegister(nm, usernm, pass, email, ph1);
			//get dao ref
			UserRegisterDao ud=new UserRegisterDaoImpl();
			//call dao method
			int res=ud.saveUser(user);
			
			if(res>0)
			{
				request.getRequestDispatcher("Login.html").forward(request, response);
			}
			else
			{
				out.print("<h3 style='color:red'>something went wrong.pls try again later</h3>");
				request.getRequestDispatcher("Register.html").include(request, response);
			
			}
			
			
			
			
		}
		else
		{
			out.print("<h3 style='color:red'>password and confirm password must be same</h3>");
			request.getRequestDispatcher("Register.html").include(request, response);
			
		}
		
		
		
		
		
	}

}
