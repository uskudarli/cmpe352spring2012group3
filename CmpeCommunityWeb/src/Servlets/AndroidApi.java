package Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tables.PostsTable;
import Tables.TagsTable;
import Tables.UserTable;
import UtilityPack.HashString;
import drivers.PostDriver;
import drivers.TagsDriver;
import drivers.UserDriver;

public class AndroidApi extends ServletBase {

	public AndroidApi(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	public void login() throws ServletException, IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email+" "+password);
		response.setContentType("application/json");
		if(email==null || password==null ){
			response.getOutputStream().println("{'success': false, 'error': 'All fields should be filled'}");
		}
		else if(UserDriver.isCredentialsValid(email, password)){
			response.getOutputStream().println("{'success': true }");
		}
		else{
			request.setAttribute("loginFailed", 1);
			response.getOutputStream().println("{'success': false, 'error': 'Email and password does not match'}");
		}
	}
	
	public void register() throws ServletException, IOException{
		String email = request.getParameter("email");
		String name = request.getParameter("name")+" "+request.getParameter("last_name");
		String password = request.getParameter("password");
		System.out.println(email+" "+name+" "+password);
		String birthDate = "1970-01-01";
		String registerDate = "1970-01-01";
		response.setContentType("application/json");
		Tables.UserTable user = null;
		try {
			user = new Tables.UserTable(email, name, HashString.encrypt(password), birthDate, registerDate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(UserDriver.createUser(user)){
			response.getOutputStream().println("{'success': true }");
		}
		else{
			response.getOutputStream().println("{'success': false }");
		}
	}
	
	public void newsFeed() throws IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(!UserDriver.isCredentialsValid(email, password))
			return;
		UserTable user = UserDriver.getByEmail(email);
		if(user == null){
			System.out.println("user is null");
			return;
		}
		newsFeed(user.getId());
	}
	
	public void newsFeed(Integer id) throws IOException{
		PostsTable[] posts = PostDriver.getWallPosts(id);
		response.setContentType("application/json");
		String output = "{posts: [";
		for (PostsTable post : posts) {
			UserTable owner = UserDriver.getById(post.getOwner_id());
			output = output+"{";
				output = output+"'id': "+post.getId()+",";
				output = output+"'content': '"+post.getBody().replaceAll("'", "")+"',";
				output = output+"'posting_time': '"+niceTime(post.getPosting_time())+"',";
				output = output+"'owner_id': "+owner.getId()+",";
				output = output+"'owner_name': '"+owner.getName().replaceAll("'", "")+"'";
			output = output+"},";
		}
		if(output.charAt(output.length()-1) == ',')
			output = output.substring(0, output.length()-1);
		output = output+"]}";
		System.out.println(output);
		response.getOutputStream().println(output);
	}
	
	public void wall() throws IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(!UserDriver.isCredentialsValid(email, password))
			return;
		UserTable user = UserDriver.getByEmail(email);
		if(user == null){
			System.out.println("user is null");
			return;
		}
		wall(user.getId());
	}
	
	public void wall(Integer id) throws IOException{
		PostsTable[] posts = PostDriver.getWallPosts(id);
		response.setContentType("application/json");
		String output = "{posts: [";
		for (PostsTable post : posts) {
			UserTable owner = UserDriver.getById(post.getOwner_id());
			output = output+"{";
				output = output+"'id': "+post.getId()+",";
				output = output+"'content': '"+post.getBody().replaceAll("'", "")+"',";
				output = output+"'posting_time': '"+niceTime(post.getPosting_time())+"',";
				output = output+"'owner_id': "+owner.getId()+",";
				output = output+"'owner_name': '"+owner.getName().replaceAll("'", "")+"'";
			output = output+"},";
		}
		if(output.charAt(output.length()-1) == ',')
			output = output.substring(0, output.length()-1);
		output = output+"]}";
		System.out.println(output);
		response.getOutputStream().println(output);
	}
	
	public void tags() throws IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(!UserDriver.isCredentialsValid(email, password))
			return;
		UserTable user = UserDriver.getByEmail(email);
		if(user == null){
			System.out.println("user is null");
			return;
		}
		tags(user.getId());
	}
	
	public void tags(Integer id) throws IOException{
		TagsTable[] tags = TagsDriver.getByUserId(id);
		response.setContentType("application/json");
		String output = "{tags: [";
		for (TagsTable tag : tags) {
			output = output+"{";
				output = output+"'id': "+tag.getId()+",";
				output = output+"'tag': '"+tag.getTag()+"'";
			output = output+"},";
		}
		if(output.charAt(output.length()-1) == ',')
			output = output.substring(0, output.length()-1);
		output = output+"]}";
		System.out.println(output);
		response.getOutputStream().println(output);
	}
	
	private String niceTime(String time){
		Calendar cal = Calendar.getInstance();

		time = time.substring(0, time.length()-2);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = null;
		try {
			date1 = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date date2 = cal.getTime();
		long difference = date2.getTime() - date1.getTime();
		
		long year = (((long)1000)*60*60*24*365);
		long month = (((long)1000)*60*60*24*30);
		
		if(difference > year)
			return (difference/year)+" years ago";
		if(difference > month)
			return (difference/month)+" months ago";
		if(difference > (1000*60*60*24))
			return (difference/(1000*60*60*24))+" days ago";
		if(difference > (1000*60*60))
			return (difference/(1000*60*60))+" hours ago";
		if(difference > 1000*60)
			return (difference/(1000*60))+" minutes ago";
		return (difference)+" seconds ago";
	}
}
