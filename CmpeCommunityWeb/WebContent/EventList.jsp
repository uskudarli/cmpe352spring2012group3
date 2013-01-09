<%@page import="java.util.Map"%>
<%@page import="Tables.EventTable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.TagsTable"%>

<%@ page import="Tables.UserTable"%>

<div class="span6">
<%String type = (String)request.getAttribute("type"); %>
<%if (type.equals("myEvents")){ %>
	<div class="row span4" style='margin-bottom: 25px;'>
		<fieldset>
			<legend>Create Event</legend>
			<div class="controls">
				<input type="text" id="place" name="place" class="input-xlarge" placeholder="Place" />
				<input type="text" name="datetime" class="input-xlarge" placeholder="Date-Time" />
				<textarea id="description" name="description" class="input-xlarge" placeholder="Description"></textarea>
				<input type="button" class="btn btn-info pull-right" value="Create" onclick="Events.add()"/>
			</div>
		</fieldset>
	</div>
	<script>
		$(document).ready(function(){
			$('[name="datetime"]').datetimepicker({dateFormat: 'yy-mm-dd', timeFormat: 'hh:mm:ss'});
		});
	</script>
<%} %>
</div>

<% EventTable[] events = (EventTable[])request.getAttribute("events"); %>
<% Map<Integer, UserTable> users = (Map<Integer, UserTable>)request.getAttribute("users"); %>
<% UserTable user = (UserTable)request.getAttribute("user"); %>

<table class='table'>
<% for(EventTable event: events){ %>
	<tr>
		<td>
			<button class='btn btn-info pull-right'>Details</button>
			<strong>
				<a href='/CmpeCommunityWeb/Profile/details/<%=event.getUserId()%>'><%=users.get(event.getUserId()).getName() %></a>
			</strong><br/>
			<strong>Place: </strong><%=event.getPlace() %><br/>
			<strong>Time: </strong><%=event.getEventTime() %>
		</td>
	</tr>
<% } %>
</table>

<!-- 
    <script src="/CmpeCommunityWeb/js/bootstrap.js"></script>

    <div class="accordion" id="accordion2">
        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                    data-parent="#accordion2" href="#collapseOne"> What is your
                    favorite programming language? </a>
            </div>
            <div id="collapseOne" class="accordion-body collapse">
                <div class="accordion-inner">
                    <div class="row-fluid">
                        <div class="progress progress-warning span2">
                            <div class="bar" style="width: 50%;">
                                <p>&nbsp;50%</p>
                            </div>
                        </div>
                        <div class="span5">
                            <p>Python</p>
                        </div>
                    </div>

                    <div class="row-fluid">
                        <div class="progress progress-warning span2">
                            <div class="bar" style="width: 10%;">
                                <p>&nbsp;10%</p>
                            </div>
                        </div>
                        <div class="span5">
                            <p>Java</p>
                        </div>
                    </div>

                    <div class="row-fluid">
                        <div class="progress progress-warning span2">
                            <div class="bar" style="width: 40%;">
                                <p>&nbsp;40%</p>
                            </div>
                        </div>
                        <div class="span5">
                            <p>C++</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="accordion-group">
            <div class="accordion-heading">
                <a class="accordion-toggle" data-toggle="collapse"
                    data-parent="#accordion2" href="#collapseTwo"> What is your
                    favorite TV show? </a>
            </div>
            <div id="collapseTwo" class="accordion-body collapse">
                <div class="accordion-inner">
                    <form>
                        <label class="radio"> <input type="radio"
                            name="id_of_survey"> Friends
                        </label> <label class="radio"> <input type="radio"
                            name="id_of_survey"> The Big Bang Theory
                        </label> <label class="radio"> <input type="radio"
                            name="id_of_survey"> House M.D.
                        </label>

                        <div class="controls">
                            <button class="btn btn-success" type="button">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

     -->