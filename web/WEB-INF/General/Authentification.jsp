<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 31/07/2019
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentification</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
    <script>
        function selectionTypePersonnel() {
            var el = document.getElementById("typeUtilisateur");
            var text = el.options[el.selectedIndex].innerHTML;
            if (text == "Medecin") {
                document.getElementById("med").style.display = "block";
            }
            else{
                document.getElementById("med").style.display = "none";
            }
        }
    </script>
</head>
<body>
<form method="post" action="Authentification">
    <div class="container">
        <h1>Authentification </h1>
        <input type="text" placeholder="Nom d'utilisateur" name="nomUtilisateur" id="nomUtilisateur"required >
        <input type="password" placeholder="Mot de passe" name="motPasse" id="motPasse" required>
        <div>
        <select name="typeUtilisateur" id="typeUtilisateur" onchange="selectionTypePersonnel()" required>
            <option value="none" selected disabled hidden>
                -Selectioner le type de l'utilisateur-
            </option>
            <option value="medecin">Medecin</option>
            <option value="infirmier">Infirmier</option>
            <option value="agentblocoperatoire">Agent bloc operatoire</option>
            <option value="agentlaboratoire" >Agent laboratoire</option>
            <option value="agentparamedicale" >Agent paramedicale</option>
            <option value="patient">Patient</option>
        </select>
            <div id="med" style="display:none">
                <input type="checkbox" name="chefservice" value="true"/>Chef Service
            </div>
        </div>
        <button type="submit" class="registerbtn">S'authentifier</button>
    </div>
</form>
<div>
    <c:if test="${not empty erreur}">
        <p style="color:red;"><c:out value="${ erreur }" /></p>
    </c:if>
<c:if test="${not empty utilisateur}">
    <ul>
        <li>
            <c:out value="${ utilisateur.nom } "/> <c:out value="${ utilisateur.prenom } " />
            <c:out value="${ utilisateur.dateNaissance} "/><c:out value="${ utilisateur.tel} " /><c:out value="${ utilisateur.email} " />
        </li>
    </ul>
</c:if>
</div>
</body>
</html>
