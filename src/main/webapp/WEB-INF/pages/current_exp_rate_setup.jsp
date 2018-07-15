<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<h2> Actual current expenses rate(%) for month number </h2>
<table border="1">
    <thead>
    <tr>
        <td><b>1</b></td>
        <td><b>2</b></td>
        <td><b>3</b></td>
        <td><b>4</b></td>
        <td><b>5</b></td>
        <td><b>6</b></td>
        <td><b>7</b></td>
        <td><b>8</b></td>
        <td><b>9</b></td>
        <td><b>10</b></td>
        <td><b>11</b></td>
        <td><b>12</b></td>
        <td><b>Adding date</b></td>
    </tr>
    </thead>
    <c:choose>
        <c:when test="${currentExpensesRate ne null}">
            <tr>
                <td>${currentExpensesRate.m1am}</td>
                <td>${currentExpensesRate.m2am}</td>
                <td>${currentExpensesRate.m3am}</td>
                <td>${currentExpensesRate.m4am}</td>
                <td>${currentExpensesRate.m5am}</td>
                <td>${currentExpensesRate.m6am}</td>
                <td>${currentExpensesRate.m7am}</td>
                <td>${currentExpensesRate.m8am}</td>
                <td>${currentExpensesRate.m9am}</td>
                <td>${currentExpensesRate.m10am}</td>
                <td>${currentExpensesRate.m11am}</td>
                <td>${currentExpensesRate.m12am}</td>
                <td>${currentExpensesRate.date}</td>
            </tr>
        </c:when>
        <c:otherwise>
            <tr>
                <td colspan="13">Effective current expenses rate entry doesn't exist</td>
            </tr>
        </c:otherwise>
    </c:choose>
</table>

<h2> New current expenses rate values </h2>
<form action="/current_expenses_rate_execute" method="POST">
    Percent for month 1: <input type="text" name="amount1"><br>
    Percent for month 2: <input type="text" name="amount2"><br>
    Percent for month 3: <input type="text" name="amount3"><br>
    Percent for month 4: <input type="text" name="amount4"><br>
    Percent for month 5: <input type="text" name="amount5"><br>
    Percent for month 6: <input type="text" name="amount6"><br>
    Percent for month 7: <input type="text" name="amount7"><br>
    Percent for month 8: <input type="text" name="amount8"><br>
    Percent for month 9: <input type="text" name="amount9"><br>
    Percent for month 10: <input type="text" name="amount10"><br>
    Percent for month 11: <input type="text" name="amount11"><br>
    Percent for month 12: <input type="text" name="amount12"><br>

    <br/><input type="submit"/>
</form>


<p><a href="/">Main menu</a></p>

</body>
</html>
