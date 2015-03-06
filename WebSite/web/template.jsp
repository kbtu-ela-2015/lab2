<%-- 
    Document   : template
    Created on : 03.10.2014, 11:38:48
    Author     : aibek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <jsp:include page="header.jsp"/>
    
    <%
        String str = (String) request.getAttribute("page");
        
        if(str.equals("main")){
            %>
                <jsp:include page="mainpage.jsp"/>
        <%    
        }else if(str.equals("news")){
            %>
                <jsp:include page="newslist.jsp"/>
        <%    
        }else if(str.equals("contacts")){
            %>
                <jsp:include page="contacts.jsp"/>
        <%    
        }else if(str.equals("newsdetails")){
            %>
                <jsp:include page="newsdetails.jsp"/>
        <%    
        }
        
    %>
    
    <jsp:include page="footer.jsp"/>

    </body>
</html>
