<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 18/08/2019
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter prescription</title>
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
    <h2>Ajouter un prescription</h2>
    <label>Selectionner le type de prescription</label>
    <input type="radio" name="typePrescription" value="medicament">Médicaments
    <input type="radio" name="typePrescription" value="perfusion" >Perfusion
    <input type="radio" name="typePrescription" value="produitssanguins">Produits sanguins
    <br>
    <textarea name="detaille" placeholder="Prescription : " ></textarea>
    <br>
    <button type="submit" >Valider prescription</button>
    <input type="button" href="/SIH_war_exploded/ComposantConsultation" value="Annuler prescription">
</form>
</body>
</html>
