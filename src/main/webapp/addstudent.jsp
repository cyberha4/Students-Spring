<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.02.2017
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h2>Add student</h2>
<% if (request.getParameter("error") != null) {%>
<b>Error</b>
<%=request.getParameter("error")%>
<% } %>
<br>

<form action="/students/add" method="post">
    <label for="name">Имя:</label>
    <input type="text" name="name" id="name" value="" placeholder="Input">
    <br>
    <label for="group">Группа:</label>
    <input type="text" name="group" id="group" value="" placeholder="Input">
    <br>
    <label for="birthday">День рождения:</label>
    <input type="text" name="birthday" id="birthday" value="" placeholder="Input">
    <br>
    <label for="email">email:</label>
    <input type="text" name="email" id="email" value="" placeholder="Input">
    <br>
    <label for="sex">Пол:</label>
    <input type="text" name="sex" id="sex" value="" placeholder="Input">
    <br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
