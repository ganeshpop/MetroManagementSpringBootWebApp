<%--
  Created by IntelliJ IDEA.
  User: venom
  Date: 8/15/2021
  Time: 3:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h3>Enter Your Details</h3>
<form action="./verifyCard" method="post">
        Card ID : <input type="text" name="card"><br><br>
        Password : <input type="password" name="password"><br><br>
    <input type="submit" value="Login">
</form>
<a href="./" >Go Back to Home</a><br><br>
</body>
</html>
