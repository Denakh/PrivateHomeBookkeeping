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

<div class="tables-fw dfs">
    <h2 class="h2-al"> Debt full statistic </h2>
    <table border="1" class="h2-al">
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
                        <td><fmt:formatNumber value="${debt.amount}" pattern="###.00"/></td>
                        <td>${debt.date}</td>
                        <td>${debt.description}</td>
                        <td>${debt.percent}</td>
                        <td>${debt.percentForInitialAm}</td>
                        <td><fmt:formatNumber value="${debt.remainingSum}" pattern="###.00"/></td>
                        <td>${debt.idDebtForChange}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="8">Effective debt entries don't exist</td>
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
