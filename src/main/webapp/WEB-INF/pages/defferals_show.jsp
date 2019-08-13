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

<div class="tables-fw fae mel">
    <h2> Deferral statistic </h2>
    <table border="1">
        <thead>
        <tr>
            <td><b>Amount, HRN</b></td>
            <td><b>Entry date</b></td>
            <td><b>Source</b></td>
            <td><b>Description</b></td>
            <td><b>Period from date in descr.</b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty deferralsEntityList}">
                <c:forEach items="${deferralsEntityList}" var="deferralsEntity">
                    <tr>
                        <td><fmt:formatNumber value="${deferralsEntity.amount}" pattern="###.00"
                                              minIntegerDigits="1"/></td>
                        <td>${deferralsEntity.date}</td>
                        <td>${deferralsEntity.source}</td>
                        <td>${deferralsEntity.description}</td>
                        <td>${deferralsEntity.period}</td>
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
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>