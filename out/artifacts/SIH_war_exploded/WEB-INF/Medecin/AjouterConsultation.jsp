<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 13/08/2019
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une consultation</title>
    <script>
        function getCurrentDate() {
            var today = new Date();
            var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            return date;
        }
        function getCurrentTime() {
            var today = new Date();
            var time = today.getHours() + ":" + today.getMinutes();
            return time;
        }
    </script>
</head>

<body>

<form method="get" action="AjouterConsultation">
    <h1>Ajouter une consultation</h1><br>
    <input type="text" placeholder="Nom patient" name="nomPatient" id="nomPatient" />
    <input type="text" placeholder="Prenom patient" name="prenomPatient" id="prenomPateint" />
    <input type="text" placeholder="Motif de consultation" name="motif" id="motif" />
    <input type="hidden" id="date" name="date" value="">
    <input type="hidden" id="heure" name="heure" value="">
    <script>
        document.getElementById('date').value = getCurrentDate();
        document.getElementById('heure').value = getCurrentTime();
    </script>
    <button type="submit">Suivant></button>
</form>


</body>
</html>
