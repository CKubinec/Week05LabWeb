<%--
  Created by IntelliJ IDEA.
  User: Craig
  Date: 2020-10-09
  Time: 1:11 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Login</h1>
<form method="post">
    <label>
    Username: <input type="text" name="username"><br>
    </label>
    <label>
    Password: <input type="password" name="password">
    </label><br>
    <input type="submit" value="Login">
</form>
<p>${message}</p>
</body>
</html>
