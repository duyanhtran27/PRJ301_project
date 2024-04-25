<%-- 
    Document   : register
    Created on : Apr 25, 2024, 11:16:33 PM
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
        <% if (request.getAttribute("usernameExists") != null) { %>
        <p style="color: red;">Username already exists. Please choose a different one.</p>
    <% } %>
    
    <% if (request.getAttribute("passnotmatch") != null) { %>
        <p style="color: red;">pass not match</p>
    <% } %>
             <div class="login-container">
    <h2>Login</h2>
    <form action="/EBL5/signup" method="POST">
        <input type="text" name="name" placeholder="name" required>
      <input type="text" name="username" placeholder="Username" required>
      <input type="password" name="password" placeholder="Password" required>
      <input type="password" name="passwordAgain" placeholder="Password Again" required>
      <input type="submit" value="register">
    </form>
  </div>
    </body>
</html>
