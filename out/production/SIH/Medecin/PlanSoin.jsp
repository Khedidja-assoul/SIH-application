<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 19/08/2019
  Time: 13:04
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
            <c:forEach var="soin" items="${list.listeDesSoins}">
                <c:out value="${soin}"/>
            </c:forEach>

        </li>
    </ul>

</c:forEach>
</body>
</html>
