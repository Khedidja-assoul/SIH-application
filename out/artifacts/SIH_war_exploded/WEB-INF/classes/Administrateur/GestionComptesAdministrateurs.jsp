<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 03/08/2019
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout compte administrateur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
</head>
<body>
<form method="post" action="GestionComptesAdministrateurs">
    <div class="container">
        <h1>Ajouter un compte administrateur</h1>
    <input type="text" placeholder="Nom" name="nom" id="nom" />
    <input type="text" placeholder="Prenom" name="prenom" id="prenom" />
    <input type="text" placeholder="Nom d'utilisateur" name="nomUtilisateur" id="nomUtilisateur" />
    <input type="password" placeholder="Mot de passe" name="motDePasse" id="motDePasse" />
    <button type="submit" class="registerbtn">Enregistrer</button>
    </div>
</form>


</body>
</html>
