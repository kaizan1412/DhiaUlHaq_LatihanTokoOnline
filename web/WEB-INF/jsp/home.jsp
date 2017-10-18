<%-- 
    Document   : home
    Created on : Oct 17, 2017, 8:22:21 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="" />
        <h1>Welcome to Dear Shop</h1>
        <ul>
            Menu:
            <li>Home</li>
            <li><a href="${pageContext.request.contextPath}/product">Product</a>
                <ul>
                    <c:forEach var="cat" items="${cate}">
                        <li style="text-transform: capitalize;"><a href="product/cate/${cat.id}">${cat.categoryName}</a></li>
                    </c:forEach>
                </ul>
            </li>
            <li>My Cart</li>
            <% 
                try{
                   session.getAttribute("userlog");
                   System.out.println(session.getAttribute("userlog"));
                   if(session.getAttribute("userlog") != null){
            %>           <li>Logout</li>
            <%       }
                    else{
            %>      
                    <li><a href="user">Login</a></li>
                    <li>Register</li>
            <%        }
            %>
            
            <%  }catch(NullPointerException e){ %>
            <li> Login </li>
            <li> Register </li>
            <% } %>
        </ul>
    </body>
</html>
