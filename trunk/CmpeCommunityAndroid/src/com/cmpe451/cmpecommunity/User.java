package com.cmpe451.cmpecommunity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class User {
	public static String email;
	public static String password;
	public static String name;
	public static int id;

	public static List<NameValuePair> GetNameValuePair()
	{
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
		nameValuePair.add(new BasicNameValuePair("email", User.email));
		nameValuePair.add(new BasicNameValuePair("password", User.password));
		
		return nameValuePair;
	}
}
