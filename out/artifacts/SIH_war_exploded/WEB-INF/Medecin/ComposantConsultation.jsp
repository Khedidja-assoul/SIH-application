<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 14/08/2019
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter composantes de la consultation</title>
</head>

<body>
<c:if test="${not empty consultation}">
    <ul>
        <li>
            <c:out value="${ consultation.id} "/> <c:out value="${ consultation.idMedecin} " />
            <c:out value="${ consultation.idPatient} "/><c:out value="${ consultation.motif} " /><c:out value="${ consultation.date} " />
        </li>
    </ul>
</c:if>
<a href="/SIH_war_exploded/AjouterPrescription">Ajouter une prescription</a><br>
<a href="/SIH_war_exploded/AjouterDemandeActe">Ajouter une demande d'acte complémentaire</a><br>
<a href="/SIH_war_exploded/AjouterPlanSoin">Ajouter un plan de soin</a>
<a href="/SIH_war_exploded/AjouterCompteRendu">Ajouter un compte rendu</a>


</body>
</html>
