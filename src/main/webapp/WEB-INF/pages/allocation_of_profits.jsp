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

<div class="tables">
    <h2> Current percent(%) for allocation of profits </h2>
    <table border="1">
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
            <c:when test="${allocationOfProfits ne null}">
                <tr>
                    <td>${allocationOfProfits.charityPercent}</td>
                    <td>${allocationOfProfits.healthPercent}</td>
                    <td>${allocationOfProfits.kidsAndPetsPercent}</td>
                    <td>${allocationOfProfits.recreationPercent}</td>
                    <td>${allocationOfProfits.reservePercent}</td>
                    <td>${allocationOfProfits.otherCapOutLaysPercent}</td>
                    <td>${allocationOfProfits.date}</td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="7">Effective allocation of profits values entry don't exist</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>

<div class="new_data">
    <h2> New allocation of profits values </h2>
    <form action="/allocation_of_profits_execute" method="POST">
        Percent for charity: <input type="text" name="charity_percent"><br>
        Percent for health: <input type="text" name="health_percent"><br>
        Percent for kids and pets: <input type="text" name="kids_and_pets_percent"><br>
        Percent for recreation: <input type="text" name="recreation_percent"><br>
        Percent for reserve: <input type="text" name="reserve_percent"><br>
        Percent for other capoutlays: <input type="text" name="other_capoutlays_percent"><br>

        <br/><input type="submit"/>
    </form>
</div>

<div class="hrefs4">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
