package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import drivers.PostDriver;
import drivers.TagsDriver;

import Tables.PostsTable;
import Tables.TagsTable;
import Tables.UserTable;

public class Tags extends ServletBase {

	public Tags(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	public void details(Integer tagId) throws ServletException, IOException{
		TagsTable tag = TagsDriver.getById(tagId);
		if(tag == null){
			//TODO show 404
			return;
		}
		UserTable user = getCurrentUser();
		if(user == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
			return;
		}
		
		request.setAttribute("user", user);
		request.setAttribute("tag", tag);
		request.getRequestDispatcher("/layout/header.jsp").include(request, response);
		request.getRequestDispatcher("/TagView.jsp").include(request, response);
		request.getRequestDispatcher("/layout/footer.jsp").include(request, response);
	}
	
	public void wall(Integer tagId) throws ServletException, IOException{
		if(getCurrentUser() == null)
			return;
		PostsTable[] posts = PostDriver.getPostsByUserId(tagId);
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("/PostListView.jsp").include(request, response);
	}
	
	public void users(Integer tagId){
		
	}
}
