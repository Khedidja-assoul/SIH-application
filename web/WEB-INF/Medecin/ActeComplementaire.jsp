<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 19/08/2019
  Time: 18:02
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
             Acte id :<c:out value="${list.id}"/>
             Analyse id : <c:out value="${analyse}"/>
        </li>
    </ul>

</c:forEach>
</body>
</html>
