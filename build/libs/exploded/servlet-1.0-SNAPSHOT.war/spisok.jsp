<%@ page import="ru.ramazanov.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Spisok</title>
</head>
<body>
    <h1>Spisok</h1>

    <table border="1">
        <tr>
            <td><b>ID</b></td>
            <td><b>Name</b></td>
            <td><b>Group_id</b></td>
            <td><b>Birthday</b></td>
            <td><b>Sex</b></td>
            <td></td>
        </tr>
        <c:forEach items="${userlist}" var="userItem">
            <tr>
                <td>
                    <a href="/students/edit?id=<c:out value="${userItem.id}"></c:out>">
                    <c:out value="${userItem.id}"></c:out>
                    </a>
                </td>
                <td><c:out value="${userItem.name}"></c:out></td>
                <td><c:out value="${userItem.group_id}"></c:out></td>
                <td><c:out value="${userItem.birthdate}"></c:out></td>
                <td><c:out value="${userItem.sex}"></c:out></td>
                <td>
                    <a href="/students/edit?id=<c:out value="${userItem.id}"></c:out>">
                        Редактировать</a>
                    <a href="/students/delete?id=<c:out value="${userItem.id}"></c:out>">
                        Удалить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%= request.getAttribute("test") %>
</body>
</html>
