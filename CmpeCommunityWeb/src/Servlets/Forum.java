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
			if(category.getParentId() != 0){
				//ForumTopicTable[] topics = ForumsDriver.
			}
			ForumsTable[] forums = ForumsDriver.getByParentId(category.getId());
			subForums.put(category.getId(), forums);
			for(ForumsTable f: forums)
				subForums.put(f.getId(), ForumsDriver.getByParentId(f.getId()));
			
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
	
	public void utopic(Integer forumId) throws IOException{
		response.setContentType("application/json");
		UserTable user = getCurrentUser();
		if(user == null){
			response.getOutputStream().println("{\"success\": false, \"error\": \"need_login\"}");
			return;
		}
		String title =  request.getParameter("title");
		String content = request.getParameter("content");

		if(title!=null && content!=null && ForumsDriver.createTopic(forumId, title, user.getId(), content)!=0)
			response.getOutputStream().println("{\"success\": true}");
		else
			response.getOutputStream().println("{\"success\": false, \"error\": \"unknown\"}");
	}
}
