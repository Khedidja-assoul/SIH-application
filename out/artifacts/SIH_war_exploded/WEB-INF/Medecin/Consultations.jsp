<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 18/08/2019
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste consultation</title>
</head>
<body>
<h1>Liste des consutation</h1>

<table >

    <tr>
        <th>Id consultation</th>
        <th>Nom Patient</th>
        <th>Prenom Patient</th>
        <th>Heure</th>
        <th>Date</th>
        <th>Motif</th>
    </tr>


        <c:forEach varStatus="consultation" items="${consultations}">
            <tr>
                <td><c:out value="${consultations[consultation.index].id}"/></td>
                <td><c:out value="${patiens[consultation.index].nom}"/></td>
                <td><c:out value="${patiens[consultation.index].prenom}"/></td>
                <td><c:out value="${consultations[consultation.index].date}"/></td>
                <td><c:out value="${consultations[consultation.index].heure}"/></td>
                <td><c:out value="${consultations[consultation.index].motif}"/></td>
                <td>
                    <form method="get" action="Consultation">
                    <button type="submit" name="consulter" value="${consultations[consultation.index].id}">consulter</button>
                    </form>
                </td>
            </tr>
        </c:forEach>



</table>

</body>
</html>
