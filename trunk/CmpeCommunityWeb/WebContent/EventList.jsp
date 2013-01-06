<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.TagsTable"%>

<%@ page import="Tables.UserTable"%>
<link rel="stylesheet"
    href="/CmpeCommunityWeb/css/bootstrap-tagmanager.css">
<link rel="stylesheet"
    href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css">

<style>
.progress .bar p {
    color: #000;
    font-size: 12px;
    text-align: left;
    margin-left: -20px text-shadow:   0px -1px 0px rgba(0, 0, 0, 0.25);
}

.ui-timepicker-div .ui-widget-header { margin-bottom: 8px; }
.ui-timepicker-div dl { text-align: left; }
.ui-timepicker-div dl dt { height: 25px; margin-bottom: -25px; }
.ui-timepicker-div dl dd { margin: 0 10px 10px 65px; }
.ui-timepicker-div td { font-size: 90%; }
.ui-tpicker-grid-label { background: none; border: none; margin: 0; padding: 0; }

.ui-timepicker-rtl{ direction: rtl; }
.ui-timepicker-rtl dl { text-align: right; }
.ui-timepicker-rtl dl dd { margin: 0 65px 10px 10px; }
</style>
<script type="text/javascript"
    src="/CmpeCommunityWeb/js/bootstrap-tagmanager.js"></script>
<script type="text/javascript">
    function addTags() {
        document.forms['form1'].submit();
    }
</script>
<script src="/CmpeCommunityWeb/js/bootstrap.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="/CmpeCommunityWeb/js/jquery-ui-timepicker-addon.js"></script>


<script type="text/javascript">
<!--
//     $(document).ready(function(){
<%--         Posts.loadNewsFeed(<%=user.getId()%>, $('.nav-tabs li:first a')); --%>
//     });
//-->
</script>

<div class="nav span6 nav-tabs">
<%String type = (String)request.getAttribute("type"); %>
 <%if (type.equals("myEvents")){ %>
    <div class="row">
        <div>
            <form id="newsurvey" class='row span4' action="">
                <fieldset>
                    <div>
                    <fieldset>
                        <legend>Create Event</legend>
                        <div class="controls">
                           	<input type="text" id="place" name="place" class="input-xlarge" placeholder="Place">

                            <input type="text" id="datetime" name="datetime" class="input-xlarge" placeholder="Date-Time">

                          <textarea type="text" id="description" name="description" class="input-xlarge" placeholder="Description"></textarea>
                        
                            <input type="button" class="btn btn-info pull-right" value="Create" onclick="login()"/>
                        </div>
                    </fieldset>
            </div>
                </fieldset>
            </form>
        </div>
    </div>
    <%} %> 
    
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

    <script>
    $('#datetime').datetimepicker();
    </script>