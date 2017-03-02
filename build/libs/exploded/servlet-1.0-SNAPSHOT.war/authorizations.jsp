<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.02.2017
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>authorization</title>
</head>
<body>
<h1>Авторизация</h1>

<form action="/students/login" method="post">
    <label for="login">Введите логин:</label>
    <input type="text" name="login_name" id="login" value="" placeholder="Введите логин">
    <br />
    <label for="password">Введите пароль:</label>
    <input type="password" name="password_name" id="password" value="" placeholder="Пароль">
    <br />
    <input type="submit" value="Войти">
</form>
<a href="/registration">registration</a>


</body>
</html>
