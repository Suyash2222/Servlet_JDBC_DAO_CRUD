package com.user.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

	private static String  driverName="com.mysql.jdbc.Driver";
	private static String  url="jdbc:mysql://localhost:3306/adjt1";
	private static String username="root";
	private static String password="root";
	
	public static Connection  initConnection()
	{
		Connection con=null;
		try
		{
			Class.forName(driverName);
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return con;
	}	
	
}
