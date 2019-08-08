<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 03/08/2019
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentification Administrateur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
</head>
<body>
<form method="post" action="AuthentificationAdmin">
    <div class="container">
        <h1>Authentification </h1>
        <input type="text" placeholder="Nom d'utilisateur" name="nomUtilisateur" id="nomUtilisateur"required >
        <input type="password" placeholder="Mot de passe" name="motDePasse" id="motDePasse" required>
        <button type="submit" class="registerbtn">S'authentifier</button>
    </div>
</form>
<div>
    <c:if test="${not empty erreur}">
        <p style="color:red;"><c:out value="${ erreur }" /></p>
    </c:if>
</div>

</body>
</html>
