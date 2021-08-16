<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: venom
  Date: 8/16/2021
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fines</title>
</head>
<body>

<spring:form action="./" method="post">
    Fines : <spring:select path="fine">
    <spring:options items="${fines}"/>
</spring:select><br><br>
</spring:form>


</body>
</html>
