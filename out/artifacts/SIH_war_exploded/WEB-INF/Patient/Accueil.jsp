<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 05/08/2019
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Acceuil patient</title>
</head>
<body>
<h1>Hello</h1>
<c:if test="${not empty utilisateur}">
    <ul>
        <li>
            <c:out value="${ utilisateur.nom } "/> <c:out value="${ utilisateur.prenom } " />
            <c:out value="${ utilisateur.dateNaissance} "/><c:out value="${ utilisateur.tel} " /><c:out value="${ utilisateur.email} " />
        </li>
    </ul>
</c:if>

<h1>Fonction patient</h1>
<a>Demander rendez-vous</a></br>
<a>Consulter mon dossier</a></br>
</body>
</html>
