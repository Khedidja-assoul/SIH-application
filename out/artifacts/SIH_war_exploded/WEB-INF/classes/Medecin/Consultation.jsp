<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 18/08/2019
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Consultation </h1>
<ul>
<c:if test="${not empty consultation}">
    <li><c:out value="${consultation.id}"/>
        <c:out value="${patient.nom}"/><c:out value="${patient.prenom}"/>
        <c:out value="${consultation.date}"/><c:out value="${consultation.heure}"/><c:out value="${consultation.motif}"/>
    </li>
</c:if>
</ul>

<form method="get" action="Prescription">
    <button type="submit" name="prescription" value="${consultation.id}">Prescriptions</button>
</form>
<form method="get" action="ActeComplementaire">
    <button type="submit" name="actecomplementaire" value="${consultation.id}">Actes Complemntaire</button>
</form>
<form method="get" action="PlanSoin">
    <button type="submit" name="plansoin" value="${consultation.id}">Plans Soin</button>
</form>
<form method="get" action="CompteRendu">
    <button type="submit" name="compterendu" value="${consultation.id}">Compte rendu</button>
</form>


</body>
</html>
