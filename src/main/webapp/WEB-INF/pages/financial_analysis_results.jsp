<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>


private byte month;
private int year;
private double totalIncome;
private double totalExpenses;
private double expToIncRatio;
private double currentExpenses;
private double curExpensesCoverByIncome;
private double passiveDebts;
private double overallBalanceWD;
private double passDebtsToOBRatio;
private double curExpFactStandDif;

@Enumerated(EnumType.STRING)
private FinancialCondition fcByCurExpCover;
@Enumerated(EnumType.STRING)
private FinancialCondition fcByDebtsToOBRatio;

private byte monthLast;
private int yearLast;


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
        <c:when test="${not empty curExpEntityList}">
            <c:forEach items="${curExpEntityList}" var="curexp">
                <tr>
                    <td>${curexp.month}</td>
                    <td>${curexp.estimatedAmount}</td>
                    <td>${curexp.standardAmount}</td>
                    <td>${curexp.difference}</td>
                    <td>${curexp.date}</td>
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

<h2><p><a href="/">Main menu</a></p></h2>

</body>
</html>