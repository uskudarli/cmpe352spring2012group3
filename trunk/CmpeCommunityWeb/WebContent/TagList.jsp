
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.TagsTable" %>
<%@ page import="Tables.UserTable" %>


	<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap-tagmanager.css">
	<script type="text/javascript" src="/CmpeCommunityWeb/js/bootstrap-tagmanager.js"></script>
<script type="text/javascript">
function addTags() {
	document.forms['form1'].submit();
}
</script>

	<div class="nav span6 nav-tabs">
		<%UserTable user = (UserTable)request.getAttribute("user"); %>
		<div class="row">
			<div >
				<!-- <form name="form1" method="post" class="form-horizontal" action="/CmpeCommunityWeb/Tags/addTags/<%=user.getId()%>">
				-->	
				<div class="form-horizontal">
					<input class="FormText" type="hidden" name="clickedButton" id="clickedButton" value="" >
					<fieldset>
					<div class="control-group">
						<div class="controls">						
							<input type="text" name="tags" placeholder="new tags, seperated with comma" class="tagManager"/>
							<input type="submit" class="btn btn-info" value="Add" onclick="Tags.add(<%=user.getId()%>);"/>
						</div>
					</div>
					</fieldset>
				</div>
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
	
	<script>
	  jQuery(".tagManager").tagsManager();
	</script>
