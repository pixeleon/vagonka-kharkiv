<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Orders</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<jsp:include page="userInfo.jsp"/>
<h2>Заказы клиентов</h2>
<table border="1">
    <thead style="text-align: left">
    <tr>
        <th id="1">Номер</th>
        <th id="2">Имя заказчика</th>
        <th id="3">Телефон заказчика</th>
        <th id="4">Почта заказчика</th>
        <th id="5">Детали</th>
        <th id="6">Время</th>
        <th id="7">Статус</th>
        <th id="8">Действие</th>
    </tr>
    </thead>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.orderId}</td>
            <td>${order.customerName}</td>
            <td>${order.customerPhone}</td>
            <td>${order.customerEmail}</td>
            <td>${order.orderDetails}</td>
            <td>${order.orderDate}</td>
            <td>${order.orderStatus}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/edit-order?orderId=${order.orderId}">Изменить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
