/**
 * 
 */
package com.product.list.connections;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * @author ssuamn
 *
 */
public class MySQLConnUtils 
{
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException
	{
		String hostName = "localhost";
		String dbName = "shivy";
		String userName = "root";
		String password = "password";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws ClassNotFoundException, SQLException
	{
		// registering the Driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		//creating connection object
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shivy", "root","password");
		return con;
	}
}
