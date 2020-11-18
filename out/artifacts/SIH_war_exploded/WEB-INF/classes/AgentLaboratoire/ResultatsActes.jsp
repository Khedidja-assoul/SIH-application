



<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 20/08/2019
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Template.css">

    <title>Liste_DemAct</title>
</head>
<body>
<header>
    <div id="div1_h" >
        <span>La clinique WAHRAN , ORAN (POS 21A, Bir El Djir 31000).</span>
    </div>
    <div id="div2_h">
        <span>Tel: +(213)773-675-952</span>
    </div>
</header>
<section id="sec">
    <div id="div1_s">
        <a href=""  id="comp-imn5ilghlink" class="style-ijfori4flink">
            <div  class="style-ijfori4f_comp-imn5ilgh style-ijfori4f_non-scaling-stroke style-ijfori4fsvg" id="div11_s">
                <svg preserveAspectRatio="xMidYMid meet" data-bbox="0 82.683 500.777 340.629" xmlns="http://www.w3.org/2000/svg" viewBox="0 82.683 500.777 340.629" role="img">
                    <g>
                        <path d="M489.842 270.768H403.99L373.785 167.95a10.941 10.941 0 0 0-10.622-6.529 10.932 10.932 0 0 0-9.833 7.666L290 362 223.096 91.286a10.934 10.934 0 0 0-10.443-8.601c-5.048-.095-9.519 3.25-11.811 8.135l-73.81 180.948H10.934C4.897 271.768 0 276.664 0 282.703v2.689c0 6.038 4.897 10.935 10.934 10.935h127.438c5.144 0 9.592-3.586 10.685-8.611l61.645-156.771 68.797 282.199c.808 5.931 4.854 9.688 9.832 10.126.323.028.645.042.964.042 4.604 0 8.763-2.902 10.312-8.313L364.3 208.404l20.81 79.815a10.935 10.935 0 0 0 10.242 7.107h93.714c6.038 0 10.935-4.896 10.935-10.935l.776-2.689c-.001-6.038-4.897-10.934-10.935-10.934z"></path>
                    </g>
                </svg>
            </div>
        </a>
    </div>
    <div id="div2_s" class="txtNew">
        <h1 class="font_0" style="line-height:1em;">
            <a href="https://abdenourbarache.wixsite.com/mysite?fbclid=IwAR23y0_gubnyvFek19_W8iIdFp2Q6FroqZUb0fB4ThjXLHoOpccxXtqDKbw" class="mv">Clinique WAHRAN</a></h1>
    </div>
    <div data-packed="true" class="txtNew" id="div3_s">
            <span>
                <a href="https://abdenourbarache.wixsite.com/mysite?fbclid=IwAR23y0_gubnyvFek19_W8iIdFp2Q6FroqZUb0fB4ThjXLHoOpccxXtqDKbw" target="_self" style="text-decoration:none;color: #A0A09F;">Examens &amp; Diagnostique</a>
            </span>
    </div>
    </div>
    <div>
        <nav>
            <ul id="ul_1">
                <li id="ul_1_li_1">
                    <div>
                        <a href="" role="button" >
                            <p id="Authentification1" class="ddm1repeaterButtonlabel">Authentification</p>
                        </a>
                    </div>
                </li>
                <li id="ul_1_li_2">
                    <div>
                        <a href="" role="button">
                            <p id="Authentification2" class="ddm1repeaterButtonlabel">Template</p>
                        </a>
                    </div>
                </li>
                <li id="ul_1_li_3">
                    <div>
                        <a href="" role="button">
                            <p id="Authentification3" class="ddm1repeaterButtonlabel">More</p>
                        </a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>
</section>
<div>
    <h1 style="position: relative;left: 130px;width: 500px;">Liste Des Demandes Actes</h1>
    <br>
    <table>
        <tr>
            <th>Id demande acte</th>
            <th>Medecin</th>
            <th>Patient</th>
            <th>Date</th>
            <th>Heure</th>
        </tr>
        <c:forEach varStatus="acte" items="${listeResultatsActes}">
            <tr>
                <td><c:out value="${listeResultatsActes[acte.index].id}"/></td>
                <td><c:out value="${listeMedecin[acte.index].nom}"/> <c:out value="${listeMedecin[acte.index].prenom}"/></td>
                <td><c:out value="${listePatient[acte.index].nom}"/> <c:out value="${listePatient[acte.index].prenom}"/></td>
                <td><c:out value="${listeConsultation[acte.index].date}"/></td>
                <td><c:out value="${listeConsultation[acte.index].heure}"/></td>
                <td>
                    <form method="get" action="ResultatsActe">
                        <input type="hidden" name="idActe" value="<c:out value="${listeResultatsActes[acte.index].id}"/>">
                        <input type="hidden" name="idConsultation" value="<c:out value="${listeConsultation[acte.index].id}"/>">
                        <input type="hidden" name="idPatient" value="<c:out value="${listePatient[acte.index].matricule}"/>">
                        <input type="hidden" name="idMedecin" value="<c:out value="${listeMedecin[acte.index].matricule}"/>">
                        <input type="hidden" name="idAnalyse" value="<c:out value="${listeResultatsActes[acte.index].idAnalyse}"/>">
                        <button type="submit">consulter</button>
                    </form>
                </td>
            </tr>
        </c:forEach>



    </table>
</div>
<footer>
    <span id="span1_f" class="txtNew">© 2019 par les etudaints de l'esi-sba</span>
    <span id="span2_f">La clinique WAHRAN, ORAN (POS 21A, Bir El Djir 31000).</span>
    <span id="span3_f" style="font-size:17px;">Tel: +(213)773-675-952</span>
</footer>
</body>
</html>