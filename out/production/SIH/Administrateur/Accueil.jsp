<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 04/08/2019
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello</h1>
<c:if test="${not empty administrateur}">
    <ul>
        <li>
            <c:out value="${ administrateur.nom } "/> <c:out value="${ administrateur.prenom } " />
            <c:out value="${ administrateur.nomUtilisateur} "/>
        </li>
    </ul>
</c:if>
<div>
    <a href="/SIH_war_exploded/GestionPersonnel">Gestion personnel</a></br>
    <a href="/SIH_war_exploded/GestionChambre">Gestion Chambre</a></br>
</div>

</body>
</html>
