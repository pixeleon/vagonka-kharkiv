<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Make order</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<jsp:include page="userInfo.jsp"/>
<h2>Оформление заказа</h2>
<div style="padding: 5px">
    <form:form method="post" action="/make-order" modelAttribute="order">
        <form:label path="customerName">Ваше имя: </form:label><br><br>
        <form:input path="customerName"/><br>
        <form:errors path="customerName" cssClass="error"/><br>
        <form:label path="customerPhone">Ваш телефон: </form:label><br><br>
        <form:input path="customerPhone"/><br>
        <form:errors path="customerPhone" cssClass="error"/><br>
        <form:label path="customerEmail">Ваш email: </form:label><br><br>
        <form:input path="customerEmail"/><br>
        <form:errors path="customerEmail" cssClass="error"/><br>
        <form:label path="orderDetails">Детали заказа: </form:label><br><br>
        <form:textarea path="orderDetails"/><br>
        <form:errors path="orderDetails" cssClass="error"/><br>
        <input type="submit" value="Заказать"/>
    </form:form>
    <br><br>
</div>
<jsp:include page="footer.jsp"/>
</body>