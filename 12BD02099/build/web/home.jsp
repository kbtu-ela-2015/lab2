<%@page import="controllers.HomeController"%>
<%@page import="controllers.HubsController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="text">
<h3 id = "title">${requestScope['title']}</h3>
<ul>
<li id = "text">${requestScope['content']} </li>
</ul>
</div>
