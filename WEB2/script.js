document.getElementById("myForm").addEventListener('submit', async function (event) {
    event.preventDefault();

    const x = document.querySelector('input[name="x"]:checked');
    const y = document.querySelector('input[name="y"]').value;
    const r = document.querySelector('input[name="r"]').value;
    const errorMessage = document.getElementById("errorMessage");
    const successMessage = document.getElementById("successMessage");

    if (!x || !y || !r) {
        errorMessage.textContent = 'Пожалуйста, введите все данные.';
        successMessage.textContent = '';
        return;
    }
    if (isNaN(y) || isNaN(r)) {
        errorMessage.textContent = 'Координата Y и радиус R должны быть числами.';
        successMessage.textContent = '';
        return;
    }

    if (y < -3 || y > 3) {
        errorMessage.textContent = 'Координата Y должна быть в пределах от -2 до 2.';
        successMessage.textContent = '';
        return;
    }

    errorMessage.textContent = '';
    successMessage.textContent = 'Данные введены успешно!';

    try {
        const formData = new FormData();
        formData.append('x', x.value);
        formData.append('y', y);
        formData.append('r', r);

        var start = window.performance.now();
        document.getElementById('res').innerHTML = '';

        // Используйте await для вызова fetch
        const response = await fetch('check.php', {
            method: 'POST',
            body: formData, // Используйте объект FormData
        });

        // Проверьте, что статус ответа успешен (200)
        if (response.ok) {
            const data = await response.text();
            const resultTable = document.getElementById('res');
            resultTable.innerHTML = data;
        } else {
            console.error('Ошибка:', response.status);
        }
    } catch (error) {
        console.error('Ошибка:', error);
    }
});
