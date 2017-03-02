<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.02.2017
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Error</h1>
<h2><%= request.getParameter("error")%></h2>
</body>
</html>
