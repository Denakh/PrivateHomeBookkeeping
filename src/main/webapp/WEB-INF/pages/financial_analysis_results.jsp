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

<h2> Main financial characteristics list </h2>
<table border="1">
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
                    <td>${mfs.totalIncome}</td>
                    <td>${mfs.totalExpenses}</td>
                    <td>${mfs.currentExpenses}</td>
                    <td>${mfs.curExpFactStandDif}</td>
                    <td>${mfs.passiveDebts}</td>
                    <td>${mfs.overallBalanceWD}</td>
                    <td>${mfs.expToIncRatio}</td>
                    <td>${mfs.curExpensesCoverByIncome}</td>
                    <td>${mfs.passDebtsToOBRatio}</td>
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

<h2> Current financial condition </h2>
<table border="1">
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
        <td>${overallBalanceWDFLast}</td>
        <td>${overallBalanceWDCLast}</td>
        <td>${curExpensesCoverByIncome}</td>
        <td>${expToIncRatio}</td>
        <td>${passDebtsToOBRatio}</td>
        <td>${relationalCEFactStandDif}</td>
    </tr>
    <tr>
        <td colspan="6"> Overall current financial condition: ${fcRes} </td>
    </tr>
    <tr>
        <td> Recommendations:</td>
        <td colspan="5"> ${advices} </td>
    </tr>
</table>

<p><a href="/financial_analysis">Previously menu</a></p>

<h2><p><a href="/">Main menu</a></p></h2>

</body>
</html>