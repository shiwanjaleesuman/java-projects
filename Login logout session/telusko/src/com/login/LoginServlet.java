package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.jfr.ContentType;

@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uName = request.getParameter("userId");
		String pswd = request.getParameter("password");
		
		//PrintWriter pw = response.getWriter();
		//response.setContentType("text/HTML");
		HttpSession session = request.getSession();
		
		session.setAttribute("uName", uName);
		
		if (uName.equals("Shivy") && pswd.equals("Shivy"))
		{
			response.sendRedirect("Welcome.jsp");
		}
		else
		{
			//pw.println("<h3>Invalid Username or Password.</h3><hr/>");
			response.sendRedirect("Login.jsp");
		}
	}
}
