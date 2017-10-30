<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<html>
    <head>
        <%@include file="header.jsp"%>


        <title>Ticket Status</title>
        <style type="text/css">
            body {
                background-image: url('http://crunchify.com/bg.png');
            }
        </style>
        <%@include file="menubar.jsp" %>

    </head>
    <body>
        <form:form id="cancelTicket" method="POST" action="/RailwayReservation/login/ticket/pnr/check" modelAttribute="cancelTicket">
            <div id="main-div">
                <div class="main2-div">
                    <span>  Enter Pnr :</span>
                    <form:input path="pnr"/>
                </div>
                <div class="main2-div">
                    <input type="submit" value="Check"/>
                </div>

            </div>
            <div id="table-div">

                <table border="2" width="70%" cellpadding="2">  
                    <tr><th>Train Number</th><th>Customer Name</th><th>Ticket Booked</th><th>Cancel ticket</th></tr>  
                            <c:forEach var="train" items="${list}">   
                        <tr>  
                            <td>${train.trainNo}</td>  
                            <td>${train.custName}</td>  
                            <td>${train.ticketBooked}</td>  
                            <c:choose>
                                <c:when test="${train.active eq 0}">
                               <td>Ticket Already Canceled</td> 
                                </c:when>
                                <c:otherwise>
                                                                <!--<td><a href="/RailwayReservation/login/ticket/show/${train.trainNo}">Book Now</a></td>-->  

                                    <td><a href="/RailwayReservation/login/ticket/cancel/${train.trainNo}/${train.custId}/${train.ticketBooked}">Cancel Ticket</a></td>  
                                    </c:otherwise>
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

