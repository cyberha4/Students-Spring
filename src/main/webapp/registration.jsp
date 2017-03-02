<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.02.2017
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>registration</h2>
<form action="/students/registration" method="post">
    <label for="login">login:</label>
    <input type="text" name="login" id="login" value="" placeholder="Input">
    <br>
    <label for="password">password:</label>
    <input type="password" name="password" id="password" value="" placeholder="Input">

    <input type="submit" value="Submit">
</form>
</body>
</html>
