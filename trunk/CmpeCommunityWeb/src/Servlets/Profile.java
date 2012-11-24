package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import drivers.PostDriver;
import drivers.UserDriver;

import Tables.PostsTable;
import Tables.UserTable;

public class Profile extends ServletBase {

	public Profile(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void index() throws IOException, ServletException{
		UserTable user = getCurrentUser();
		if(user == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
			return;
		}
		details(user.getId());
	}

	public void wall(Integer userId) throws ServletException, IOException{
		if(getCurrentUser() == null)
			return;
		PostsTable[] posts = PostDriver.getPostsByUserId(userId);
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/PostListView.jsp").include(request, response);
	}

	public void news(Integer userId) throws ServletException, IOException{
		if(getCurrentUser() == null)
			return;
		PostsTable[] posts = {
			new PostsTable(1, 1, "Post id 1", "2012-11-24"),
			new PostsTable(2, 1, "Post id 2", "2012-11-24"),
			new PostsTable(3, 2, "Post id 3", "2012-11-24"),
			new PostsTable(4, 2, "Post id 4", "2012-11-24"),
			new PostsTable(5, 2, "Post id 5", "2012-11-24"),
			new PostsTable(6, 3, "Post id 6", "2012-11-24")
		};
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/PostListView.jsp").include(request, response);
	}
	
	public void details(Integer userId) throws IOException, ServletException{
		if(getCurrentUser() == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
			return;
		}
		response.setContentType("text/html");
		System.out.println("hi "+ userId);
		UserTable user = UserDriver.getById(userId);
		System.out.println(user);
		if(user == null){
			//TODO show 404
			return;
		}
		System.out.println("loading");
		request.setAttribute("user", user);
		request.getRequestDispatcher("/layout/header.jsp").include(request, response);
		request.getRequestDispatcher("/ProfilePage.jsp").include(request, response);
		request.getRequestDispatcher("/layout/footer.jsp").include(request, response);
	}
}
