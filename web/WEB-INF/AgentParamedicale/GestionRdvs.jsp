<%--
   Created by IntelliJ IDEA.
   User: BARACHE Abdennour
   Date: 14/09/2019
   Time: 12:03
   To change this template use File | Settings | File Templates.
   --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mdb.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Poppins|Ubuntu|Rubik" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script>
        var listeJoursDispo = [${fn:length( rdv.joursDisponibles)}];
        var i =0;
        <c:forEach var="jour" items="${ rdv.joursDisponibles}">
        listeJoursDispo[i] ="<c:out value="${jour.date}"/>";
        i++;

        </c:forEach>

        var listeJoursPleins = [${fn:length( rdv.joursPleins)}];
        var j =0;
        <c:forEach var="jour" items="${ rdv.joursPleins}">
        listeJoursPleins[j] = "<c:out value="${jour.date}"/>";
        console.log(<c:out value="${jour.date}"/>);
        j++;
        </c:forEach>

        function loadSelect() {
            var el = document.getElementById("date-picker1");
            var text = el.value ;
            if (text != "") {
                var heures = document.getElementById("heures");
                var select = heures.getElementsByTagName("option");
                document.getElementById("heures").setAttribute("style","display: block!important");
                select[0].selected = true;
                for (var j = 0 ; j<select.length;j++){
                    select[j].disabled = false;
                }
            }
            else{

                document.getElementById("heures").setAttribute("style","display: none!important");
            }
        }
        function getJoursBlocker(day) {

            <c:forEach var="jour" items="${ rdv.joursDisponibles}">
            if(day == "${jour.date}"){
                var heures = [${fn:length( jour.heures)}];
                var i = 0;
                <c:forEach var="heure" items="${ jour.heures}">
                heures[i] = "${heure.heure}";
                i++;
                </c:forEach>
                return heures;
            }
            </c:forEach>
        }
        function blockerHeurs(heures)
        {
            var select = document.getElementById("heures").getElementsByTagName("option");
            for(var i =0 ; i<heures.length;i++)
            {
                for (var j = 0 ; j<select.length;j++){
                    if (heures[i] == select[j].value)
                    {
                        select[j].disabled = true;
                    }
                }
            }
        }
    </script>
</head>
<body>
<div class="add_planing">
    <h1>Ajouter un rendez-vous</h1>
    <form method="get" action="GestionRdvs" class="container">
        <select id="idService" style="display: block!important" name="idService" onchange="submit()" required>
            <option value="" selected disabled hidden>-Selectioner un service-</option>
            <c:forEach var="service" items="${listeServices}">
                <option value="<c:out value="${service.id}"/>">
                    <c:out value="${service.nom}"/>
                </option>
            </c:forEach>
        </select>
    </form>
    <c:if test="${not empty listeMedecins}">
        <form method="get" action="GestionRdvs" class="container">
            <select id="medecins" style="display: block!important" name="idMedecin" onchange="submit()" required>
                <option value="" selected disabled hidden>-Selectioner un service-</option>
                <c:forEach var="medecin" items="${listeMedecins}">
                    <option value="<c:out value="${medecin.matricule}"/>"><c:out value="${medecin.nom}"/> <c:out value="${medecin.prenom}"/></option>
                </c:forEach>
            </select>
        </form>
    </c:if>
    <c:if test="${not empty rdv}">
    <form method="post" action="GestionRdvs" class="container">
        <div class="navette">
            <div class="md-form">
                <input placeholder="Selectionner un rendez vous" name="jour" type="text" id="date-picker1"
                       class="form-control datepicker"  onchange="loadSelect();blockerHeurs(getJoursBlocker(this.value))" required>
            </div>
            <select id="heures" style="display: none!important" name="heure" required>
                <option value="none" selected disabled hidden>-Selectioner une heure pour le rdv-</option>
                <option value="08:00-08:30">08:00-08:30</option>
                <option value="08:30-09:00">08:30-09:00</option>
                <option value="09:00-09:30">09:00-09:30</option>
                <option value="09:30-10:00">09:30-10:00</option>
                <option value="10:00-10:30">10:00-10:30</option>
                <option value="10:30-11:00">10:30-11:00</option>
                <option value="11:00-11:30">11:00-11:30</option>
                <option value="11:30-12:00">11:30-12:00</option>
                <option value="13:00-13:30">13:00-13:30</option>
                <option value="14:00-14:30">14:00-14:30</option>
                <option value="14:30-15:00">14:30-15:00</option>
                <option value="15:00-15:30">15:00-15:30</option>
                <option value="15:30-16:00">15:30-16:00</option>
                <option value="16:00-16:30">16:00-16:30</option>
                <option value="16:30-17:00">16:30-17:00</option>
            </select>
            <br>
            <input name="idPatient" type="number" placeholder="Identifiant patient" required><br><br>
            <input name="nomPatient" type="text" placeholder="Nom du patient" required><br><br>
            <input name="prenomPatient" type="text" placeholder="Prenom du patient" required><br><br>
            <c:if test="${not empty erreur}">
            <p style="color:red;">
                <c:out value="${ erreur }" />
            </p>
            </c:if>
            <button id="save" class="btn btn-light">Réserver</button>
    </form>
    </c:if>
