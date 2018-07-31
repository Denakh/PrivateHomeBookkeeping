<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<h2> Main expenses list for ${expEntityName} </h2>
<table border="1">
    <thead>
    <tr>
        <td><b>Amount change</b></td>
        <td><b>Entry date</b></td>
        <td><b>Description</b></td>
        <td><b>Amount</b></td>
    </tr>
    </thead>
    <c:choose>
        <c:when test="${not empty expEntityList}">
            <c:forEach items="${expEntityList}" var="expEntity">
                <tr>
                    <td>${expEntity.amountChange}</td>
                    <td>${expEntity.date}</td>
                    <td>${expEntity.description}</td>
                    <td>${expEntity.amount}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="4">Effective entries don't exist</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<h2><p><a href="/">Main menu</a></p></h2>

</body>
</html>
