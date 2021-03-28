package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
       Validate userValidate = new Validate();
       try {
    	   User user = userValidate.checkUser(username, password);
    	   String destPage = "login.html";
    	   if (user != null) {
    		   HttpSession session = request.getSession();
    		   session.setAttribute("user",user);
    		  destPage = "home.jsp";
    	   } else { 
    		   String message = "Invalid username or password";
    		   request.setAttribute("message", message);
    		   response.setContentType("text/plain"); 
               response.setCharacterEncoding("UTF-8"); 
               response.getWriter().write(message); 
               destPage = "error.jsp";
    		   
    	   }
    			   
       RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
       dispatcher.forward(request, response);
       } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {

	doGet(request, response);
	}
}