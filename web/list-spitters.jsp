<%@ page import="domain.Spitter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lgeso
  Date: 2/15/2021
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Spitters</title>
</head>
<%
    List<Spitter> spitters = (List<Spitter>) request.getAttribute("SPITTER_LIST");
%>
<body>
    <%= spitters %>
</body>
</html>
