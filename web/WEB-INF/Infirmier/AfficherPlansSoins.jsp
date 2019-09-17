<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 17/09/2019
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="AfficherPlansSoins">
    <input name="idPatient" type="number" placeholder="Identifaint patient">
    <input name="nom" type="text" placeholder="Nom patient ">
    <input name="prenom" type="text" placeholder="Prenom patient ">
    <button type="submit">Chercher</button>
</form>


<c:forEach varStatus="consultation" items="${listeConsultation}">
    <tr>
        <td><c:out value="${listeConsultation[consultation.index].id}"/></td>
        <td><c:out value="${listeMedecin[consultation.index].nom}"/> <c:out value="${listeMedecin[consultation.index].prenom}"/></td>
        <td><c:out value="${listeConsultation[consultation.index].date}"/></td>
        <td><c:out value="${listeConsultation[consultation.index].heure}"/></td>
        <td>
            <form method="get" action="AfficherPlanSoins">
                <input type="hidden" name="idConsultation" value="<c:out value="${listeConsultation[consultation.index].id}"/>">
                <input type="hidden" name="idPatient" value="<c:out value="${listeConsultation[consultation.index].idPatient}"/>">
                <input type="hidden" name="idMedecin" value="<c:out value="${listeMedecins[consultation.index].matricule}"/>">
                <input type="hidden" name="idMedecin" value="<c:out value="${listeMedecins[consultation.index].prenom}"/>">
                <input type="hidden" name="idMedecin" value="<c:out value="${listeMedecins[consultation.index].nom}"/>">
                <button type="submit">consulter</button>
            </form>
        </td>
    </tr>
</c:forEach>
</body>
</html>
