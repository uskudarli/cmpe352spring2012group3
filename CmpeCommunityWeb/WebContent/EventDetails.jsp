<%@page import="Tables.EventTable"%>

<% EventTable event = (EventTable)request.getAttribute("event"); %>
<% boolean attending = (Boolean)request.getAttribute("attending"); %>

<h2><%=event.getPlace() %></h2>
<div class='span6'>
<% if(attending) { %>
	<button onclick='Events.unAttend(<%=event.getId() %>);' class='btn btn-info pull-right'>unAttend</button>
<% } else { %>
	<button onclick='Events.attend(<%=event.getId() %>);' class='btn btn-success pull-right'>Attend</button>
<% } %>
	<p><strong>Emre Sunecli</strong></p>
</div>
<div class='span6 clearfix' style='text-indent: 20px; margin-bottom: 50px;'>
	<% for(String p : event.getDescription().split("\n")) { %>
		<p><%=p %></p>
	<% } %>
	<hr />
	
</div>
