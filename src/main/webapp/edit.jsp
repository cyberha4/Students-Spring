<%@ page import="ru.ramazanov.models.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 23.02.2017
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit Student</h2>
<% Student student = (Student) request.getAttribute("student"); %>

<form action="/students/edit" method="post">
    <label for="name">Имя:</label>
    <input type="text" name="name" id="name" value="<%=student.getName()%>" placeholder="Input">
    <br>
    <label for="group">Группа:</label>
    <input type="text" name="group" id="group" value="<%=student.getGroup_id()%>" placeholder="Input">
    <br>
    <label for="birthday">День рождения:</label>
    <input type="text" name="birthday" id="birthday" value="<%=student.getBirthdate()%>" placeholder="Input">
    <br>
    <label for="sex">Пол:</label>
    <input type="text" name="sex" id="sex" value="<%=student.getSex()%>" placeholder="Input">
    <br>
    <input type="hidden" name = "id" value="<%=student.getId()%>">

    <input type="submit" value="Submit">
</form>
</body>
</html>
