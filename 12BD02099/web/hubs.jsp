<%@page import="java.util.ArrayList"%>
<div class="txt">
    <h3 id = "title">Hubs</h3>
    <ul>
        <%
            ArrayList<String> hubs = (ArrayList<String>)request.getAttribute("title"); 
            for(int i=0; i < hubs.size(); i++){
                %> 
                <li><a href="hub?id=<%= i+1 %>"><%= hubs.get(i) %></a></li>
                <%
            }
        %> 
    </ul>
</div>