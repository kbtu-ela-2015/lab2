<%@page import="java.util.ArrayList"%>
<div class="txt">
    <h3 id = "title">Contacts</h3>
    <%
        ArrayList<String> username = (ArrayList<String>)request.getAttribute("username"); 
        ArrayList<String> surname = (ArrayList<String>)request.getAttribute("surname"); 
        ArrayList<String> phone = (ArrayList<String>)request.getAttribute("phone"); 
        ArrayList<String> home_phone = (ArrayList<String>)request.getAttribute("home_phone"); 
        ArrayList<String> address = (ArrayList<String>)request.getAttribute("address"); 
        for(int i=0; i < username.size(); i++){
            %> 
            <ul>
                <li>Name: <%= username.get(i) %></li>
                <li>Surname: <%= surname.get(i) %></li>
                <li>Phone: <%= phone.get(i) %></li>
                <li>Home phone: <%= home_phone.get(i) %></li>
                <li>Address: <%= address.get(i) %></li>
        </ul>
            <%
        }
    %> 
</div>
