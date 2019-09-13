<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 20/08/2019
  Time: 11:21
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
    <c:forEach varStatus="acte" items="${listeDemandeActe}">
        <tr>

            <td><c:out value="${listeDemandeActe[acte.index].id}"/></td>
            <td><c:out value="${listeMedecin[acte.index].nom}"/> <c:out value="${listeMedecin[acte.index].prenom}"/></td>
            <td><c:out value="${listePatient[acte.index].nom}"/> <c:out value="${listePatient[acte.index].prenom}"/></td>
            <td><c:out value="${listeConsultation[acte.index].date}"/></td>
            <td><c:out value="${listeConsultation[acte.index].heure}"/></td>
            <td>
                <form method="get" action="DemandesActes">
                    <input type="hidden" name="idActe" value="<c:out value="${listeDemandeActe[acte.index].id}"/>">
                    <input type="hidden" name="idConsultation" value="<c:out value="${listeConsultation[acte.index].id}"/>">
                    <input type="hidden" name="nomPatient" value="<c:out value="${listePatient[acte.index].matricule}"/>">
                    <input type="hidden" name="nomMedecin" value="<c:out value="${listeMedecin[acte.index].matricule}"/>">
                    <button type="submit">consulter</button>
                </form>
            </td>

        </tr>
    </c:forEach>



</table>
</body>
</html>
