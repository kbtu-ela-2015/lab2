<!DOCTYPE html>
    <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ru" lang="ru">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="main.css" />
        <title>Habrahabr</title>
    </head>
    <body>
        <div id="content">
        <jsp:include page="header.jsp"/>
        <%
            String str = (String) request.getAttribute("page");
            if(str.equals("home")){
                %>
                    <jsp:include page="home.jsp"/>
            <%    
            }else if(str.equals("hubs")){
                %>
                    <jsp:include page="hubs.jsp"/>
            <%    
            }else if(str.equals("contacts")){
                %>
                    <jsp:include page="contacts.jsp"/>
            <%    
            }else if(str.equals("hub")){
                %>
                    <jsp:include page="hub.jsp"/>
            <%    
            }
        %>
        <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
