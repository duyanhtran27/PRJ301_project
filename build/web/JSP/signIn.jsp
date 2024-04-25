<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String check = (String)request.getAttribute("check");
%>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <div>
            <h3>Login to <strong>Shop</strong></h3>
        </div>
        <form action="signin" method="post">
            <input type="text" placeholder="Username" id="username" name="user" required="">
            <input type="password" placeholder="**********" id="password" name="pass" required="">
            <div >
                <label><span class="caption">Remember me</span>
                    <input type="checkbox"/>
                    <div class="control__indicator"></div>
                </label>
                <span><a href="signup" class="forgot-pass">Sign Up</a></span> 
            </div>

            <c:choose>
                <c:when test="${check.equals('success')}">
                    ${'Success'}
                    <c:redirect url="ProductController"/>
                    <br />
                </c:when>
                <c:when test="${check.equals('fail')}">
                    ${'<span class="badge badge-danger">Invalid Username or Password</span> <br/>'}
                </c:when>
                <c:otherwise>
                    <br />
                </c:otherwise>
            </c:choose>

            <input type="submit" value="Log In"> 


            <span><a href="home" class="forgot-pass">Back to Home</a></span> 
        </form>
    </body>
</html>
