<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="text-align: left">
    <sec:authorize access="isAuthenticated()">
        <strong>User: </strong><em><sec:authentication property="principal.username"/></em> |
        <a href="${pageContext.request.contextPath}/admin/products">Продукция</a> |
        <a href="${pageContext.request.contextPath}/admin/orders">Заказы</a> |
        <a href="${pageContext.request.contextPath}/logout">Выйти</a>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <strong>Не авторизован</strong> | <a href="login">Войти</a>
    </sec:authorize>
</div>
<hr>