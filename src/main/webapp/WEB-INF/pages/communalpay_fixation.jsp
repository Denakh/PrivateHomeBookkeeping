<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<form action="/communalpay_fixation_execute" method="POST">
    Amount, hrn: <input type="text" name="amount"><br>
    Description: <input type="text" name="description"><br>

    <br/><input type="submit"/>
</form>


Show communal pay statistic:
<form action="/communalpay_statistic_show" method="POST">
    Periodicity:
    <br/><input type="radio" name="periodicity" value="1_month"/> 1 month
    <br/><input type="radio" name="periodicity" value="2_months"/> 2 months
    <br/><input type="radio" name="periodicity" value="3_months"/> 3 months
    <br/><input type="radio" name="periodicity" value="4_months"/> 4 months
    <br/><input type="radio" name="periodicity" value="5_months"/> 5 months
    <br/><input type="radio" name="periodicity" value="6_months"/> 6 months
    <br/><input type="radio" name="periodicity" value="year"/> year
    <br/><input type="radio" name="periodicity" value="all_time"/> all time

    <br/><input type="submit"/>
</form>


<p><a href="/">Main menu</a></p>

</body>
</html>
