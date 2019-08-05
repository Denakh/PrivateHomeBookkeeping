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
    <h2 class="h2-al"> Communal pay statistic </h2>
    <table border="1" class="h2-al">
        <thead>
        <tr>
            <td><b>Amount, HRN</b></td>
            <td><b>Description</b></td>
            <td><b>Entry date</b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty communalPayStatisticEntityList}">
                <c:forEach items="${communalPayStatisticEntityList}" var="communalPay">
                    <tr>
                        <td><fmt:formatNumber value="${communalPay.amount}" pattern="###.00" minIntegerDigits="1"/></td>
                        <td>${communalPay.description}</td>
                        <td>${communalPay.date}</td>
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

<div class="hrefs3 dget2">
    <h3><p><a href="/communal_pays_fixation">Previous menu</a></p></h3>
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
