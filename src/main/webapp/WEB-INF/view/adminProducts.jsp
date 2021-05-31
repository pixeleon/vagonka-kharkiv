<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Admin products</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<jsp:include page="userInfo.jsp"/>
<h2>Products list</h2>
<a href="${pageContext.request.contextPath}/admin/create-product">Add new product</a><br><br>
<table border="1">
    <thead style="text-align: left">
    <tr>
        <th id="1">Продукт</th>
        <th id="2">Дерево</th>
        <th id="3">Сорт</th>
        <th id="4">Цена (грн)</th>
        <th id="5">Ед. изм.</th>
        <th id="6">Кол-во</th>
        <th id="7">Видимый</th>
        <th id="8">Действие</th>
    </tr>
    </thead>
    <c:forEach items="${products}" var="order">
        <tr>
            <td>${order.typeName}</td>
            <td>${order.woodType}</td>
            <td>${order.woodKind}</td>
            <td>${order.price}</td>
            <td>${order.muAbbr}</td>
            <td>${order.amount}</td>
            <td>${order.visible}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/edit-product?productId=${order.productId}">Изменить</a>
            </td>

        </tr>
    </c:forEach>
</table
<jsp:include page="footer.jsp"/>
</body>
</html>
