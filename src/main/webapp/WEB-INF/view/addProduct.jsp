<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Edit product</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<jsp:include page="userInfo.jsp"/>
<h2>Creating / editing product</h2>
<div style="padding: 5px">
    <form:form method="post" action="/admin/edit-product" modelAttribute="product">
        <form:hidden path="productId"/>
        <form:label path="">Type: </form:label><br><br>
        <form:select path="typeId">
            <form:options items="${productTypes}" itemValue="typeId" itemLabel="typeName"/>
        </form:select><br>
        <form:errors path="typeId" cssClass="error"/><br>
        <form:label path="woodType">Wood type: </form:label><br><br>
        <form:input path="woodType"/><br>
        <form:errors path="woodType" cssClass="error"/><br>
        <form:label path="woodKind">Wood kind: </form:label><br><br>
        <form:input path="woodKind"/><br>
        <form:errors path="woodKind" cssClass="error"/><br>
        <form:label path="price">Price: </form:label><br><br>
        <form:input path="price"/><br>
        <form:errors path="price" cssClass="error"/><br>
        <form:label path="muId">MU: </form:label>
        <form:select path="muId">
            <form:options items="${productMus}" itemValue="muId" itemLabel="muAbbr"/>
        </form:select><br>
        <form:errors path="muId" cssClass="error"/><br>
        <form:label path="amount">Amount: </form:label><br><br>
        <form:input path="amount"/><br>
        <form:errors path="amount" cssClass="error"/><br>
        <form:label path="visible">Visible: </form:label>
        <form:checkbox path="visible"/><br>
        <form:errors path="visible" cssClass="error"/><br>
        <input type="submit" value="Apply changes"/>
    </form:form>
    <br><br>
    <c:if test="${pro}"
    <form:form method="post" action="/admin/delete-product?productId=${product.productId}"
               modelAttribute="product">
        <input type="submit" value="Delete product">
    </form:form>
</div>
<jsp:include page="footer.jsp"/>
</body>