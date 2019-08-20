<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 18/08/2019
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter plan soin</title>
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
    <h2>Ajouter un plan de soin</h2>
    <label>Sélectionner les soins à établir</label>
    <input type="checkbox" name="soins" value="Bain de pied">Bain de pied<br>
    <input type="checkbox" name="soins" value="Attention pd de hanche">Attention pd de hanche<br>
    <input type="checkbox" name="soins" value="Aide a l'habilage selon protocole">Aide a l'habilage selon protocole<br>
    <button type="submit" >Valider plan de soins</button>
</form>
    <input type="button" href="/SIH_war_exploded/ComposantConsultation" value="Annuler demande acte">

</body>
</html>