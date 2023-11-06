<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['x']) && isset($_POST['y']) && isset($_POST['r'])) {
    $x = $_POST['x'];
    $y = $_POST['y'];
    $r = $_POST['r'];

    if (validDate($x, $y, $r)) {
        date_default_timezone_set('Europe/Moscow');
        $hit = check($x, $y, $r) ? "Yes" : "No";
        $executionTime = microtime(true) - $_SERVER["REQUEST_TIME_FLOAT"];
        $currentTime = date("H:i:s");

        $_SESSION['history'][] = array(
            'x' => $x,
            'y' => $y,
            'r' => $r,
            'currentTime' => $currentTime,
            'executionTime' => $executionTime,
            'hit' => $hit
        );
    } else {
        http_response_code(400);
        echo "Invalid data";
        exit();
    }
    echo "<tbody>";
    echo "<tr class=\"result_row\" value=\"" . strtolower($hit) . "\">";
    echo "<th>" . $x . "</th>";
    echo "<th>" . $y . "</th>";
    echo "<th>" . $r . "</th>";
    echo "<th>" . $currentTime . "</th>";
    echo "<th>" . $executionTime . "</th>";
    echo "<th>" . $hit . "</th>";
    echo "</tr>";
    echo "</tbody>";
}

function validDate($x, $y, $r) {
    if (is_numeric($x) && is_numeric($y) && is_numeric($r)) {
        if ($x >= -2 && $x <= 2 && $y >= -3 && $y <= 3 && $r >= 2 && $r <= 5) {
            return true;
        }
    }
    return false;
}

function check($x, $y, $r) {
    $result = ($x >= 0 && $y >= 0 && $x <= $r && $y <= $r / 2 && $x * $x + $y * $y <= $r * $r) ||
              ($x <= 0 && $y >= -$r && $y <= 0 && $x >= -$r / 2) ||
              ($x >= 0 && $y <= 0 && $y >= -$x - $r / 2);
    return $result;
}