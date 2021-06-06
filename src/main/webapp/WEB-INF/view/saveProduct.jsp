<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Save product</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<jsp:include page="userInfo.jsp"/>
<h2>Добавление/изменение продукта</h2>
<div style="padding: 5px">
    <form:form method="post" action="/admin/edit-product" modelAttribute="product">
        <form:hidden path="productId"/>
        <form:label path="">Тип продукции: </form:label><br><br>
        <form:select path="typeId">
            <form:options items="${productTypes}" itemValue="typeId" itemLabel="typeName"/>
        </form:select><br>
        <form:errors path="typeId" cssClass="error"/><br>
        <form:label path="woodType">Тип дерева: </form:label><br><br>
        <form:input path="woodType"/><br>
        <form:errors path="woodType" cssClass="error"/><br>
        <form:label path="woodKind">Сорт дерева: </form:label><br><br>
        <form:input path="woodKind"/><br>
        <form:errors path="woodKind" cssClass="error"/><br>
        <form:label path="price">Цена в грн.: </form:label><br><br>
        <form:input path="price"/><br>
        <form:errors path="price" cssClass="error"/><br>
        <form:label path="muId">Единицы измерения: </form:label>
        <form:select path="muId">
            <form:options items="${productMus}" itemValue="muId" itemLabel="muAbbr"/>
        </form:select><br>
        <form:errors path="muId" cssClass="error"/><br>
        <form:label path="amount">Количество на складе: </form:label><br><br>
        <form:input path="amount"/><br>
        <form:errors path="amount" cssClass="error"/><br>
        <form:label path="visible">Видим клиентам: </form:label>
        <form:checkbox path="visible"/><br>
        <form:errors path="visible" cssClass="error"/><br>
        <input type="submit" value="Применить"/>
    </form:form>
    <br>
    <c:if test="${product.productId != null}">
        <form:form method="post" action="/admin/delete-product?productId=${product.productId}"
                   modelAttribute="product">
            <input type="submit" value="Удалить продукт">
        </form:form>
    </c:if>
</div>
<jsp:include page="footer.jsp"/>
</body>