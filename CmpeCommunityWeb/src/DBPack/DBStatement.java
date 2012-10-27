package DBPack;

import java.sql.*;

public class DBStatement {
	private Connection conn = null;
	private String url="jdbc:mysql://titan.cmpe.boun.edu.tr:3306/database3";
	private String driver = "com.mysql.jdbc.Driver";
	private String userName = "project3"; 
	private String password = "yjQ81J";

	public DBStatement() throws Exception {
		   Class.forName("com.mysql.jdbc.Driver");
           this.conn = DriverManager.getConnection(url,userName,password);
	}
	public Connection getConnection() {
		return conn;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}