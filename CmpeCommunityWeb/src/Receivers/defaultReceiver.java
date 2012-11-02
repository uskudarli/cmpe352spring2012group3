package Receivers;

import java.sql.*;

import DBPack.DBStatement;
import Tables.UserTable;
import UtilityPack.HashString;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class defaultReceiver {
	HttpServletRequest req;
	HttpServletResponse resp;
	
	public defaultReceiver(HttpServletRequest request, HttpServletResponse response) {
		this.req=request;
		this.resp=response;
	}
	public boolean performLogin() {
		boolean result=false;
		
		return result;
	}
	public boolean performSignUp(UserTable user) throws Exception {
		boolean result=false;
		DBStatement db=new DBStatement();
		try {
		String query="INSERT INTO users(email,password_hash,name,birth_date,register_date) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps=(PreparedStatement) db.getConnection().prepareStatement(query);
		ps.setString(1,user.getEmail());
		ps.setString(2,HashString.encrypt(user.getPassword_hash()));
		ps.setString(3,user.getName());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		   
		ps.setString(4,dateFormat.format(date));
		ps.setString(5,dateFormat.format(date));
		ps.executeUpdate();
		result=true;
		} catch(SQLException e) {
			result=false;
		} finally {
			db.getConnection().close();
		}
		return result;
	}
	public boolean performLogin(UserTable user) throws Exception {
		boolean result=false;
		return result;
	}
}
