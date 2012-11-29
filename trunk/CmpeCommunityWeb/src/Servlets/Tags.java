package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import drivers.PostDriver;
import drivers.TagsDriver;
import drivers.UserDriver;

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
		
		UserTable user = getCurrentUser();
		request.setAttribute("user", user);
		request.setAttribute("posts", posts);
		request.setAttribute("tag_id", tagId);
		request.getRequestDispatcher("/TagWall.jsp").include(request, response);
	}
	public void users(Integer tagId) throws ServletException, IOException{
		if(getCurrentUser() == null)
			return;
		UserTable[] users = UserDriver.getUsersByTag(tagId);
		request.setAttribute("users", users);
		request.getRequestDispatcher("/UserListView.jsp").include(request, response);
	}
	public void addTags(Integer user_id) throws Exception{
		TagsTable[] tagsTable=null;
		String tags =  request.getParameter("hidden-tags");
		if (tags==null)
			return;
		tagsTable=TagsDriver.createTagsArray(tags);
		TagsDriver.createTags(tagsTable,UserDriver.getById(user_id));
	}
	public void addPosts(Integer tag_id,Integer user_id) throws Exception {
		String post=request.getParameter("tag_post");
		PostDriver.addPosts(user_id, post);
		int post_id=PostDriver.getMaxId(user_id);
		if (post_id==0)
			return;
		TagsDriver.insertTagsInPosts(post_id,tag_id);
		
	}
}