<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 13/09/2019
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
<h1>Hello</h1>
<c:if test="${not empty utilisateur}">
    <ul>
        <li>
            <c:out value="${ utilisateur.nom } "/> <c:out value="${ utilisateur.prenom } " />
            <c:out value="${ utilisateur.dateNaissance} "/><c:out value="${ utilisateur.tel} " /><c:out value="${ utilisateur.email} " />
        </li>
        <li>Id du service<c:out value="${ idService} "/></li>
    </ul>

</c:if>

<h1>Fonction Chef Service</h1>
<a href="/SIH_war_exploded/GestionMedecinService">Gestion des medecins du services</a></br>
<a href="">Liste des medecin du services </a></br>
</body>
</html>
</body>
</html>
