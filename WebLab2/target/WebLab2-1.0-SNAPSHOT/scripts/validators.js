const validators = {
    isFormInputValid: function () {
        return validators.isRInputValid() && validators.isXInputValid() && validators.isYInputValid();
    },

    isRInputValid: function () {
        if ($('input[name="r"]').is(':checked')) {
            errMsg.html("");
            return true;
        }
        errMsg.html("Введите R");
        return false;
    },

    isXInputValid: function () {

        let xElement = $("#x");
        let x = xElement.val();
        let min = -5, max = 3;

        if (!$.isNumeric(x)) {
            errMsg.html("Х должен быть числом типа Float");
            return false;
        }

        x = roundTwoSigns(x);
        xElement.val(x);

        if (x <= min || x >= max) {
            errMsg.html("Х вне допустимого диапазона");
            return false;
        }
        errMsg.html("");
        return true;

    },

    isYInputValid: function () {
        let yElement = $("#y");
        let y = yElement.val();
        let min = -5, max = 3;

        if (!$.isNumeric(y)) {
            errMsg.html("Y должен быть числом типа Float");
            return false;
        }

        y = roundTwoSigns(y);
        yElement.val(y);

        if (y <= min || y >= max) {
            errMsg.html("Y вне допустимого диапазона");
            return false;
        }
        errMsg.html("");
        return true;

    },

    err: function (errMsg) {
        errMsg.html(errMsg);
    }
}
export default validators;


function roundTwoSigns(number) {
    return Math.round(number * 100) / 100
}

const errMsg = $("#err-msg");

function setErrMsg(errMsg) {
    errMsg.html(errMsg);
}

function clearErrMsg() {
    errMsg.html("");
}