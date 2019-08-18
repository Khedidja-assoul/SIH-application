<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 14/08/2019
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aouter un acte complemantaire</title>
    <script>
        function displayElement(selector) {
            var el = document.getElementById(selector);
            el.style.display = "block";
        }
        function hideElement(selector) {
            var el = document.getElementById(selector);
            el.style.display = "none";
        }
    </script>
</head>
<body>

<form >
    <h2>Ajouter un acte complementaire</h2>
    <label>Selectionner le type de d'actex</label>
    <input type="radio" name="typeActe" value="actecomplementairelabo" onchange="displayElement('typeAnalyse')">
    Acte complémentaire destiné au laboratoire
    <input type="radio" name="typeActe" value="actecomplementairebloc" onchange="hideElement('typeAnalyse')"> Acte
    complémentaire destiné au bloc operatoire<br>
    <div id="typeAnalyse" style="display: none">
        <input type="checkbox" name="analyse" value="Numération Formule Sanguine">Numération Formule Sanguine<br>
        <input type="checkbox" name="analyse" value="vs">Vitesse de sédimentation<br>
        <button type="submit" >Valider acte</button>
    </div>
    <input type="button" href="/SIH_war_exploded/ComposantConsultation" value="Annuler demande acte">
</form>

</body>
</html>
