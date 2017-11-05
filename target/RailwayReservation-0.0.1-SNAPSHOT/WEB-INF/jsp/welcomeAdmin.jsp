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
        <%@include file="menubar_admin.jsp" %>

    </head>
    <body>
        <div>
            ${message}
        </div>
        <form:form id="addTrain" action="/RailwayReservation/login/train/add" modelAttribute="trainAdminUiModel">
            <div id="main-div">
                <div class="main2-div">
                    <span>   Train Name:</span>

                    <form:input data-validation="required" path="trainName" data-validation-error-msg=" Please Enter Train name" id="trainName" type="text" class="input-div"/>

                </div>
                <div class="main2-div">

                    <span>
                        Tickets
                    </span>
                    <form:input style="margin-left: 158px;" data-validation="required" path="tickets" data-validation-error-msg=" Please Enter availiable ticket" id="tickets" type="text" class="input-div"/>

                </div>
                <div class="main2-div">

                    <span>
                        Station
                    </span>

                    <form:input style="margin-left: 158px;" data-validation="required" path="station" data-validation-error-msg=" Please Enter station" id="station" type="text" class="input-div"/>

                </div>

                <div class="main2-div">

                    Arrival time

                    <form:input data-validation="required" path="arrivalTime" data-validation-error-msg=" Please Enter arrivalTime" id="arrivalTime" type="text" class="input-div"/>


                </div>

                <div class="main2-div">

                    Depature time :

                    <form:input style="margin-left: 104px;" data-validation="required" path="depatureTime" data-validation-error-msg=" Please Enter depatureTime" id="depatureTime" type="text" class="input-div"/>

                </div>

                <div class="main2-div">
                    <input type="submit" value="Insert Train"/>
                </div>


            </div>
            <div id="table-div">

                <table border="2" width="70%" cellpadding="2">  
                    <tr><th>Train Number</th><th>Train Name</th><th>From Station</th><th>Ticket Availiable/Waiting List</th><th>Arrival time</th><th>Depature Time</th><th>Edit ticket</th><th>Delete ticket</th></tr>  
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
                            <td><a href="/RailwayReservation/login/train/edit/get/${train.trainNo}">Edit</a></td>  
                            <td><a href="/RailwayReservation/login/train/delete/${train.trainNo}">Delete</a></td>  


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

