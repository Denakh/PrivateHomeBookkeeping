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

<div class="tables-fw celist">
    <h2 class="h2-al"> Current expenses list </h2>
    <table border="1" class="h2-al">
        <thead>
        <tr>
            <td><b>Month number</b></td>
            <td><b>Estimated amount</b></td>
            <td><b>Standard amount</b></td>
            <td><b>Difference</b></td>
            <td><b>Entry date</b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty curExpEntityList}">
                <c:forEach items="${curExpEntityList}" var="curexp">
                    <tr>
                        <td>${curexp.month}</td>
                        <td><fmt:formatNumber value="${curexp.estimatedAmount}" pattern="###.00"
                                              minIntegerDigits="1"/></td>
                        <td><fmt:formatNumber value="${curexp.standardAmount}" pattern="###.00"
                                              minIntegerDigits="1"/></td>
                        <td><fmt:formatNumber value="${curexp.difference}" pattern="###.00" minIntegerDigits="1"/></td>
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
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
