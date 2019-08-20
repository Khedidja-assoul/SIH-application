<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 19/08/2019
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="list" items="${list}">
    <ul>
        <li>
            <c:out value="${list.id}"/>
            <c:out value="${list.detaille}"/>
        </li>
    </ul>

</c:forEach>
</body>
</html>