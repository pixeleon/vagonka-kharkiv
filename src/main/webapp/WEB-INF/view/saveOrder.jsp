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
<h2>Изменение заказа</h2>
<div style="padding: 5px">
    <form:form method="post" action="/admin/edit-order" modelAttribute="order">
        <form:hidden path="orderId"/>
        <form:label path="customerName">Имя клиента: </form:label><br><br>
        <form:input path="customerName"/><br>
        <form:errors path="customerName" cssClass="error"/><br>
        <form:label path="customerPhone">Телефон клиента: </form:label><br><br>
        <form:input path="customerPhone"/><br>
        <form:errors path="customerPhone" cssClass="error"/><br>
        <form:label path="customerEmail">Почта клиента: </form:label><br><br>
        <form:input path="customerEmail"/><br>
        <form:errors path="customerEmail" cssClass="error"/><br>
        <form:label path="orderDetails">Детлаи заказа: </form:label><br><br>
        <form:textarea path="orderDetails"/><br>
        <form:errors path="orderDetails" cssClass="error"/><br>
        <form:label path="orderDate">Дата/время заказа: ${order.orderDate.toString()}</form:label><br><br>
        <form:label path="orderStatus">Статус заказа: </form:label>
        <form:select path="orderStatus">
            <form:option value="NEW" label="НОВЫЙ" />
            <form:option value="PROCESSED" label="ПРИНЯТ" />
            <form:option value="CLOSED" label="ВЫПОЛНЕН" />
            <form:option value="CANCELLED" label="ОТМЕНЁН" />
        </form:select><br>
        <form:errors path="orderStatus" cssClass="error"/><br>
        <input type="submit" value="Применить"/>
    </form:form>
    <br><br>
    <c:if test="${order.orderId != null}">
        <form:form method="post" action="/admin/delete-order?orderId=${order.orderId}"
                   modelAttribute="order">
            <input type="submit" value="Удалить заказ">
        </form:form>
    </c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>