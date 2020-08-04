/**
 * 
 */
package com.product.list.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author ssuamn
 *
 */
public class MySQLConnUtils 
{
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException
	{
		String url = "jdbc:mysql://localhost:3306/shivy";
		String userName = "root";
		String password = "password";
		return getMySQLConnection(url, userName, password);
	}

	private static Connection getMySQLConnection(String url, String userName, String password) throws ClassNotFoundException, SQLException
	{
		// registering the Driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		//creating connection object
		Connection con = (Connection) DriverManager.getConnection(url, userName, password);
		return con;
	}
}
