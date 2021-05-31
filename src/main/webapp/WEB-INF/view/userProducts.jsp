<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Products</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<jsp:include page="userInfo.jsp"/>
<h2>Products and prices</h2>
<table border="1">
    <thead style="text-align: left">
    <tr>
        <th id="1">Продукт</th>
        <th id="2">Дерево</th>
        <th id="3">Сорт</th>
        <th id="4">Цена (грн)</th>
        <th id="5">Ед. изм.</th>
    </tr>
    </thead>
    <c:forEach items="${products}" var="order">
        <tr>
            <td>${order.typeName}</td>
            <td>${order.woodType}</td>
            <td>${order.woodKind}</td>
            <td>${order.price}</td>
            <td>${order.muAbbr}</td>
        </tr>
    </c:forEach>
</table
<jsp:include page="footer.jsp"/>
</body>
</html>
