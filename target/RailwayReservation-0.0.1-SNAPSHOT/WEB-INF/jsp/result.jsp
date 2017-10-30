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
        <h2>
            ${message}
        </h2>
    </body>
</html>

