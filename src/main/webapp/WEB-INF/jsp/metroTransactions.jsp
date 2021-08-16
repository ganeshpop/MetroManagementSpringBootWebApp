<%@page import="com.metro.model.pojos.Transaction" %>
<%@page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Transactions</title>
</head>
<body>
<h2>Welcome ${card.cardId}!</h2>

<h1>Transactions</h1>
<%--<table border="1">
    <tr>
        <td>Card ID </td>
        <td>Swipe In Time </td>
        <td>Source Station ID</td>
        <td>Source Station Name</td>
        <td>Destination Station ID</td>
        <td>Destination Station Name</td>
        <td>Swipe Out Time </td>
        <td>Travel Fare </td>
        <td>Fine  </td>
        <td>Total Fare </td>
        <td>Travel Duration </td>
    </tr>
    <% Collection<Transaction> transactions = (Collection<Transaction>) request.getAttribute("transactions");
        for (Transaction transaction : transactions) {
    %>
    <tr>
        <td><%=transaction.getCardId() %>
        </td>
        <td><%=transaction.getSwipeInTimeStamp() %>
        </td>
        <td><%= transaction.getSourceStation().getStationId() %></td>
        <td><%= transaction.getSourceStation().getStationName() %></td>
        <td><%= transaction.getDestinationStation().getStationId() %></td>
        <td><%= transaction.getDestinationStation().getStationName() %></td>
        <td><%= transaction.getSwipeOutTimeStamp() %></td>
        <td><%=transaction.getFare() %>
        <td><%=transaction.getFine() %>
        <td><%= transaction.getFare() + transaction.getFine() %>
        </td>
        <td><%=transaction.getDuration() %>
        </td>
    </tr>
    <% } %>
</table>
<br><br>--%>
<hr>
<table border="1">
    <tr>
        <td>Card ID </td>
        <td>Swipe In Time </td>
        <td>Source Station ID</td>
        <td>Source Station Name</td>
        <td>Destination Station ID</td>
        <td>Destination Station Name</td>
        <td>Swipe Out Time </td>
        <td>Travel Fare </td>
        <td>Fine  </td>
        <td>Total Fare </td>
        <td>Travel Duration </td>
    </tr>
    <c:forEach items="${transactions}" var="transaction">
        <tr>
            <td>${transaction.cardId }</td>
            <td>${transaction.swipeInTimeStamp}</td>
            <td>${transaction.sourceStation.stationId}</td>
            <td>${transaction.sourceStation.stationName}</td>
            <td>${transaction.destinationStation.stationId}</td>
            <td>${transaction.destinationStation.stationName}</td>
            <td>${transaction.swipeOutTimeStamp}</td>
            <td>${transaction.fare}</td>
            <td>${transaction.fine}</td>
            <td>${transaction.fare + transaction.fine}</td>
            <td>${transaction.duration}</td>
        </tr>
    </c:forEach>
</table>
<a href="menu" >Go Back to Menu</a><br><br>
<a href="./" >Go Back to Home</a><br><br>
</body>
</html>