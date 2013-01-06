package Servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import drivers.EventDriver;
import Tables.EventTable;


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

		EventTable[] events=EventDriver.getUserEvent(userId);

		request.setAttribute("user",getCurrentUser());
        request.setAttribute("events", events);
        request.getRequestDispatcher("/EventList.jsp").include(request, response);
	}
	
	public void attendedEvents(Integer userId)throws IOException, ServletException{
		if(getCurrentUser() == null){
			request.getRequestDispatcher("/User/login").forward(request, response);
			return;
		}
		
		request.setAttribute("type", "");
		request.setAttribute("user",getCurrentUser());
        EventTable[] events=EventDriver.getUserJoinedEvent(userId);
        request.setAttribute("events", events);
		request.getRequestDispatcher("/EventList.jsp").include(request, response);
		
	}
	public void addEvents(Integer userId)throws IOException, ServletException{
		if(getCurrentUser() == null)
			return;
		
		request.setAttribute("type", "");
		
		String time=request.getParameter("datetime");
		String description=request.getParameter("description");
		String place=request.getParameter("place");
		java.sql.Timestamp eventTime=java.sql.Timestamp.valueOf(time);
		EventDriver.createEvent(userId, description, place, eventTime);
		request.getRequestDispatcher("/EventList.jsp").include(request, response);
		
	}

}

