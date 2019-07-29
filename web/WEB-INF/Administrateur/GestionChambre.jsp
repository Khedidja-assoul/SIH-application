<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 28/07/2019
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion des chambres</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
</head>
<body>
<form method="post" action="GestionChambre">
    <div class="container">
        <h1>Ajouter une chambre  </h1>
        <input  type="text" placeholder="Numero chambre" name="num" id="num" required >
        <input type="text" placeholder="Etage" name="etage" id="etage" required>
        <input type="text"  placeholder="Type Chambre"name="nbLits" id="nbLits" required>
        <button type="submit" class="registerbtn">Ajouter</button>
    </div>
</form>

</body>
</html>
