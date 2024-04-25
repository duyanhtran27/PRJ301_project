<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : newjsp
    Created on : Apr 25, 2024, 8:56:04 PM
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
        <div class="container">
        <!-- Phần thông tin người dùng -->
        <div>
        
            
        </div>
        <!-- Phần các nút -->
        <div>
            <button class="button" id="loginBtn" onclick="window.location.href='\login'">Login</button>
            <button class="button" id="logoutBtn" onclick="window.location.href='\logout'">Logout</button>
            <button class="button" id="RegisterBtn" onclick="window.location.href='\signup'">Register</button>
            <button class="button" id="showCartBtn">Show Cart</button>
        </div>
    </div>
        
        <table>
        <thead>
            <tr>
                <th>Category</th>
            </tr>
        </thead>
        <tbody>
            
        <c:forEach var="o" items="${listCategory}">
            <tr>
                <td><a href="index?category=${o.id}">${o.name}</a></td>
            </tr>
        </c:forEach>
            
            
            <!-- Thêm các hàng khác cho các category khác -->
        </tbody>
    </table>

    <table>
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Add to cart</th>
            </tr>
        </thead>
        <tbody>
            <!-- Dữ liệu sản phẩm sẽ được thêm thông qua JavaScript khi category được chọn -->
            <c:forEach var="o" items="${listProduct}">
                <tr>
                    <td>${o.name}</td>
                    <td>${o.price}</td>
                    <td>${o.desc}</td>
                    <td><a href="/EBL5/addToCart">Add to Cart</a></td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>
