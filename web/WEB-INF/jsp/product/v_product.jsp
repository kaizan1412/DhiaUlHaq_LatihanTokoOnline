<%-- 
    Document   : v_product
    Created on : Oct 17, 2017, 8:33:52 PM
    Author     : user
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Our Product</h1>
        <p>${msg}</p>
        <c:forEach var="p" items="${dataprod}">
            <p><a href="product/detail/${p.id}" title="Lihat Detail Produk">${p.productName}</a></p>
        </c:forEach>
    </body>
</html>
