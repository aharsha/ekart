package com.harsha.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.harsha.ecommerce.model.User;



public class UserTransaction 
{
	/*
	public void insertUser(User user)
	{
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sqlpra","sqlpra");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into users values(?,?,?,?)");
		preparedStatement.setString(1,user.getUserName());
		preparedStatement.setString(2,user.getPassword());
		preparedStatement.setString(3,user.getEmail());
		preparedStatement.setString(4,user.getMobilNo());
		
		preparedStatement.executeQuery();
		
		
		connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	
}
