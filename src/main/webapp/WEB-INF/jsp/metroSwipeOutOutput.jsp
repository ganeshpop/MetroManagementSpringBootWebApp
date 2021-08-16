<%--
  Created by IntelliJ IDEA.
  User: venom
  Date: 8/15/2021
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.metro.model.pojos.Transaction" %>
<html>
<head>
    <title>Swipe In Status</title>
</head>
<body>
<h2>Welcome ${card.cardId}!</h2>


<h3>${message}</h3>
<% Transaction transaction = (Transaction) request.getAttribute("transaction");%>
<c:if test="${not empty transaction }">
    <%= "-------------- Trip " + transaction.getTransactionId() +  " Details --------------"%><br>
    <%="Card ID: " + transaction.getCardId() %><br>
    <%=" Swipe In Time: " + transaction.getSwipeInTimeStamp() %><br>
    <%="(Source)"%><br>
    <%="[Station ID: " +  transaction.getSourceStation().getStationId() +  " Station Name: " + transaction.getSourceStation().getStationId() + "]"%><br>
    <%="(Destination)"%><br>
    <%="[Station ID: " +  transaction.getDestinationStation().getStationId() +  " Station Name: " + transaction.getDestinationStation().getStationId() + "]"%><br>
    <%=" Swipe In Time: " + transaction.getSwipeOutTimeStamp() %><br>
    <%="Travel Fare: " + transaction.getFare()%><br>
    <%="Fine : " + transaction.getFine()%><br>
    <%="Total Fare : " + (transaction.getFine() + transaction.getFare())%><br>
    <%=" Travel Duration: " + transaction.getDuration() + " Minutes [Free Travel Time 90 Minutes ]" %><br>
    <c:if test="${transaction.fine == 0 }">
    <%= "You Have Completed Your Travel Within 90 Minutes, Fine Not Applicable"%><br>
    </c:if>
    <c:if test="${transaction.fine > 0 }">
    <%= "You Have Been Charged a Fine of " + transaction.getFine() + "/- as You Have Spent an Excess of " + (transaction.getDuration() - 90) + " Minutes" %><br>
    </c:if>
</c:if>
<a href="menu" >Go Back to Menu</a><br><br>
<a href="./" >Go Back to Home</a><br><br>
</body>
</html>
