package DBPack;

import java.sql.*;

public class DBStatement {
	private static final String url="jdbc:mysql://titan.cmpe.boun.edu.tr:3306/database3";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String userName = "project3"; 
	private static final String password = "yjQ81J";

	private static Connection connection = null;

	public static Connection getMainConnection(){
		if(connection != null)
			return connection;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}