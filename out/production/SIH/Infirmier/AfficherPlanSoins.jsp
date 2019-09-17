<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 17/09/2019
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="plan" items="${planSoins}">
    <c:out value="${plan.id}"/>
    <c:out value="${plan.idConsultation}"/>
    <c:forEach var="lig" items="${plan.listeDesSoins}">
        <c:out value="${lig}"/>
    </c:forEach>
</c:forEach>
</body>
</html>
