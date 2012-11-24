<!--

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
	<title>Cmpe Community</title>
	<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap.min.css">
	<style type="text/css">
	body { padding-top: 60px; }
	
	</style>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap-responsive.min.css">
</head>
<body>

-->
<%@ page import="Tables.TagsTable" %>
<%@ page import="Tables.UserTable" %>

<div style="margin-left: 30px">
	<div>
		<%UserTable user = (UserTable)request.getAttribute("user"); %>
		<div class="row">
			<div class="span3 offset2">
				<form name="form1" method="post">
					<input class="FormText" type="hidden" name="clickedButton" id="clickedButton" value="" >
					<fieldset>
						<div class="controls">
							<input type="text" id="post" name="AddTag" class="input-xlarge" placeholder="Enter a tag">
							<input type="button" class="btn btn-info btn-block" value="Add"/>
						</div>
					</fieldset>
    			</form>
			</div>
		
		<table class = "table table-zebra">
			<%TagsTable[] tags = (TagsTable[])request.getAttribute("tags");
			for(TagsTable tag: tags) {%>
			<tr>
				<td>
					 <!-- Class body bla bla-->
					<%= tag.getTag()%>
					
				</td>
			</tr>	 
			<%}%>
		</table>
	</div>
</div>



		
<!--	
</body>
</html>
-->