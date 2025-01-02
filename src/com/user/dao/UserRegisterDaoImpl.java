package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.user.model.UserRegister;
import com.user.util.CreateConnection;

public class UserRegisterDaoImpl implements UserRegisterDao
{

	Connection con=CreateConnection.initConnection();
	@Override
	public int saveUser(UserRegister u) {
		int x=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into userData values(?,?,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getMail());
			ps.setLong(5, u.getPhone());
			
			x=ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		return x;
	}
	
	

}
