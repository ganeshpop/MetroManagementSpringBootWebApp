<%@page import="java.util.Collection" %>
<%@ page import="com.metro.model.pojos.Card" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Swipe Out</title>
</head>
<body>
<h2>Welcome ${card.cardId}!</h2>

<h1>Swipe Out</h1>
<% Card card = (Card) request.getAttribute("card");%>
<h3>Your Card [<%=card.getCardId()%>] Balance is <%=card.getBalance()%>/-</h3>
<form action="./cardSwipeOut" method="post">
    <h2>Select A Station to Swipe Out:</h2>
    <h3>[ Station ID -- Station Name ]</h3>

    <c:forEach items="${stations}" var="station">
        <label>
            <input type="radio" name="swipeOutStation" value="${station.stationId}">
        </label>
        [${station.stationId}  --  ${station.stationName } ]<br><br>
    </c:forEach>
    <input type="submit" value="Swipe Out">
</form>
<a href="menu" >Go Back to Menu</a><br><br>
<a href="./" >Go Back to Home</a><br><br>
</body>
</html>