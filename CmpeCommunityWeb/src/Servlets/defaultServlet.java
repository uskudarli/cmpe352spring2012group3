package Servlets;

import Receivers.defaultReceiver;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tables.Users;
import UtilityPack.HashString;

/**
 * Servlet implementation class defaultServlet
 */
@WebServlet("/default")
public class defaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public defaultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello from GET Method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username="";
		String password="";
		String email="";
		String birth_date="";
		String register_date="";
		Users user;
		
		System.out.println("Hello from POST Method");
		request.setAttribute("default", "default");
		String processCode=request.getParameter("clickedButton");
		defaultReceiver rc = new defaultReceiver(request,response);
		if (processCode.equals("login")) {
		username=request.getParameter("email_login");
		password=request.getParameter("password_login");
			try {
				String encryptedPassword=HashString.encrypt(password);
				System.out.println(encryptedPassword);
				
				String decryptedPassword=HashString.decrypt(encryptedPassword);
				System.out.println(decryptedPassword);
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (processCode.equals("signUp")) {
			email=request.getParameter("email_signup");
			password=request.getParameter("password_signup");
			username=request.getParameter("first-name")+" "+request.getParameter("last-name");
			user=new Users(email,username,password,birth_date,register_date);
			try {
				rc.performSignUp(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		getServletConfig().getServletContext().getRequestDispatcher("/default.jsp").forward(request, response);
	}
        
}
