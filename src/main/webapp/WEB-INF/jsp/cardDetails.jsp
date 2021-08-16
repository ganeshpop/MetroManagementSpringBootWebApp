<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Card</title>
</head>
<body>
<h1>Card</h1>
<h2>Welcome ${card.cardId}!</h2>
<table border="1">
    <tr>
        <td>Card ID </td>
        <td>Card Type </td>
        <td>Balance  </td>
        <td>Active Since </td>
    </tr>
    <tr>
        <td>${card.cardId}</td>
        <td>${card.cardType}</td>
        <td>${card.balance}</td>
        <td>${card.activeSince}</td>
    </tr>
</table>
<br><br>

<a href="menu" >Go Back to Menu</a><br><br>
<a href="./" >Go Back to Home</a><br><br>
</body>
</html>