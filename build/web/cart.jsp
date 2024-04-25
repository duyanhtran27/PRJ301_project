<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : showCart
    Created on : Apr 26, 2024, 12:34:08 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Your Shopping Cart</h2>
        
        <form action="update">
            <table>
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>quantity</th>
                <th>total</th>
                <th>remove</th>
            </tr>
        </thead>
        <tbody>
            
            <c:forEach var="o" items="${cart}">
                <tr>
                    <td>${o.product.name}</td>
                    <td>${o.product.price}</td>
                    <td><input type="text" name="quantity" value="${o.quantity}"></td>
                    <td>${o.product.price * o.quantity}</td>
                    <td><a href="/EBL5/removeToCart?productId=${o.product.id}">Remove</a></td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>
            <input type="submit" value="Update">
        </form>    
        <h2><a href="/EBL5/removeall">remove all</a></h2>
        <h2><a href="/EBL5/checkout">Check Out</a></h2>
    </body>
</html>
