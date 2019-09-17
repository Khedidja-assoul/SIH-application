<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 17/09/2019
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id demande acte</th>
        <th>Medecin</th>
        <th>Patient</th>
        <th>Date</th>
        <th>Heure</th>
    </tr>
    <c:forEach varStatus="acte" items="${listeResultatsActes}">
        <tr>
            <td><c:out value="${listeResultatsActes[acte.index].id}"/></td>
            <td><c:out value="${listeMedecin[acte.index].nom}"/> <c:out value="${listeMedecin[acte.index].prenom}"/></td>
            <td><c:out value="${listePatient[acte.index].nom}"/> <c:out value="${listePatient[acte.index].prenom}"/></td>
            <td><c:out value="${listeConsultation[acte.index].date}"/></td>
            <td><c:out value="${listeConsultation[acte.index].heure}"/></td>
            <td>
                <form method="get" action="ResultatsActe">
                    <input type="hidden" name="idActe" value="<c:out value="${listeResultatsActes[acte.index].id}"/>">
                    <input type="hidden" name="idConsultation" value="<c:out value="${listeConsultation[acte.index].id}"/>">
                    <input type="hidden" name="idPatient" value="<c:out value="${listePatient[acte.index].matricule}"/>">
                    <input type="hidden" name="idMedecin" value="<c:out value="${listeMedecin[acte.index].matricule}"/>">
                    <input type="hidden" name="idAnalyse" value="<c:out value="${listeResultatsActes[acte.index].idAnalyse}"/>">
                    <button type="submit">consulter</button>
                </form>
            </td>
        </tr>
    </c:forEach>



</table>
</body>
</html>
