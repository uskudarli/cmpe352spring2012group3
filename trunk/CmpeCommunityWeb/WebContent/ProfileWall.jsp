
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.*" %>
<%UserTable user = (UserTable)request.getAttribute("user"); %>
<div class="row">
			<div >
				<fieldset>
					<div class="controls">
						<input type="text" name="posts" placeholder="Enter a new posts" style="width:350px; margin-left:90px;"/>
						<input type="submit" onclick="Posts.createWithTaggedUserId(<%=user.getId()%>);" class="btn btn-info btn-block" value="Post" style="width:100px;float:right"/>
					</div>
				</fieldset>
			</div>
		</div>
<%@include file='PostListView.jsp'%>