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
        <meta charset="UTF-8">
        <title>Railway Home</title>


        <%@include file="header.jsp" %>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>


    </head>

    <body>

        <div class="cotn_principal">
            <div class="cont_centrar">

                <div class="cont_login">

                    <div class="cont_info_log_sign_up">
                        <div class="col_md_login">
                            <div class="cont_ba_opcitiy">

                                <h2>LOGIN</h2>  
                                <p>Login for Railway management</p> 
                                <button  id="beforeLogin" class="btn_login" onclick="cambiar_login()">LOGIN</button>
                            </div>
                            <span style="color:red">${errorMessage}</span>

                        </div>
                        <div class="col_md_sign_up">
                            <div class="cont_ba_opcitiy">
                                <h2>SIGN UP</h2>


                                <p>Register to Sign In</p>

                                <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
                            </div>
                        </div>
                    </div>


                    <div class="cont_back_info">
                        <div class="cont_img_back_grey">
                            <img src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d" alt="" />
                        </div>

                    </div>
                    <div class="cont_forms" >
                        <div class="cont_img_back_">
                            <img src="https://images.unsplash.com/42/U7Fc1sy5SCUDIu4tlJY3_NY_by_PhilippHenzler_philmotion.de.jpg?ixlib=rb-0.3.5&q=50&fm=jpg&crop=entropy&s=7686972873678f32efaf2cd79671673d" alt="" />
                        </div>
                        <div class="cont_form_login">
                            <a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
                            <h2>LOGIN</h2>
                            <form:form method="POST" action="/RailwayReservation/login/doLogin" modelAttribute="loginUiModel">
                                <!--                                <input type="text" placeholder="Email" />
                                                                <input type="password" placeholder="Password" />-->
                                <div>
                                    <form:input    data-validation="required" data-validation-error-msg="Please enter the user Name"  path="userName" placeholder="Email" style="height: 30px;width: 260px;"/>
                                    <br/>   <form:errors htmlEscape="false" path="userName" cssClass="error"/>        
                                </div>
                                <br/>
                                <div>
                                    <form:input  data-validation="required"   data-validation-error-msg="Please enter the password" path="password" placeholder="password" style="height: 30px;width: 260px;"/>
                                    <br/>   <form:errors htmlEscape="false" path="password" cssClass="error"/>        
                                </div>
                                <br/>
                                <input class="btn_login"  type="submit" value="Login" />
                            </form:form>

                        </div>

                        <div class="cont_form_sign_up">
                            <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>

                            <div style="padding-right: 72px;padding-top: 10px;">
                                <h3>SIGN UP</h3>
                            </div>

                            <form:form id="register" method="POST" action="/RailwayReservation/login/register/user" modelAttribute="registerUiModel">


                                <div>
                                    <form:input data-validation="required" data-validation-error-msg="Please enter email-id"  path="email" placeholder="Email" style="height: 30px;width: 260px;"/>
                                    <br/>          <form:errors htmlEscape="false" path="email" cssClass="error"/>        
                                </div>
                                <br/>

                                <div>
                                    <form:input path="user" data-validation="required" data-validation-error-msg="Please enter user name" placeholder="User" style="height: 30px;width: 260px;" />
                                    <br/>   <form:errors htmlEscape="false" path="user" cssClass="error"/>        
                                </div>
                                <br/>
                                <div>
                                    <form:input path="password" data-validation="required" data-validation-error-msg="Please enter password" placeholder="Password" style="height: 30px;width: 260px;"/>
                                    <br/>   <form:errors htmlEscape="false" path="password" cssClass="error"/>        
                                </div>
                                <br/>
                                <div>
                                    <form:input path="cnfrmPassword" data-validation="required" data-validation-error-msg="Please enter confirm password" placeholder="Confirm Password" style="height: 30px;width: 260px;"/>
                                    <br/>   <form:errors htmlEscape="false" path="cnfrmPassword" cssClass="error"/>        
                                </div>



                                <input class="btn_sign_up" type="submit" value="Sign up" />

                            </form:form>
                        </div>




                    </div>

                </div>
            </div>
        </div>


        <%@include file="footer.jsp" %>
        <script type="text/javascript" src="<c:url value='/resources/js/loginScript.js'/>"></script>
    </body>


</html>
