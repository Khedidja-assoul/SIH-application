<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 13/09/2019
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
</head>
<body>
<form method="post" action="AjouterService">
    <div class="container">
        <h1>Ajouter un service </h1>
        <input  type="text" placeholder="Nom" name="nom" required >
        <input type="number" placeholder="Etage" name="etage" required>
        <input type="text" placeholder="Aile" name="aile" required>
        <input type="text"  placeholder="Identifiant chef service"name="idchef" required>
        <button type="submit" class="registerbtn">Ajouter</button>
    </div>
</form>
</body>
</html>
