package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.model.UserLogin;
import com.user.util.CreateConnection;

public class UserLoginDaoImpl implements UserLoginDao
{

	@Override
	public String validateUser(UserLogin user) {
		
		String result="";
		
		String entUsername=user.getUsername();
		String entPass=user.getPassword();
		String dbPass="";
		try
		{
				Connection con=CreateConnection.initConnection();
				
				PreparedStatement ps=con.prepareStatement("select password from userdata where username=?");
				ps.setString(1, entUsername);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					dbPass=rs.getString(1);
				}
				con.close();
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		if(entPass.equals(dbPass))
		{
			result="valid";
		}
		else
		{
			result="invalid";
		}
		
		
		return result;
	}
	

}
