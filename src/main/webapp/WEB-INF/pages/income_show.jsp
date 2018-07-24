<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<h2> Incomes list </h2>
<table border="1">
    <thead>
    <tr>
        <td><b>Amount</b></td>
        <td><b>Entry date</b></td>
        <td><b>Purpose</b></td>
        <td><b>Description</b></td>
    </tr>
    </thead>
    <c:choose>
        <c:when test="${not empty incomeEntityList}">
            <c:forEach items="${incomeEntityList}" var="income">
                <tr>
                    <td>${income.amount}</td>
                    <td>${income.date}</td>
                    <td>${income.purpose}</td>
                    <td>${income.description}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="4">Effective income entries don't exist</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<h2><p><a href="/">Main menu</a></p></h2>

</body>
</html>
