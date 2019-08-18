<%--
  Created by IntelliJ IDEA.
  User: BARACHE Abdennour
  Date: 08/08/2019
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script>
        function buildHtmlTable(selector) {
            var columns = addAllColumnHeaders(myList, selector);

            for (var i = 0; i < myList.length; i++) {
                var row$ = $('<tr/>');
                for (var colIndex = 0; colIndex < columns.length; colIndex++) {
                    var cellValue = myList[i][columns[colIndex]];
                    if (cellValue == null) cellValue = "";
                    row$.append($('<td/>').html(cellValue));
                }
                $(selector).append(row$);
            }
        }

        // Adds a header row to the table and returns the set of columns.
        // Need to do union of keys from all records as some records may not contain
        // all records.
        function addAllColumnHeaders(myList, selector) {
            var columnSet = [];
            var headerTr$ = $('<tr/>');

            for (var i = 0; i < myList.length; i++) {
                var rowHash = myList[i];
                for (var key in rowHash) {
                    if ($.inArray(key, columnSet) == -1) {
                        columnSet.push(key);
                        headerTr$.append($('<th/>').html(key));
                    }
                }
            }
            $(selector).append(headerTr$);

            return columnSet;
        }
    </script>
</head>
<body>
<c:forEach var="analyse" items="${analyses}">

    <h1><c:out value="${ analyse.abreviation} " /></h1>
    <h2><c:out value="${ analyse.nomOfficile} "/></h2>
    <input type="hidden" id="json" value='${ analyse.detailles}'>
</c:forEach>
<table id="excelDataTable" border="1"></table>
<script>
    myList = JSON.parse(document.getElementById("json").value);
    buildHtmlTable('#excelDataTable');
</script>

</body>

</html>
