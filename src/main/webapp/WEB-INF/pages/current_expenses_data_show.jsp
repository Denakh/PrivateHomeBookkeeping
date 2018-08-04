<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<h2> Current expenses list </h2>
<table border="1">
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
