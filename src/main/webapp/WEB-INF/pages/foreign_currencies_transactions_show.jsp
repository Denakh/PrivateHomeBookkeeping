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

<div class="tables-fw cps_table">
    <h2> Foreign currencies transactions list </h2>
    <table border="1">
        <thead>
        <tr>
            <td><b>Currency</b></td>
            <td><b>Operation name</b></td>
            <td><b>Amount change</b></td>
            <td><b>New amount</b></td>
            <td><b>Exchange rate</b></td>
            <td><b>Entry date</b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty foreignCurrenciesTransactionsList}">
                <c:forEach items="${foreignCurrenciesTransactionsList}" var="foreignCurrenciesTransaction">
                    <tr>
                        <td>${foreignCurrenciesTransaction.currency}</td>
                        <td>${foreignCurrenciesTransaction.operationName}</td>
                        <td><fmt:formatNumber value="${foreignCurrenciesTransaction.amountChangeDuringOperation}" pattern="###.00" minIntegerDigits="1"/></td>
                        <td><fmt:formatNumber value="${foreignCurrenciesTransaction.newAmount}" pattern="###.00" minIntegerDigits="1"/></td>
                        <td><fmt:formatNumber value="${foreignCurrenciesTransaction.operationExchangeRate}" pattern="###.00" minIntegerDigits="1"/></td>
                        <td>${foreignCurrenciesTransaction.date}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="6">Effective income entries don't exist</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>

<div class="hrefs3 dget2">
    <h3><p><a href="/foreign_currencies">Previous menu</a></p></h3>
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
