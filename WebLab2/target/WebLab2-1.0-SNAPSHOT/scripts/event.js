document.getElementById("send").addEventListener('click', async function (event) {
    const x = document.querySelector('input[name="x"]:checked').value;
    const y = document.querySelector('input[name="y"]').value;
    const r = document.querySelector('input[name="r"]').value;

    if (!validation(x, y, r)) {
        return;
    }

    try {
        const url = `check.php?x=${encodeURIComponent(x)}&y=${encodeURIComponent(y)}&r=${encodeURIComponent(r)}`;

        const response = await fetch(url, {
            method: 'GET',
        });

        if (response.ok) {
            const data = await response.text();
            const resultTable = document.getElementById('result-table');
            resultTable.insertAdjacentHTML("afterbegin", data);
        } else {
            console.error('Ошибка:', response.status);
        }
    } catch (error) {
        console.error('Ошибка:', error);
    }
});


function validation(x, y, r) {
    const errorMessage = document.getElementById("errorMessage");
    const successMessage = document.getElementById("successMessage");
    if (!x || !y || !r) {
        errorMessage.textContent = 'Пожалуйста, введите все данные.';
        successMessage.textContent = '';
        return false;
    }
    if (isNaN(y) || isNaN(r)) {
        errorMessage.textContent = 'Координата Y и радиус R должны быть числами.';
        successMessage.textContent = '';
        return false;
    }

    if (y < -5 || y > 3) {
        errorMessage.textContent = 'Координата Y должна быть в пределах от -3 до 3.';
        successMessage.textContent = '';
        return false;
    }

    if (r < 2 || r > 5) {
        errorMessage.textContent = 'Координата R должна быть в пределах от 2 до 5.';
        successMessage.textContent = '';
        return false;
    }
    errorMessage.textContent = '';
    successMessage.textContent = 'Данные введены успешно!';
    return true;
}