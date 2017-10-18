<%-- 
    Document   : v_userLogin
    Created on : Oct 18, 2017, 5:23:00 AM
    Author     : user
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <p>${msg}</p>
        <form:form action="user/validate" modelAttribute="loginBean" method="POST">
            
            <p>${msg}</p>
            
            <form:label path="username">Username:</form:label>
            <form:input path="username" />
            <br/>
            
            <form:label path="password">Password:</form:label>
            <form:input path="password" />
            <br/>
            
            <form:button name="submit" value="Login">Sign In</form:button>
        </form:form>
    </body>
</html>
