package Servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletBase {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public ServletBase(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
}
