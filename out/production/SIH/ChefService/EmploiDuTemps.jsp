<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 14/09/2019
  Time: 01:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
</head>
<body>
<form method="post" action="">
    <input type="checkbox" name="jours" value="7"/>Samedi<br>
    <input type="checkbox" name="jours" value="1"/>Dimanche<br>
    <input type="checkbox" name="jours" value="2"/>Lundi<br>
    <input type="checkbox" name="jours" value="3"/>Mardi<br>
    <input type="checkbox" name="jours" value="4"/>Mercredi<br>
    <input type="checkbox" name="jours" value="5"/>Jeudi<br>
    <button type="submit" class="registerbtn">Ajouter</button>
</form>

</body>
</html>
