<%-- 
    Document   : login
    Created on : Sep 25, 2017, 7:49:26 PM
    Author     : Mahesh Nair
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html >
    <head>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/main.css" />"/>
    </head>

    <body>

        <div class="topnav" id="myTopnav">
            <a href="#home">Home</a>
            <a href="#Reserve">Ticket Reservation</a>
            <a href="#contact">Ticket Status</a>
            <a href="#about">About</a>
            <span class="topnav-user"> ${userSession.user}</span>
        </div>

    </body>


</html>
