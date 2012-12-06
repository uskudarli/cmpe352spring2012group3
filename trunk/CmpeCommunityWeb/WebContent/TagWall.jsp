
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.TagsTable" %>

<% TagsTable tag = (TagsTable)request.getAttribute("tag"); %>
<% Integer tagId = (Integer)request.getAttribute("tag_id"); %>
<div class="row">
	<div >
		<input class="FormText" type="hidden" name="clickedButton" id="clickedButton" value="" >
		<fieldset>
			<div class="controls">
				<input type="text" name="tag_post" placeholder="Enter a new posts for tag" style="width:350px; margin-left:90px;"/>
				<input type="submit" onclick="Posts.createWithTaggedId(<%= tagId %>)" class="btn btn-info btn-block" value="Post" style="width:100px;float:right"/>
			</div>
		</fieldset>
	</div>
</div>
<hr/>
<%@include file='PostListView.jsp'%>
