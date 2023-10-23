<?php
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
$history = $_SESSION['history'];

echo '<tr class="result_header">';
echo "<th>X</th>";
echo "<th>Y</th>";
echo "<th>R</th>";
echo "<th>Current time</th>";
echo "<th>Execution time</th>";
echo "<th>Hit</th>";
echo "</tr>";
foreach ($history as $row) {

  echo "<tr class='row' value='" . strtolower($row['hit']) . "'>";
  echo "<td>" . $row['x'] . "</td>";
  echo "<td>" . $row['y'] . "</td>";
  echo "<td>" . $row['r'] . "</td>";
  echo "<td>" . $row['currentTime'] . "</td>";
  echo "<td>" . $row['executionTime'] . "</td>";
  echo "<td>" . $row['hit'] . "</td>";
  echo "</tr>";
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
?>