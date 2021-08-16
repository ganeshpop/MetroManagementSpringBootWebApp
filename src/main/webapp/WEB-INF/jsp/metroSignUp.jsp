<%--
  Created by IntelliJ IDEA.
  User: venom
  Date: 8/15/2021
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>
<h3>Welcome</h3>
<h3>Enter The Following Details</h3>

<form action="./createCard" method="post">
    Enter initial Balance(>100): <input type="text" name="cardBalance"><br><br>
    Password : <input type="password" name="initialPassword"><br><br>
    Conform Password : <input type="password" name="conformationPassword"><br><br>
    <input type="submit" value="Verify">
</form>
<a href="menu" >Go Back to Menu</a><br><br>
<a href="./" >Go Back to Home</a><br><br>
</body>
</html>
