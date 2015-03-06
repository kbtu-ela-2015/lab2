<%-- 
    Document   : newslist
    Created on : 02.10.2014, 21:21:45
    Author     : aibek
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href=" main.css" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<div class="content">
<div class="text">
<h3 id = "title">News</h3>
<ul>
    <%
        ArrayList<String> news = (ArrayList<String>)request.getAttribute("titles"); 
        ArrayList<String> ids = (ArrayList<String>)request.getAttribute("ids"); 

        for(int i=0; i<news.size(); i++){
            %> <form action = "newsdetails" method="POST">
               <input type="hidden" value="<% out.println(ids.get(i));%>" name = "id">
            <button type="submit" id = "text">
                <%     out.println(news.get(i));
                %>
             </button></form><br>
    <%
        }
    %> 
</ul>
</div>
</div> 

    </body>
</html>
