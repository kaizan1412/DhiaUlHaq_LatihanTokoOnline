<%-- 
    Document   : v_productdetail
    Created on : Oct 18, 2017, 4:47:56 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Detail Product</h1>
        <p>${msg}</p>
            <p>
                <b>Product Name:</b> ${data.productName}<br/>
                <b>Quantity:</b> ${data.quantity}<br/>
                <b>Price:</b> ${data.price}<br/>
            </p>
            <a href="../../cart/buy/${data.id}">Buy This</a>
    </body>
</html>
