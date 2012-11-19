package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile extends ServletBase {

	public Profile(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void index() throws IOException, ServletException{
		response.setContentType("text/html");
		request.getRequestDispatcher("/layout/header.jsp").include(request, response);
		request.getRequestDispatcher("/layout/footer.jsp").include(request, response);
	}
	
	public void details() throws IOException{
		response.getOutputStream().println("Hi");
	}
}