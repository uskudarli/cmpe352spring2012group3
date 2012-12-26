package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import drivers.PostDriver;
import drivers.SurveyDriver;

import Tables.SurveyTable;
import Tables.UserTable;

public class Surveys extends ServletBase {

	public Surveys(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	public void addSurvey(Integer userId) throws IOException, ServletException {
		response.setContentType("application/json");
		UserTable user = getCurrentUser();
		if(user == null){
			response.getOutputStream().println("{\"success\": false, \"error\": \"need_login\"}");
			return;
		}
		request.setAttribute("user",user);
		request.setAttribute("type","mySurvey");
		String choices = request.getParameter("choices");
		String choiceList[]=choices.split(",");
		if (choiceList==null) {
			response.getOutputStream().println("{\"success\": false, \"error\": \"unknown\"}");
			return;
		}	
		String question=request.getParameter("question");
		if (question.equals("") || choiceList.length<2) {
			return;
		}	
		//get parameters from HTTP POST
		 //String[] choiceList = choices.toArray(new String[choices.size()]);
		 SurveyDriver.createSurvey(userId, question, choiceList);
		//if post body is not null then add the post and tag users or give an error message, which is not expected to occur.
		//request.getRequestDispatcher("/SurveyList.jsp").include(request, response);	
		response.getOutputStream().println("{\"success\": true}");
	}
	public void loadMySurveys(Integer userId) throws IOException, ServletException { 
		UserTable user = getCurrentUser();
		if(user == null){
			response.getOutputStream().println("{\"success\": false, \"error\": \"need_login\"}");
			return;
		}
		request.setAttribute("user",user);
		request.setAttribute("type","mySurvey");
		
		SurveyTable[] surveyList = SurveyDriver.getUserSurvey(userId);
		request.setAttribute("surveyList", surveyList);
		
		request.getRequestDispatcher("/SurveyList.jsp").include(request, response);
	}
	public void loadCompletedSurveys(Integer userId) throws IOException, ServletException {
		UserTable user = getCurrentUser();
		if(user == null){
			response.getOutputStream().println("{\"success\": false, \"error\": \"need_login\"}");
			return;
		}
		request.setAttribute("user",user);
		request.setAttribute("type","myCompletedSurvey");
		
		SurveyTable[] surveyList = SurveyDriver.getUserJoinedSurvey(userId);
		request.setAttribute("surveyList", surveyList);
		
		request.getRequestDispatcher("/SurveyList.jsp").include(request, response);
	}
	/**
	 * Gets posts and users[] paramaters from HTTP POST,
	 * Creates a post in database table and tags users given in users[]
	 * in created post.
	 * Response is either 'success' or and error message written in a single line.
	 * @throws IOException
	 */
	
}
