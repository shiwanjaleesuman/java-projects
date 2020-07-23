package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class LoginDao 
{
	public boolean checkLoginCredentials(String pUser, String pPass)
	{
		try 
		{
			//register the Driver class/load the class driver.
			Class.forName("com.mysql.jdbc.Driver");
			
			//to make the connection object
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivy", "admin", "admin");
			
			PreparedStatement stmt = con
					.prepareStatement("select * from user_account where USER_NAME=? and PASSWORD=?");

			// Parameter values are set in the statement
			stmt.setString(1, pUser);
			stmt.setString(2, pPass);

			// Query is executed
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) 
			{
				return true;
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return false;
	}
}
