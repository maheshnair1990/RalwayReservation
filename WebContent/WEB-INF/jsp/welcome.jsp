<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<html>
    <head>
        <%@include file="header.jsp"%>

<!--        <link type="text/css" rel="stylesheet" href="<c:url value="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" />"/>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />"/>-->

        <title>Spring MVC Tutorial by Crunchify - Hello World Spring MVC
            Example</title>
        <style type="text/css">
            body {
                background-image: url('http://crunchify.com/bg.png');
            }
        </style>
        <%@include file="menubar.jsp" %>

    </head>
    <body>
        <form:form id="bookTicket" action="/RailwayReservation/login/ticket/check" modelAttribute="bookTicket">
            <div id="main-div">
                <div class="main2-div">
                    <span>   Date of Journey :</span>

                    <input data-validation="required" data-validation-error-msg=" Please select Date of Journey" id="datepicker-12" type="text" class="input-div"/>

                </div>
                <div class="main2-div">

                    <span>
                        From Station
                    </span>

                    <form:select id="fromStation" data-validation="required" data-validation-error-msg=" Please select Station" path="fromStation" class="input-div" style=" margin-left: 151px;width: 174px;">
                        <form:option value="" label="--- Select ---"/>
                        <form:option value="cst" label="Cst" />
                        <form:option value="vasai" label="Vasai" />
                        <form:option value="dadar" label="Dadar" />
                    </form:select>

                </div>
                <div class="main2-div">

                    <span>
                        To Station
                    </span>

                    <form:select path="toStation" data-validation="required" data-validation-error-msg=" Please select Station" class="input-div" style=" margin-left: 167px;width: 174px;">
                        <form:option value="" label="--- Select ---"/>
                        <form:option value="Trichur" label="Trichur" />
                        <form:option value="Delhi" label="Vasai" />
                        <form:option value="Ahmdabad" label="Dadar" />
                    </form:select>


                </div>

                <div class="main2-div">

                    Select number of tickets:

                    <form:select id="ticket" path="ticketNumber" data-validation="required" data-validation-error-msg=" Please select Number of ticket" style=" margin-left: 72px;width: 174px;" class="input-div">
                        <form:option value="" label="--- Select ---"/>
                        <form:option value="1" label="1"/>
                        <form:option value="2" label="2"/>
                        <form:option value="3" label="3"/>
                    </form:select>

                </div>

                <div class="main2-div">

                    Amount :

                    <input type="number" id="fare" readonly="true" style=" margin-left: 167px;width: 174px;" class="input-div"/>
                    <input type="button" onclick="calculateFare()" value="calculate"/>
                </div>

                <div class="main2-div">
                    <input type="submit" value="Check Availiability"/>
                </div>


            </div>
            <div id="table-div">

                <table border="2" width="70%" cellpadding="2">  
                    <tr><th>Train Number</th><th>Train Name</th><th>From Station</th><th>Ticket Availiable/Waiting List</th><th>Arrival time</th><th>Depature Time</th><th>Book ticket</th></tr>  
                            <c:forEach var="train" items="${list}">   
                        <tr>  
                            <td>${train.trainNo}</td>  
                            <td>${train.train}</td>  
                            <td>${train.station}</td>  
                            <c:choose>
                                <c:when test="${train.ticketAvailiable gt 0}">
                                    <td>${train.ticketAvailiable}</td> 
                                </c:when>
                                <c:when test="${train.ticketAvailiable le 0}">
                                    <td>Ticket Not Availiable</td> 
                                </c:when>
                            </c:choose>  
                            <td>${train.arrivalTime}</td>  
                            <td>${train.depTime}</td>  
                            <c:choose>
                                <c:when test="${train.ticketAvailiable gt 0}">
                            <td><a href="/RailwayReservation/login/ticket/show/${train.trainNo}">Book Now</a></td>  
                                </c:when>
                                <c:when test="${train.ticketAvailiable le 0}">
                                    <td>Ticket Not Availiable</td> 
                                </c:when>
                            </c:choose>  

                        </tr>  
                    </c:forEach>  
                </table>  


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

