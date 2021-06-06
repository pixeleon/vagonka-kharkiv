<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Sign in</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>
<h2>Пожалуйста, авторизуйтесь</h2>
<div style="padding: 5px">
    <form:form method="post" action="/login" modelAttribute="login">
        <form:label path="username">Имя пользователя: </form:label><br><br>
        <form:input path="username"/><br>
        <form:errors path="username" cssClass="error"/><br><br>
        <form:label path="password">Пароль: </form:label><br><br>
        <form:password path="password"/><br>
        <form:errors path="password" cssClass="error" /><br><br>
        <input type="submit" value="Войти"/>
    </form:form><br><br>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
