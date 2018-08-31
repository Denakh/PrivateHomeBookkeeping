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

<div class="tables-fw incsht_l">
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
                        <td><fmt:formatNumber value="${income.amount}" pattern="###.00"/></td>
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
</div>

<div class="tables-fw incsht_r">
    <h2> General purpose incomes list </h2>
    <table border="1" class="h2-al">
        <thead>
        <tr>
            <td><b>Amount</b></td>
            <td><b>Entry date</b></td>
            <td><b>Current expenses month number</b></td>
            <td><b>Accumulation for current expenses</b></td>
            <td><b>Current expenses rate excess(for allocation)</b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty gIncomeEntityList}">
                <c:forEach items="${gIncomeEntityList}" var="gincome">
                    <tr>
                        <td>${gincome.amount} <fmt:formatNumber value="${gincome.amount}" pattern="###.00"/></td>
                        <td>${gincome.date}</td>
                        <td>${gincome.monthNumber}</td>
                        <td>${gincome.accumulation} <fmt:formatNumber value="${gincome.accumulation}" pattern="###.00"/></td>
                        <td>${gincome.excessForAllocation} <fmt:formatNumber value="${gincome.excessForAllocation}" pattern="###.00"/></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5">Effective income entries don't exist</td>
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
