<%@ page import="ru.ramazanov.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First app</title>
</head>
<body>
    <h1>First app - index</h1>
    <div>
        <a href="/list">Open list</a>
    </div>
    <div>
        <div>
            <%= request.getParameter("test") %>
            <% String message = "3242342"; %>
            <%= request.getAttribute("test2") %>
            <% //User user = (User) request.getAttribute("user"); %>
            <% //user.getName() %>
        </div>
        <form action="/" method="post">
            <label for="input">Label:</label>
            <input type="text" name="input" id="input" value="" placeholder="Input">
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
