<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
    <style type="text/css">
        <%@include file="/WEB-INF/pages/styles/style.css"%>
    </style>
</head>
<body>

<div class="tables-fw users">
    <h2> Users list </h2>
    <table border="1" class="h2-al">
        <thead>
        <tr>
            <td><b> User's id </b></td>
            <td><b> Login </b></td>
            <td><b> Role </b></td>
            <td><b> E-mail </b></td>
            <td><b> Phone </b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty usersList}">
                <c:forEach items="${usersList}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.login}</td>
                        <td>${user.role}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5">Effective entries don't exist</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
