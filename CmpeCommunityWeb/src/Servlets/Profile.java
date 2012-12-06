package Servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tables.PostsTable;
import Tables.TagsTable;
import Tables.UserTable;
import drivers.PostDriver;
import drivers.ReplyDriver;
import drivers.TagsDriver;
import drivers.UserDriver;

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
		PostsTable[] posts = PostDriver.getWallPosts(userId);
		if (posts == null)
			return;
		Map<Integer, UserTable> users = new TreeMap<Integer, UserTable>();
		for (PostsTable post : posts)
			if(users.get(post.getOwner_id()) == null)
				users.put(post.getOwner_id(), UserDriver.getById(post.getOwner_id()));
		request.setAttribute("posts", posts);
		request.setAttribute("users", users);
		request.setAttribute("replies", ReplyDriver.getReplies(posts));
		UserTable user = UserDriver.getById(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/ProfileWall.jsp").include(request, response);
	}

	public void news(Integer userId) throws ServletException, IOException{
		if(getCurrentUser() == null)
			return;
		PostsTable[] posts = PostDriver.getNewsFeedByUserId(userId);
		if (posts == null)
			return;
		Map<Integer, UserTable> users = new TreeMap<Integer, UserTable>();
		for (PostsTable post : posts)
			if(users.get(post.getOwner_id()) == null)
				users.put(post.getOwner_id(), UserDriver.getById(post.getOwner_id()));
		request.setAttribute("posts", posts);
		request.setAttribute("replies", ReplyDriver.getReplies(posts));
		request.setAttribute("users", users);
		UserTable user = UserDriver.getById(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/PostListView.jsp").include(request, response);
	}
	
	public void details(Integer userId) throws IOException, ServletException{
		if(getCurrentUser() == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
			return;
		}
		response.setContentType("text/html");
		UserTable user = UserDriver.getById(userId);
		if(user == null){
			//TODO show 404
			return;
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("/layout/header.jsp").include(request, response);
		request.getRequestDispatcher("/ProfilePage.jsp").include(request, response);
		request.getRequestDispatcher("/layout/footer.jsp").include(request, response);
	}
	
	public void tags(Integer userId) throws ServletException, IOException{
		if(getCurrentUser() == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
			return;
		}
		
		UserTable user = UserDriver.getById(userId);
		if(user == null){
			//TODO show 404
			return;
		}
		request.setAttribute("user", user);
		
		
		
		TagsTable[] tags = TagsDriver.getByUserId(userId);
		request.setAttribute("tags", tags);
		
		response.setContentType("text/html");
		request.getRequestDispatcher("/layout/header.jsp").include(request, response);
		request.getRequestDispatcher("/TagList.jsp").include(request, response);
		request.getRequestDispatcher("/layout/footer.jsp").include(request, response);
	}
	
}
