<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Edit order</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<jsp:include page="userInfo.jsp"/>
<h2>Editing order</h2>
<div style="padding: 5px">
    <form:form method="post" action="/admin/edit-order" modelAttribute="order">
        <form:hidden path="orderId"/>
        <form:label path="customerName">Customer name: </form:label><br><br>
        <form:input path="customerName"/><br>
        <form:errors path="customerName" cssClass="error"/><br>
        <form:label path="customerPhone">Customer phone: </form:label><br><br>
        <form:input path="customerPhone"/><br>
        <form:errors path="customerPhone" cssClass="error"/><br>
        <form:label path="customerEmail">Customer email: </form:label><br><br>
        <form:input path="customerEmail"/><br>
        <form:errors path="customerEmail" cssClass="error"/><br>
        <form:label path="orderDetails">Order details: </form:label><br><br>
        <form:textarea path="orderDetails"/><br>
        <form:errors path="orderDetails" cssClass="error"/><br>
        <form:label path="orderDate">Order timestamp: ${order.orderDate.toString()}</form:label><br><br>
        <form:label path="orderStatus">Order status: </form:label>
        <form:select path="orderStatus">
            <form:option value="NEW" label="NEW" />
            <form:option value="PROCESSED" label="PROCESSED" />
            <form:option value="CLOSED" label="CLOSED" />
            <form:option value="CANCELLED" label="CANCELLED" />
        </form:select><br>
        <form:errors path="orderStatus" cssClass="error"/><br>
        <input type="submit" value="Apply changes"/>
    </form:form>
    <br><br>
    <c:if test="${order.orderId != null}">
        <form:form method="post" action="/admin/delete-order?orderId=${order.orderId}"
                   modelAttribute="order">
            <input type="submit" value="Delete order">
        </form:form>
    </c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>