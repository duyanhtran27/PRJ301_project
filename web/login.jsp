<%-- 
    Document   : login.jsp
    Created on : Apr 25, 2024, 10:17:31 PM
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
         <div class="login-container">
    <h2>Login</h2>
    <form action="/EBL5/login" method="POST">
      <input type="text" name="username" placeholder="Username" required>
      <input type="password" name="password" placeholder="Password" required>
      <input type="submit" value="Login">
    </form>
  </div>
    </body>
</html>
