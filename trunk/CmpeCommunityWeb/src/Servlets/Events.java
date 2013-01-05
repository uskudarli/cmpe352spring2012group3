package Servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tables.PostsTable;

import Tables.SurveyTable;

import Tables.ReplyTable;

import Tables.TagsTable;
import Tables.UserTable;
import drivers.PostDriver;
import drivers.ReplyDriver;
import drivers.SurveyDriver;
import drivers.TagsDriver;
import drivers.UserDriver;


public class Events extends ServletBase{
	
	public Events(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public void myEvents(Integer userId)throws IOException, ServletException{
		if(getCurrentUser() == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
			return;
		}

		request.setAttribute("type", "myEvents");
		request.setAttribute("user",getCurrentUser());
		request.getRequestDispatcher("/EventList.jsp").include(request, response);
	}
	
	public void attendedEvents(Integer userId)throws IOException, ServletException{
		if(getCurrentUser() == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
			return;
		}
		
		request.setAttribute("type", "");
		request.setAttribute("user",getCurrentUser());

		request.getRequestDispatcher("/EventList.jsp").include(request, response);
		
	}

}

