<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 18/08/2019
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter compte Rendu</title>
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
    <h2>Ajouter un compte rendu</h2>
    <br>
    <textarea name="detaille" placeholder="Compte rendu : " ></textarea>
    <br>
    <button type="submit" >Valider compte rendu</button>
</form>
<input type="button" href="/SIH_war_exploded/ComposantConsultation" value="Annuler compte rendu">
</body>
</html>
