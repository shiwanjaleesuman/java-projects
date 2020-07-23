/**
 * 
 */
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

/**
 * @author ssuman
 *
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("pasword");

		PrintWriter out = response.getWriter();

		LoginDao dao = new LoginDao();

		if (dao.checkLoginCredentials(userName, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("uName", userName);
			response.sendRedirect("Welcome.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
//			rd.include(request, response);
		}

		else {
			out.println("<h3>Invalid Username or Password.</h3><hr/>");
			response.sendRedirect("Login.jsp");
//			 RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//			 rd.include(request, response);
		}

//		try 
//		{ 
//			 //PrintWriter out = response.getWriter();
//			 //response.setContentType("text/html");
//		 
//			 // Reference of the ServletConfig object is obtained from the servlet
//			 ServletConfig config = getServletConfig();
//		 
//			 // Reference of ServletContext is obtained from the config 
//			 ServletContext ctx = config.getServletContext();
//		 
//			 Class.forName(ctx.getInitParameter("driverClass"));
//			 
//			 Connection con = DriverManager.getConnection(ctx.getInitParameter("url"),
//			 ctx.getInitParameter("user"), ctx.getInitParameter("password"));
//			 
//			 PreparedStatement stmt = con.prepareStatement("select * from user_account where USER_NAME=? and PASSWORD=?");
//		 
//			 // Parameter values are set in the statement 
//			 stmt.setString(1, userName);
//			 stmt.setString(2, password);
//		 
//			 // Query is executed
//			 ResultSet rset = stmt.executeQuery();
//			 if (rset.next()) 
//			 {
//				 // user is valid, it's name is fetched to generate the response
//				 //out.println("<h3>Welcome, " + rset.getString(1) + "</h3>");
//				 
//				 RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
//				 rd.include(request, response);
//				 
//				 response.sendRedirect("Welcome.jsp"); 
//			 } 
//			 else
//			 { 
//				 // Error message is generated
//				 //out.println("<h3>Invalid mailId or Password.</h3><hr/>"); 
//				 // contents of index.html get included
//				 RequestDispatcher rd = request.getRequestDispatcher("Login.jsp"); 
//				 rd.include(request, response); 
//			}
//			 
//		    // output stream and connection are closed //out.close(); con.close(); 
//		}
//		 
//	    catch (Exception ex) 
//	    { 
//	    	 System.out.println(ex);
//	    }
		 
		out.close();
	}
}
