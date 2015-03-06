<%-- 
    Document   : MainPage
    Created on : 02.10.2014, 19:01:00
    Author     : aibek
--%>

<%@page import="controllers.MainPageController"%>
<%@page import="controllers.NewsController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Aibek</title>
<link rel="stylesheet" type="text/css" href=" main.css" />

</head>
<body>
<div class="content">
<div class="text">
<h3 id = "title">${requestScope['title']}</h3>
<ul>
<li id = "text">${requestScope['content']} </li>
</ul>
</div>

</div>

</body>
</html>
