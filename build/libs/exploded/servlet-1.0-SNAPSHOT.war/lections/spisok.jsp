<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.02.2017
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Spisok Lections</h3>
<table border="1">
    <tr>
        <td><b>ID</b></td>
        <td><b>Title</b></td>
        <td><b>Text</b></td>
        <td><b>Subject</b></td>
        <td></td>
    </tr>
    <c:forEach items="${lections}" var="userItem">
        <tr>
            <td><c:out value="${userItem.id}"></c:out></td>
            <td><c:out value="${userItem.title}"></c:out></td>
            <td><c:out value="${userItem.text}"></c:out></td>
            <td><c:out value="${userItem.subject}"></c:out></td>
            <td>
                <a href="/students/lection-edit?id=<c:out value="${userItem.id}"></c:out>">
                    Редактировать</a>
                <a href="/students/lection-delete?id=<c:out value="${userItem.id}"></c:out>">
                    Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
