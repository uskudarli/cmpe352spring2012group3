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

public class Posts extends ServletBase {

	public Posts(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	public void addPosts(Integer user_id) throws ServletException, IOException{
		String post =  request.getParameter("posts");
		PostDriver.addPosts(user_id,post);
	}
}
