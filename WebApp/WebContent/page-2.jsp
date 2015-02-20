<%@page import="java.util.Date"%>
<%@page import="com.post.kz.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/blog.css" rel="stylesheet">
</head>
<body>
	<div class="container">

      <div class="blog-header">
        <h1 class="blog-title">One Million Lines</h1>
        <p class="lead blog-description">One Million Lines of Code_</p>
      </div>

      <div class="row">

        <div class="col-sm-8 blog-main">

          <div class="blog-post">
            <h2 class="blog-post-title">Blog by</h2><%= request.getParameter("name") %>
            <p class="blog-post-meta"></p>
          <form name="MyForm" action="PostServlet" method="post">  
		<h3>Post:</h3> <%= new Date() %>
			<div style="border: 2px;">
				<%= ((MyPost)request.getAttribute("post")).getPost().toString().substring(1,((MyPost)request.getAttribute("post")).getPost().toString().length()-1) %>
			</div>
		</form>
          

        </div><!-- /.blog-main -->
      </div><!-- /.row -->
</div>
    </div><!-- /.container -->
</body>
</html>