/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showSuccessToast(message) {
    toastr.success(message);
}

function showErrorToast(message) {
    toastr.error(message);
}

function calculateFare() {
    var dadarBaseFare = 500;
    var vasaiBaseFare = 600;
    var cstBaseFare = 650;
    var totalFare = 0;
    var fromStation = $('#fromStation').val();
    var tickets = $('#ticket').val();
    if (fromStation === 'dadar') {
        totalFare = dadarBaseFare * tickets;
        $('#fare').val(totalFare);
    }
    if (fromStation === 'vasai') {
        totalFare = vasaiBaseFare * tickets;
        $('#fare').val(totalFare);
    }
    if (fromStation === 'cst') {
        totalFare = cstBaseFare * tickets;
        $('#fare').val(totalFare);
    }
}

