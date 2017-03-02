<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.02.2017
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table border="1">
    <c:forEach items="${userlist}" var="userItem">
        <tr>
            <td><c:out value="${userItem}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<br>
test

</body>
</html>
