<?php
session_start();
if (!isset($_SESSION['history'])) {
    $_SESSION['history'] = [];
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Проверка точки в области</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    <header>
        <h1>Проверка точки в области</h1>
        <p>ФИО студента: Камянецький Никита</p>
        <p>Номер группы: P3208</p>
        <p>Номер варианта: 69320</p>
    </header>
    <form action="check.php" method="post" id="myForm">
        <table>
            <tr>
                <th>Параметр R:</th>
                <td><input type="text" name="r" placeholder="(2...5)"></td>
            </tr>
            <tr>
                <th>Координата X:</th>
                <td><input type="radio" name="x" value="-2">-2</td>
                <td><input type="radio" name="x" value="-1.5">-1.5</td>
                <td><input type="radio" name="x" value="-1">-1</td>
                <td><input type="radio" name="x" value="-0.5">-0.5</td>
                <td><input type="radio" name="x" value="0">0</td>
                <td><input type="radio" name="x" value="0.5">0.5</td>
                <td><input type="radio" name="x" value="1">1</td>
                <td><input type="radio" name="x" value="1.5">1.5</td>
                <td><input type="radio" name="x" value="2">2</td>
            </tr>
            <tr>
                <th>Координата Y:</th>
                <td><input type="text" name="y" placeholder="(-3...3)"></td>
            </tr>
            <tr>
                <td><input type="submit" id="send" value="Отправить ответ"></td>
            </tr>
        </table>
    </form>
    <div id="errorMessage" style="color: red;"></div>
    <div id="successMessage" style="color: green;"></div>
    <table id="res">
        <tr class="result_header">
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Current time</th>
            <th>Execution time</th>
            <th>Hit</th>
        </tr>
    </table>
    <table id="result-table">
        <?php
        $history = $_SESSION['history'];
        foreach ($history as $row) {
            echo "<tr class=\"result_row\" value=\"" . strtolower($hit) . "\">";
            echo "<th>" . $row['x'] . "</th>";
            echo "<th>" . $row['y'] . "</th>";
            echo "<th>" . $row['r'] . "</th>";
            echo "<th>" . $row['currentTime'] . "</th>";
            echo "<th>" . $row['executionTime'] . "</th>";
            echo "<th>" . $row['hit'] . "</th>";
            echo "</tr>";
        }
        ?>
    </table>

    <script src="script.js"></script>
</body>

</html>
