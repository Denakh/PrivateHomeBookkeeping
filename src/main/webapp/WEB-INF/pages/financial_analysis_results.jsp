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

<div class="tables-fw fae">
    <h2> Main financial characteristics list </h2>
    <table border="1" class="h2-al">
        <thead>
        <tr>
            <td><b>Month number(from)</b></td>
            <td><b>Year(from)</b></td>
            <td><b>Month number(to)</b></td>
            <td><b>Year(to)</b></td>
            <td><b>Total income</b></td>
            <td><b>Total expenses</b></td>
            <td><b>Current expenses</b></td>
            <td><b>Cur.expenses fact.and rate dif.</b></td>
            <td><b>Passive debts</b></td>
            <td><b>Overall balance with deposits</b></td>
            <td><b>Expenses to incomes ratio</b></td>
            <td><b>Cur.expenses cover by incomes</b></td>
            <td><b>Pass.debts to ov.bal. ratio</b></td>
            <td><b>Financial condition</b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty mfsListEf}">
                <c:forEach items="${mfsListEf}" var="mfs">
                    <tr>
                        <td>${mfs.month}</td>
                        <td>${mfs.year}</td>
                        <td>${mfs.monthLast}</td>
                        <td>${mfs.yearLast}</td>
                        <td><fmt:formatNumber value="${mfs.totalIncome}" pattern="###.00"/></td>
                        <td><fmt:formatNumber value="${mfs.totalExpenses}" pattern="###.00"/></td>
                        <td><fmt:formatNumber value="${mfs.currentExpenses}" pattern="###.00"/></td>
                        <td><fmt:formatNumber value="${mfs.curExpFactStandDif}" pattern="###.00"/></td>
                        <td><fmt:formatNumber value="${mfs.passiveDebts}" pattern="###.00"/></td>
                        <td><fmt:formatNumber value="${mfs.overallBalanceWD}" pattern="###.00"/></td>
                        <td><fmt:formatNumber value="${mfs.expToIncRatio}" pattern="###.00"/></td>
                        <td><fmt:formatNumber value="${mfs.curExpensesCoverByIncome}" pattern="###.00"/></td>
                        <td><fmt:formatNumber value="${mfs.passDebtsToOBRatio}" pattern="###.00"/></td>
                        <td>${mfs.fcResult}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="14">Effective entries don't exist</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>

<div class="tables-fw fae">
    <h2> Current financial condition </h2>
    <table border="1" class="h2-al">
        <thead>
        <tr>
            <td><b>Overall last factual balance with deposits</b></td>
            <td><b>Overall current calculated balance with deposits</b></td>
            <td><b>Cur.expenses cover by incomes</b></td>
            <td><b>Expenses to incomes ratio</b></td>
            <td><b>Pass.debts to ov.bal. ratio</b></td>
            <td><b>Cur.expenses fact.and rate dif.(%)</b></td>
        </tr>
        </thead>
        <tr>
            <td><fmt:formatNumber value="${overallBalanceWDFLast}" pattern="###.00"/></td>
            <td><fmt:formatNumber value="${overallBalanceWDCLast}" pattern="###.00"/></td>
            <td><fmt:formatNumber value="${curExpensesCoverByIncome}" pattern="###.00"/></td>
            <td><fmt:formatNumber value="${expToIncRatio}" pattern="###.00"/></td>
            <td><fmt:formatNumber value="${passDebtsToOBRatio}" pattern="###.00"/></td>
            <td><fmt:formatNumber value="${relationalCEFactStandDif}" pattern="###.00"/></td>
        </tr>
        <tr>
            <td colspan="6"> Overall current financial condition: ${fcRes} </td>
        </tr>
        <tr>
            <td> Recommendations:</td>
            <td colspan="5"> ${advices} </td>
        </tr>
    </table>
</div>

<div class="hrefs3 dget2">
    <h3><p><a href="/financial_analysis">Previously menu</a></p></h3>
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>