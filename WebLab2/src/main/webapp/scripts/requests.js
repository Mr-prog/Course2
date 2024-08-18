import table from "./table.js";
import area from "./area.js";

const requests = {
    clearRequest: function () {
        $.ajax({
            type: "GET",
            url: "./controller",
            data: { "request-type": "clear-request" },
            success: function () {
                // Удаляем только содержимое таблицы результатов
                $("#results-table-body").empty();
            },
            error: function (xhr, status, error) {
                console.error("Ошибка при очистке: ", error);
            }
        });
    },

    areaCheckRequest: function (data) {
        $.ajax({
            type: "GET",
            url: "./controller-servlet",
            data: data,
            success: function (response) {
                try {
                    let dataJson = JSON.parse(response);
                    table.writeResult(dataJson);
                    area.addDot(dataJson);
                } catch (error) {
                    console.error("Ошибка при обработке ответа: ", error);
                }
            },
            error: function (xhr, status, error) {
                console.error("Ошибка при выполнении запроса: ", error);
            }
        });
    }
}

export default requests;