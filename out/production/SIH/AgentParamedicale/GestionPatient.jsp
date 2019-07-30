<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 30/07/2019
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion patients</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
</head>
<body>

<form method="post" action="GestionPatient">
    <div class="container">
        <h1>Ajouter un patient  </h1>
        <input  type="text" placeholder="Nom" name="nom" id="nom"required >
        <input type="text" placeholder=" Prenom" name="prenom" id="prenom" required>
        <input type="date"  placeholder="Date de naissance"name="dateNaissance" id="dateNaissance" required>
        <input  type="text" placeholder="Adresse" name="adresse" id="adresse" required >
        <input  type="text" placeholder="Numero de telephone" name="tel" id="tel" required >
        <input  type="text" placeholder="Adresse e-mail" name="email" id="email" required >
        <button type="submit" class="registerbtn">Ajouter</button>
    </div>
</form>

</body>
</html>

