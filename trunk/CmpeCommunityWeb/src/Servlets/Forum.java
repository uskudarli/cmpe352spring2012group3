package Servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tables.ForumsTable;
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
		
		if(category != null){
			ForumsTable[] forums = ForumsDriver.getByParentId(category.getId());
			subForums.put(category.getId(), forums);
			for(ForumsTable f: forums)
				subForums.put(f.getId(), ForumsDriver.getByParentId(f.getId()));
			
			request.setAttribute("category", category);
			request.setAttribute("subForums", subForums);
			request.getRequestDispatcher("/forums.jsp").include(request, response);
		}
	}
}
