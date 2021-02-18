<%@ page import="gr.eurodyn.training.spittrapp.domain.Spitter" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Spitter> allSpitters = (List<Spitter>) request.getAttribute("list");
%>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
        <% for(Spitter s : allSpitters) { %>

            <tr>
                <td> <%= s.getFirstname() %></td>
                <td> <%= s.getLastname() %></td>
            </tr>

        <% } %>
</body>
</html>
