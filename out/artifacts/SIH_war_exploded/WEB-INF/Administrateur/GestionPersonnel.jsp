<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 25/07/2019
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <script>
        function selectionTypePersonnel() {
            var el = document.getElementById("typePersonnel");
            var text = el.options[el.selectedIndex].innerHTML;
            if (text == "Medecin") {
                document.getElementById("med").style.display = "block";
            }
            else{
                document.getElementById("med").style.display = "none";
            }
        }
    </script>
    <meta charset="utf-8" />
    <title>Gestion du personnel</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/administrateur/gestion%20chambre.css" type="text/css">
</head>
<body>
<form method="post" action="GestionPersonnel">
    <div class="container">
        <h1>Ajouter personnel</h1>
        <select name="typePersonnel" id="typePersonnel" onchange="selectionTypePersonnel()">
            <option value="medecin">Medecin</option>
            <option value="infirmier">Infirmier</option>
            <option value="agentblocoperatoire">Agent bloc operatoire</option>
            <option value="agentlaboratoire" selected>Agent laboratoire</option>
            <option value="agentparamedicale" selected>Agent paramedicale</option>
        </select>
    </div>
        <input type="text" placeholder="Nom" name="nom" id="nom" />
        <input type="text" placeholder="Prenom" name="prenom" id="prenom" />
        <input type="text" placeholder="Nombre d'heures de travaille par semaine" name="nbHeures" id="nbHeures" />
        <input type="date" placeholder="Date de naissance" name="dateNaissance" id="dateNaissance" />
        <input type="text" placeholder="Numero de telephone" name="tel" id="tel" />
        <input type="text" placeholder="Adresse e-mail" name="email" id="email" />
        <div id="med" style="display:none">
            <input type="text" placeholder="Grade du medecin" name="grade" id="grade" />
            <input type="text" placeholder="Specialite" name="specialite" id="specialite" />
        </div>
    <button type="submit" class="registerbtn">Ajouter</button>
</form>
<div>
<form method="post" action="GestionPersonnel">
    <div class="container">
        <h1>Afficher personnel selon type</h1>
        <select name="typePersonnelAffichier" id="typePersonnelAffichier" >
            <option value="medecin">Medecin</option>
            <option value="infirmier">Infirmier</option>
            <option value="agentblocoperatoire">Agent bloc operatoire</option>
            <option value="agentlaboratoire" selected>Agent laboratoire</option>
            <option value="agentparamedicale" selected>Agent paramedicale</option>
        </select>
        <button type="submit" class="registerbtn">Afficher</button>
    </div>
</form>
</div>
<ul>
    <c:forEach var="personnel" items="${ personnels}">
        <li>
            <c:out value="${ personnel.nom } "/> <c:out value="${ personnel.prenom } " /><c:out value="${ personnel.nbHeures} " />
            <c:out value="${ personnel.dateNaissance} "/><c:out value="${ personnel.tel} " /><c:out value="${ personnel.email} " />
            <form method="get" action="GestionPersonnel">
                <input type="hidden" name="typePersonnelSupprimer" value="${typePersonnelSupprimer}">
                <button type="submit" name="personnelSupp" value="${personnel.matricule}">Supprimer</button>
            </form>
            <form method="get" action="GestionPersonnel">
                <input type="hidden" name="typePersonnelModifier" value="${typePersonnelModifier}">
                <button type="submit" name="personnelModif" value="${personnel.matricule}">Modifier</button>
            </form>
        </li>
    </c:forEach>
</ul>

</body>
</html>