<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Web2</title>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
    <script type="module" defer src="scripts/area.js"></script>
    <script type="module" defer src="scripts/table.js"></script>
    <script type="module" defer src="scripts/configuration.js"></script>
    <script type="module" defer src=scripts/requests.js>
    <script type="module" defer src="scripts/validators.js"></script>

    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>

<body>
<table class="container">

    <tr>
        <td class="header block" colspan="2">
            Камянецький Никита P3208 - 529009
        </td>
    </tr>

    <tr>
        <td class="left-block block">
            <jsp:include page="html/area.html" flush="true" />
        </td>

        <td class="right-block block">
            <jsp:include page="html/form.html" flush="true" />
        </td>
    </tr>

    <tr>
        <td class="results-block block" colspan="2">
            <table id="results-table">
                <thead>
                <tr>
                    <td>Время</td>
                    <td>Затраты, ns</td>
                    <td>R</td>
                    <td>X</td>
                    <td>Y</td>
                    <td>Результат</td>
                </tr>
                </thead>
                <tbody id="results-table-body">
                <jsp:include page="check-result.jsp"/>
                </tbody>
            </table>
        </td>
    </tr>

</table>
</body>

</html>