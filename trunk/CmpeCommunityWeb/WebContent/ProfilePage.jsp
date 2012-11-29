<%@page import="Tables.UserTable"%>
<%
	UserTable user = (UserTable)request.getAttribute("user");
%>
<div style="margin-left: 30px">
			<ul class="nav span6 nav-tabs">
				<li><a href="#" onclick="Posts.loadNewsFeed(<%=user.getId()%>)" data-toggle="tab">News Feed</a></li>
				<li><a href="#" onclick="Posts.loadWall(<%=user.getId()%>)" data-toggle="tab">Wall</a></li>
			</ul>
	<div id="contentBody" class="span6"></div>
</div>
<script type="text/javascript">
<!--
	$(document).ready(function(){
		Posts.loadWall(<%=user.getId()%>);
	});
//-->
</script>
