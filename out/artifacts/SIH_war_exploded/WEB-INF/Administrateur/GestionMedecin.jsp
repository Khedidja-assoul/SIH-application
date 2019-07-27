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
    <title>Test</title>
</head>
<body>


<form method="post" action="GestionMedecin">
    <p>
        <select name="typePersonnel" id="typePersonnel" onchange="selectionTypePersonnel()">
            <option value="Medecin">Medecin</option>
            <option value="Infirmier">Infirmier</option>
            <option value="Agent bloc operatoire">Agent bloc operatoire</option>
            <option value="Agent laboratoire" selected>Agent laboratoire</option>
            <option value="Agent paramedicale" selected>Agent paramedicale</option>
        </select>


    </p>
    <p>
        <label for="nom">Nom : </label>
        <input type="text" name="nom" id="nom" />
    </p>
    <p>
        <label for="prenom">Prenom : </label>
        <input type="text" name="prenom" id="prenom" />
    </p>
    <p>
        <label for="nbHeures">Nombre d'heures de travaille par semaine : </label>
        <input type="text" name="nbHeures" id="nbHeures" />
    </p>
    <p>
        <label for="dateNaissance">Date naissance : </label>
        <input type="text" name="dateNaissance" id="dateNaissance" />
    </p>
    <p>
        <label for="tel">Numero de telephone: </label>
        <input type="text" name="tel" id="tel" />
    </p>
    <p>
        <label for="email">Adresse e-mail </label>
        <input type="text" name="email" id="email" />
    </p>
        <div id="med" style="display:none">
        <p >
            <label for="grade">Grade : </label>
            <input type="text" name="grade" id="grade" />
        </p>
        <p>
            <label for="specialite">Specialite : </label>
            <input type="text" name="specialite" id="specialite" />
        </p>
        </div>
    <input type="submit" />
</form>
<form method="post" action="GestionMedecin">
    <select name="typePersonnelAffichier" id="typePersonnelAffichier" >
        <option value="Medecin">Medecin</option>
        <option value="Infirmier">Infirmier</option>
        <option value="Agent bloc operatoire">Agent bloc operatoire</option>
        <option value="Agent laboratoire" selected>Agent laboratoire</option>
        <option value="Agent paramedicale" selected>Agent paramedicale</option>
    </select>
    <input type="submit" />
</form>
<ul>
    <c:forEach var="personnel" items="${ personnels}">
        <li>
            <c:out value="${ personnel.nom } "/> <c:out value="${ personnel.prenom } " /><c:out value="${ personnel.nbHeures} " />
            <c:out value="${ personnel.dateNaissance} "/><c:out value="${ personnel.tel} " /><c:out value="${ personnel.email} " />

        </li>
    </c:forEach>
</ul>


</body>
</html>