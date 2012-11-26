
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.TagsTable" %>
<%@ page import="Tables.UserTable" %>


	<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap-tagmanager.css">
	<script type="text/javascript" src="/CmpeCommunityWeb/js/bootstrap-tagmanager.js"></script>
	<script>
	  jQuery(".tagManager").tagsManager();
	</script>

	<div class="nav span6 nav-tabs">
		<%UserTable user = (UserTable)request.getAttribute("user"); %>
		<div class="row">
			<div class="span3 offset2">
				<form name="form1" method="post" action="/CmpeCommunityWeb/Tags/addTags">
					<input class="FormText" type="hidden" name="clickedButton" id="clickedButton" value="" >
					<fieldset>
						<div class="controls">
							<input type="text" name="tags" placeholder="Enter a new tag.." class="tagManager"/>
							<input type="submit" class="btn btn-info btn-block" value="Add"/>
						</div>
					</fieldset>
    			</form>
			</div>
		</div>
		<table class = "table table-zebra">
			<%TagsTable[] tags = (TagsTable[])request.getAttribute("tags");
			for(TagsTable tag: tags) {%>
			<tr>
				<td>
					<a href="/CmpeCommunityWeb/Tags/details/<%=tag.getId()%>"><%= tag.getTag()%></a>
				</td>
			</tr>	 
			<%}%>
		</table>
	</div>
