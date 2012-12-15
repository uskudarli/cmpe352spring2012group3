<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Tables.UserTable" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
    <title>Cmpe Community</title>
    <link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap-tagmanager.css">
    <style type="text/css">
    body { padding-top: 60px; }
    
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/CmpeCommunityWeb/css/bootstrap-responsive.min.css">
    <script type="text/javascript" src="/CmpeCommunityWeb/js/jquery.min.js"></script>
    <script type="text/javascript" src="/CmpeCommunityWeb/js/main.js"></script>
</head>
<body>
<%UserTable user=(UserTable)request.getAttribute("user");%>
<%UserTable[] recommendedUsers=(UserTable[])request.getAttribute("recommendUsers");%>

    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a href="/CmpeCommunityWeb/" class="brand">Cmpe Community</a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li><a href="/CmpeCommunityWeb/Profile">Home</a></li>
                        <li><a href="/CmpeCommunityWeb/Forum">Forum</a></li>
                    </ul>

                    <form action="#" class="navbar-search">
                        <input type="text" placeholder="Search" class="search-query span3"
                            name="q" value="" /> <input type="hidden" name="scope"
                            id="search_scope" value="posts">
                    </form>
                    <ul class="nav pull-right">
                        <li><a href="/CmpeCommunityWeb/User/logout">Account</a></li>
                        <li><a href="/CmpeCommunityWeb/User/logout">Logout</a></li>
                    </ul>
                </div>
                
            </div>
        </div>
    </div>
    <div class="container offset1">
    <div class="span3">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th><img src="/CmpeCommunityWeb/img/minions.jpg"></th>
                </tr>
                <tr>
                    <th class="well"><%=user.getName()%></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <a href="/CmpeCommunityWeb/Profile/tags/<%=user.getId()%>">Tags</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="/CmpeCommunityWeb/Profile/event">Events</a>
                    </td>
                </tr>
                <tr class="text-info">
                    <td><a href="/CmpeCommunityWeb/Profile/survey/<%=user.getId()%>">Surveys</a></td>
                </tr>
                <tr class="text-info">
                    <td>Advance Search</td>
                </tr>
            
            </tbody>
        </table>
        
        <table class="table table-hover">
            <thead>
                <tr class="success">
                    <th>Recommended Users</th>
                </tr>
            </thead>
            <tbody>
            <%if(recommendedUsers != null){ %>
            <%for(UserTable u: recommendedUsers){ %>
                <tr class="text-info">
                    <td><a class="text-success" href="/CmpeCommunityWeb/Profile/survey/<%=user.getId()%>">Surveys</a></td>
                </tr>
            <%} %>
            <%} %>
            </tbody>
        </table>        
        </div>