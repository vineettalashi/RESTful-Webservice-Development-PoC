package org.vineet.restservice.messenger.database;

import java.sql.*;

public class DatabaseConnectionFactory {

public static Connection getDBConnection()
{
	Connection connection = null;
	try 
		{
			Class.forName("com.mysql.jdbc.Driver");				
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoschema","root", "root");
				
		} 
	
	catch (Exception e) 
	{
			e.printStackTrace();
	}
	
	return 	connection;	
	
}


}