</div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js "></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js "></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js "></script>
<!-- jQuery library -->
<script src="${pageContext.request.contextPath}/js/mdb.min.js "></script>
<script>
    function datesPleines(liste)
    {
        if (liste[0] != 0) {
            var years = document.getElementsByClassName("picker__select--year")[0].getElementsByTagName("option");
            for (var i = 0, len = years.length; i < len; i++) {
                var year = years[i];
                if (year.selected === true) {
                    break;
                }
            }
            var months = document.getElementsByClassName("picker__select--month")[0].getElementsByTagName("option");
            for (var i = 0, len = months.length; i < len; i++) {
                var month = months[i];
                if (month.selected === true) {
                    break;
                }
            }
            for (var i = 0, len = liste.length; i < len; i++) {
                var dateTab = liste[i].split("-");

                if (parseInt(dateTab[2]) == parseInt(year.value) && parseInt(dateTab[1]) == parseInt((month.value)) + 1) {

                    var jour = document.getElementById("date-picker1_table").getElementsByTagName("tbody")[0].getElementsByClassName("picker__day ")[parseInt(dateTab[0]) - 1];
                    jour.setAttribute("class", "picker__day picker__day--infocus picker__day--disabled");
                    jour.setAttribute("style", "background: #E71D36;");

                }
            }
        }

    }

    function datesDisponible(liste) {

        if (liste[0] != 0) {
            var years = document.getElementsByClassName("picker__select--year")[0].getElementsByTagName("option");
            for (var i = 0, len = years.length; i < len; i++) {
                var year = years[i];
                if (year.selected === true) {
                    break;
                }
            }
            var months = document.getElementsByClassName("picker__select--month")[0].getElementsByTagName("option");
            for (var i = 0, len = months.length; i < len; i++) {
                var month = months[i];
                if (month.selected === true) {
                    break;
                }
            }

            for (var i = 0, len = liste.length; i < len; i++) {
                var dateTab = liste[i].split("-");

                if (parseInt(dateTab[2]) == parseInt(year.value) && parseInt(dateTab[1]) == parseInt((month.value)) + 1) {

                    var jour = document.getElementById("date-picker1_table").getElementsByTagName("tbody")[0].getElementsByClassName("picker__day picker__day--infocus")[parseInt(dateTab[0]) - 1];
                    jour.setAttribute("class", "picker__day picker__day--infocus disponible");

                }
            }


        }
    }
</script>
<script>
    $('.datepicker').pickadate({
        onRender: function() {
            datesDisponible(listeJoursDispo);
            datesPleines(listeJoursPleins);
        },
        monthsFull: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre',
            'Novembre', 'Décembre'],
        monthsShort : ['Jan', 'Fev', 'Mar', 'Avr', 'Mai', 'Jun', 'Jul', 'Aut', 'Sep', 'Oct', 'Nov', 'Dec'],
        weekdaysFull: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
        weekdaysShort: ['Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam'],
        showMonthsShort: undefined,
        showWeekdaysFull: undefined,

        // Buttons
        today: '',
        clear: 'effacer',
        close: 'fermer',

        // Accessibility labels
        labelMonthNext: 'mois suivant',
        labelMonthPrev: 'mois precedent',
        labelMonthSelect: 'choisir un mois',
        labelYearSelect: 'choisir une annees',

        // Formats
        format: 'dd-mm-yyyy',
        formatSubmit:  undefined,
        hiddenPrefix: undefined,
        hiddenSuffix: '_submit',
        hiddenName: undefined,

        // Editable input
        editable: undefined,

        // Dropdown selectors
        selectYears: undefined,
        selectMonths: undefined,

        // First day of thde week
        firstDay: undefined,

        // Date limits
        min: new Date(),
        // Disable dates
        disable: [6,
            <c:forEach var="jour" items="${ rdv.joursTravail}">
            <c:out value="${jour}"/>,
            </c:forEach>

        ]

    })
</script>
</html>