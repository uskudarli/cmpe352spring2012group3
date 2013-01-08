package com.cmpe451.cmpecommunity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class StaticUser {
	public static String email;
	public static String password;
	public static User currentUser;

	public static Feed chosenFeed;
	public static Tag chosenTag;
	public static User chosenUser;
	//public static int chosenUserID;
	public static String URL = "http://192.168.1.105:8082";
	
	public static List<NameValuePair> GetNameValuePair()
	{
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
		nameValuePair.add(new BasicNameValuePair("email", StaticUser.email));
		nameValuePair.add(new BasicNameValuePair("password", StaticUser.password));
		
		return nameValuePair;
	}
}
