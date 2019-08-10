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

<div class="tables-fw hap_history_table">
    <h2> History for allocation of profits (%)</h2>
    <table border="1" class="h2-al">
        <thead>
        <tr>
            <td><b>Charity</b></td>
            <td><b>Health</b></td>
            <td><b>Kids and pets</b></td>
            <td><b>Recreation</b></td>
            <td><b>Reserve</b></td>
            <td><b>Other capital outlays</b></td>
            <td><b>Adding date</b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty allocationOfProfitsList}">
                <c:forEach items="${allocationOfProfitsList}" var="allocation">
                    <tr>
                        <td>${allocation.charityPercent}</td>
                        <td>${allocation.healthPercent}</td>
                        <td>${allocation.kidsAndPetsPercent}</td>
                        <td>${allocation.recreationPercent}</td>
                        <td>${allocation.reservePercent}</td>
                        <td>${allocation.otherCapOutLaysPercent}</td>
                        <td>${allocation.date}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="7">Effective allocation of profits values entries don't exist</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>

<div class="hrefs3 dget2">
    <h3><p><a href="/allocation_of_profits">Previous menu</a></p></h3>
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>

