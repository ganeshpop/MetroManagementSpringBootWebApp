<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Swipe In</title>
</head>
<body>
<h2>Welcome ${card.cardId}!</h2>

<h1>Swipe In</h1>
<h3>Your Card [${card.cardId}] Balance is ${card.balance}</h3>
<form action="./cardSwipeIn" method="post">
    <h2>Select A Station to Swipe In:</h2>
    <h3>[ Station ID -- Station Name ]</h3>

    <c:forEach items="${stations}" var="station">
        <label>
            <input type="radio" name="swipeInStation" value="${station.stationId}">
        </label>
        [${station.stationId}  --  ${station.stationName } ]<br><br>
    </c:forEach>
    <input type="submit" value="Swipe In">
</form>
<a href="menu" >Go Back to Menu</a><br><br>
<a href="./" >Go Back to Home</a><br><br>
</body>
</html>