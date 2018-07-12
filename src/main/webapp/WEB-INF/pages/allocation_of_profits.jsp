<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<h2> Current percent(%) for allocation of profits </h2>
<table border="1" class="table table-striped">
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
    <tr>
        <td>${allocationOfProfits.charityPercent}</td>
        <td>${allocationOfProfits.healthPercent}</td>
        <td>${allocationOfProfits.kidsAndPetsPercent}</td>
        <td>${allocationOfProfits.recreationPercent}</td>
        <td>${allocationOfProfits.reservePercent}</td>
        <td>${allocationOfProfits.otherCapOutLaysPercent}</td>
        <td>${allocationOfProfits.date}</td>
    </tr>
</table>


<h2> New allocation of profits values </h2>
<form action="/allocation_of_profits_execute" method="POST">
    Percent for charity: <input type="text" name="charity_percent"><br>
    Percent for health: <input type="text" name="health_percent"><br>
    Percent for kids_and_pets: <input type="text" name="kids_and_pets_percent"><br>
    Percent for recreation: <input type="text" name="recreation_percent"><br>
    Percent for reserve: <input type="text" name="reserve_percent"><br>
    Percent for other_capoutlays: <input type="text" name="other_capoutlays_percent"><br>

    <br/><input type="submit" />
</form>

<h2> <p><a href="/">Main menu</a></p> </h2>

</body>
</html>
