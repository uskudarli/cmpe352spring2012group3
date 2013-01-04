package Servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tables.ForumTopicTable;
import Tables.ForumsTable;
import Tables.UserTable;
import drivers.ForumsDriver;

public class Forum extends ServletBase {

	public Forum(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void index() throws ServletException, IOException{
		response.setContentType("text/html");
		ForumsTable[] categories = ForumsDriver.getCategories();
		Map<Integer, ForumsTable[]> subForums = new TreeMap<Integer, ForumsTable[]>();
		for(ForumsTable category: categories){
			ForumsTable[] forums = ForumsDriver.getByParentId(category.getId());
			subForums.put(category.getId(), forums);
			for(ForumsTable f: forums)
				subForums.put(f.getId(), ForumsDriver.getByParentId(f.getId()));
		}
		request.setAttribute("categories", categories);
		request.setAttribute("subForums", subForums);
		request.getRequestDispatcher("/categories.jsp").include(request, response);
	}
	
	public void index(Integer forumId) throws ServletException, IOException{
		response.setContentType("text/html");
		ForumsTable category = ForumsDriver.getById(forumId);
		Map<Integer, ForumsTable[]> subForums = new TreeMap<Integer, ForumsTable[]>();
		ForumsTable[] parents = ForumsDriver.getParentsById(forumId);
		
		if(category != null){
			ForumsTable[] forums = ForumsDriver.getByParentId(category.getId());
			subForums.put(category.getId(), forums);
			for(ForumsTable f: forums)
				subForums.put(f.getId(), ForumsDriver.getByParentId(f.getId()));
			ForumTopicTable[] topics = ForumsDriver.getTopicsByForumId(forumId);
			
			request.setAttribute("topics", topics);
			request.setAttribute("category", category);
			request.setAttribute("subForums", subForums);
			request.setAttribute("parents", parents);
			request.getRequestDispatcher("/forums.jsp").include(request, response);
		}
	}
	
	public void newtopic(Integer forumId)throws ServletException, IOException{
		response.setContentType("text/html");
		ForumsTable forum = ForumsDriver.getById(forumId);
		if(forum != null){
			ForumsTable[] parents = ForumsDriver.getParentsById(forumId);
			request.setAttribute("forum", forum);
			request.setAttribute("parents", parents);
			request.getRequestDispatcher("/newtopic.jsp").include(request, response);
		}
	}
	
	public void createtopic(Integer forumId) throws IOException, ServletException{
		UserTable user = getCurrentUser();
		if(user == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
		}else{
			String title =  request.getParameter("title");
			String content = request.getParameter("content");
			ForumsDriver.createTopic(forumId, title, content, user.getId());
			request.getRequestDispatcher("/Forum/index/" + forumId).forward(request, response);
		}
	}
}
