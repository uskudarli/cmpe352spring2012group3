package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.org.mozilla.javascript.json.JsonParser;

import UtilityPack.HashString;

import drivers.UserDriver;

public class AndroidApi extends ServletBase {

	public AndroidApi(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	public void login() throws ServletException, IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email+" "+password);
		response.setContentType("application/json");
		if(email==null || password==null ){
			response.getOutputStream().println("{'success': false, 'error': 'All fields should be filled'}");
		}
		else if(UserDriver.isCredentialsValid(email, password)){
			//TODO record login to session
			response.getOutputStream().println("{'success': true }");
		}
		else{
			request.setAttribute("loginFailed", 1);
			response.getOutputStream().println("{'success': false, 'error': 'Email and password does not match'}");
		}
	}
	
	public void register() throws ServletException, IOException{
		String email = request.getParameter("email");
		String name = request.getParameter("name")+" "+request.getParameter("last_name");
		String password = request.getParameter("password");
		if(password.equals(request.getParameter("password_repeated"))){
			response.getOutputStream().println("{'success': false, 'error': 'Passwords do not match.'}");
		}
		System.out.println(email+" "+name+" "+password);
		String birthDate = "1970-01-01";
		String registerDate = "1970-01-01";
		response.setContentType("application/json");
		Tables.UserTable user = null;
		try {
			user = new Tables.UserTable(email, name, HashString.encrypt(password), birthDate, registerDate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(UserDriver.createUser(user)){
			response.getOutputStream().println("{'success': true }");
		}
		else{
			response.getOutputStream().println("{'success': false }");
		}
	}
}
