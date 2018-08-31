<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
    <style type="text/css">
        <%@include file="/WEB-INF/pages/styles/style.css"%>
    </style>
</head>
<body>
<div align="center" class="regist">
    <c:url value="/j_spring_security_check" var="loginUrl"/>

    <form action="${loginUrl}" method="POST">
        Login:<br/><input type="text" name="j_login"><br/>
        Password:<br/><input type="password" name="j_password"><br/>
        <input type="submit"/>

        <h3><p><a href="/register">Register new user</a></p></h3>

        <c:if test="${param.error ne null}">
            <p>Wrong login or password, or this login has been already authenticated by other user!</p>
        </c:if>

        <c:if test="${param.logout ne null}">
            <h3><p>Chao!</p></h3>
        </c:if>

        <c:if test="${param.concses ne null}">
            <h3><p>This login has been already authenticated by other user!</p></h3>
        </c:if>
    </form>
</div>
</body>
</html>
