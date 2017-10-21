/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {


    $('#register').submit(function (e) {

        $('#register').validateForm();
        var count = $("#register .error:not(span)").length;
        e.preventDefault();
        if (count > 0) {
            return false;
        } else {

            url = $('#register').attr("action");
            $.ajax({
                type: 'POST',
                url: url,
                data: $('#register').serialize()

            }).done(function (response) {
                if (response.code === 200) {
                    showSuccessToast(response.data);
                    $("input[type=text]").val("");
                    $('#beforeLogin').click();
//                location.reload();
                } else {
                    showErrorToast(response.data);
                }

            });
        }
    });

    $.validate({
        modules: 'logic, security, sanitize, date, file',
        errorMessagePosition: 'inline',
        errorMessageClass: 'form-error',
        borderColorOnError: '#ff0000',
        errorElementClass: 'error',
        inputParentClassOnError: '',
        validateHiddenInputs: true

    });

});

function customDisplayInlineErrorMessage(element, message) {
    $(element).val(message)
}