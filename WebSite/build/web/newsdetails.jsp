<%-- 
    Document   : newjsp
    Created on : 02.10.2014, 23:41:46
    Author     : aibek
--%>

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
<li id = "text">${requestScope['content']}</li>
</ul>
</div>
</div>

</body>
</html>
