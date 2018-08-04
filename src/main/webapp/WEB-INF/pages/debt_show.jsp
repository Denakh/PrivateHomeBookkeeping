<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<h2> Debts list </h2>
<table border="1">
    <thead>
    <tr>
        <td><b>Debt id</b></td>
        <td><b>Initial amount</b></td>
        <td><b>Entry date</b></td>
        <td><b>Description</b></td>
        <td><b>Percent</b></td>
        <td><b>Percent for initial (true)
            or remaining amount</b></td>
        <td><b>Remaining sum</b></td>
        <td><b>Debt id for change (if need)</b></td>
    </tr>
    </thead>
    <c:choose>
        <c:when test="${not empty debtEntityList}">
            <c:forEach items="${debtEntityList}" var="debt">
                <tr>
                    <td>${debt.id}</td>
                    <td>${debt.amount}</td>
                    <td>${debt.date}</td>
                    <td>${debt.description}</td>
                    <td>${debt.percent}</td>
                    <td>${debt.percentForInitialAm}</td>
                    <td>${debt.remainingSum}</td>
                    <td>${debt.idDebtForChange}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="7">Effective debt entries don't exist</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<h2><p><a href="/">Main menu</a></p></h2>

</body>
</html>
