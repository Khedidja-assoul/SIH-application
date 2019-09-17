<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 13/09/2019
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
</head>
<body>
<form method="post" action="GestionMedecinService">
    <div class="container">
        <h1>Ajouter un medecin au service</h1>
        <input  type="number" placeholder="Identifiant medecin" name="idMedecin" required >
        <h3>Emploi du temps</h3>
        <input type="checkbox" name="jours" value="7"/>Samedi<br>
        <input type="checkbox" name="jours" value="1"/>Dimanche<br>
        <input type="checkbox" name="jours" value="2"/>Lundi<br>
        <input type="checkbox" name="jours" value="3"/>Mardi<br>
        <input type="checkbox" name="jours" value="4"/>Mercredi<br>
        <input type="checkbox" name="jours" value="5"/>Jeudi<br>
        <button type="submit" class="registerbtn">Ajouter</button>
    </div>
</form>
<div>
<ul>
    <c:forEach var="medecin" items="${ listeMedecinService}">
        <li>
            <c:out value="${ medecin.nom } "/> <c:out value="${ medecin.prenom } " /><c:out value="${ medecin.nbHeures} " />
            <c:out value="${ medecin.dateNaissance} "/><c:out value="${ medecin.tel} " /><c:out value="${ medecin.email} " />
            <!--
            <form method="get" action="">
                <input type="hidden" name="typePersonnelModifier" value="">
                <button type="submit" name="personnelModif" value="$">Modifier</button>
            </form>
        </li>
        -->
    </c:forEach>
</ul>
</div>
</body>
</html>
