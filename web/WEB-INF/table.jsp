<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>

</head>

<body>

    <table>
        <thead>
            <tr>
                <th>Column 1</th>
                <th>Column 2</th>
                <th>Column 3</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>A1</td>
                <td>A2</td>
                <td>A3</td>
            </tr>
            <tr>
                <td>B1</td>
                <td>B2</td>
                <td>B3</td>
            </tr>
            <tr>
                <td>C1</td>
                <td>C2</td>
                <td>C3</td>
            </tr>
        </tbody>
    </table>

    <form method="GET" onsubmit="tableToJson()" >
        <input id="table" type="hidden" name="table" value="">
        <button type="submit">envoie </button>
 
    </form>
</body>
<script>
    function tableToJson() {
        var myRows = [];
        var headersText = [];
        var $headers = $("th");

        // Loop through grabbing everything
        var $rows = $("tbody tr").each(function (index) {
            $cells = $(this).find("td");
            myRows[index] = {};

            $cells.each(function (cellIndex) {
                // Set the header text
                if (headersText[cellIndex] === undefined) {
                    headersText[cellIndex] = $($headers[cellIndex]).text();
                }
                // Update the row object with the header/cell combo
                myRows[index][headersText[cellIndex]] = $(this).text();
            });
        });

        // Let's put this in the object like you want and convert to JSON (Note: jQuery will also do this for you on the Ajax request)
        var myObj = {
            "myrows": myRows
        };
        var jsonString =JSON.stringify(myObj);
        document.getElementById("table").value = jsonString;
    }
</script>

</html>