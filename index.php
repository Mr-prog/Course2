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
</head>
<body>
	<header>
		<h1>Проверка точки в области</h1>
        <p>ФИО студента: Камянецький Никита</p>
        <p>Номер группы: P3208</p>
        <p>Номер варианта: 69320</p>
	</header>

	<form id="pointForm" action="check.php" method="POST">
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
                <td><input type="submit" name="send" value="Отправить ответ"></td>
            </tr>
        </table>
	</form>


	<table id = "res">
		<tr class = "result_header">
			<th>X</th>
			<th>Y</th>
			<th>R</th>
			<th>Current time</th>
			<th>Execution time</th>
			<th>Hit</th>
		</tr>
		<?php                                                                      
		$history = $_SESSION['history'];
        foreach ($history as $row) {
          echo "<tr class='row'   value='" . strtolower($row['hit']) . "'>";
          echo "<td>" . $row['x'] . "</td>";
          echo "<td>" . $row['y'] . "</td>";
          echo "<td>" . $row['r'] . "</td>";
          echo "<td>" . $row['currentTime'] . "</td>";
          echo "<td>" . $row['executionTime'] . "</td>";
          echo "<td>" . $row['hit'] . "</td>";
          echo "</tr>";
      }
		?> 
	</table>


	<script type="text/javascript">
		
	document.getElementByName("send").addEventListener("click", async function ()) {
	const x = document.querySelector('input[name="x"]:checked');
    const y = document.getElementByName('y').value;
    const r = document.getElementByName('r').value;

    // Проверяем, введены ли все данные
    if (!x || !y || !r) {
        errorMessage.textContent = 'Пожалуйста, введите все данные.';
        successMessage.textContent = '';
        return;
    }

    // Проверяем, являются ли данные числами
    if (isNaN(y) || isNaN(r)) {
        errorMessage.textContent = 'Координата Y и радиус R должны быть числами.';
        successMessage.textContent = '';
        return;
    }

    if (y < -5 || y > 5) {
        errorMessage.textContent = 'Координата Y должна быть в пределах от -5 до 5.';
        successMessage.textContent = '';
        return;
    }

    // Очищаем сообщение об ошибке, если данные введены правильно
    errorMessage.textContent = '';
    successMessage.textContent = 'Данные введены успешно!';

    try {
        const formData = new FormData();
        formData.append('x', x.value);
        formData.append('y', y);
        formData.append('r', r);

        const response = await fetch('check.php', {
            method: 'POST',
            body: formData
        });

        if (response.ok) {
            const data = await response.text();
            const resultTable = document.getElementById('resultTable');
            resultTable.innerHTML = data;
        } else {
            console.error('Ошибка сервера:');
        }
    } catch (error) {
        console.error('Ошибка:');
    }


    }


		}
	</script>
</body>
</html>