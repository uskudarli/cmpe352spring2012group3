package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends ServletBase {

	public User(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	public void login() throws ServletException, IOException{
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	public void loginAction() throws ServletException, IOException{
		String email = request.getParameter("email_login");
		String password = request.getParameter("password_login");
		if(email==null || password==null )
			request.getRequestDispatcher("/User/login").forward(request, response);
		//TODO call data model method for login
		if(email.equalsIgnoreCase("emresunecli@gmail.com") && password.equalsIgnoreCase("123456")){
			//TODO record login to session
			request.getRequestDispatcher("/Profile").forward(request, response);
		}
		else{
			request.setAttribute("loginFailed", 1);
			request.getRequestDispatcher("/User/login").forward(request, response);
		}
	}
	
	public void registerAction(){
		//TODO register action similar to login action
	}
	
	public void logout() throws ServletException, IOException{
		//TODO logout action with session
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
