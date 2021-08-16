<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: venom
  Date: 8/15/2021
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recharge</title>
</head>
<body>
<h2>Welcome ${card.cardId}!</h2>
<h3>Enter Recharge Amount</h3>
<h3>Your Card [${card.cardId}] Balance is ${card.balance}</h3>

<form action="./topUpCard" method="post">
    Amount : <input type="text" name="amount"><br><br>
    <input type="submit" value="Recharge">
</form>

<a href="menu" >Go Back to Menu</a><br><br>
<a href="./" >Go Back to Home</a><br><br>
</body>
</html>
