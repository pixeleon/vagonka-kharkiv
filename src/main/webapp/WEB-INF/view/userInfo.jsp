<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="text-align: left">
    <sec:authorize access="isAuthenticated()">
        <b>User: </b><i><sec:authentication property="principal.username"/></i> |
        <a href="${pageContext.request.contextPath}/admin/products">Products</a> |
        <a href="${pageContext.request.contextPath}/admin/orders">Orders</a> |
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <b>Not logged in</b> | <a href="login">Login</a>
    </sec:authorize>
</div>
<hr>