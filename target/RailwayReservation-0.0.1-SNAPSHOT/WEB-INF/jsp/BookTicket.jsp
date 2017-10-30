<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<html>
    <head>
        <%@include file="header.jsp"%>



        <title>Book Ticket</title>
        <style type="text/css">
            body {
                background-image: url('http://crunchify.com/bg.png');
            }
        </style>
        <%@include file="menubar.jsp" %>

    </head>
    <body>
        <form:form id="bookTickets" action="/RailwayReservation/login/ticket/book/${trainNo}" modelAttribute="bookTicket">
            <div id="main-div">
               
                <div class="main2-div">
                    <span>  Age :</span>

                    <form:input style=" margin-left: 167px;width: 174px;" path="age" data-validation="required" data-validation-error-msg="Please enter Customer age"/>

                </div>
                <div class="main2-div">

                    <span>
                        Name
                    </span>

                    <form:input style=" margin-left: 167px;width: 174px;" path="custName" data-validation="required" data-validation-error-msg="Please enter Customer name"/>

                </div>
              

                <div class="main2-div">

                    Select number of tickets:

                    <form:select id="ticket" path="ticketNumber" data-validation="required" data-validation-error-msg=" Please select Number of ticket" style=" margin-left: 43px;width: 174px;" class="input-div">
                        <form:option value="" label="--- Select ---"/>
                        <form:option value="1" label="1"/>
                        <form:option value="2" label="2"/>
                        <form:option value="3" label="3"/>
                    </form:select>

                </div>

                

                <div class="main2-div">
                    <input type="submit" value="Book Ticket"/>
                </div>


            </div>

        </form:form>

    </body>


    <!--    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>-->
    <%@include file="footer.jsp" %>
    <script>


        $(function () {
            $.validate({
                modules: 'logic, security, sanitize, date, file',
                errorMessagePosition: 'inline',
                errorMessageClass: 'form-error',
                borderColorOnError: '#ff0000',
                errorElementClass: 'error',
                inputParentClassOnError: '',
                validateHiddenInputs: true

            });
            $("#datepicker-12").datepicker();
            $("#datepicker-12").datepicker("setDate", "10w+1");
        });

    </script>
</html>

