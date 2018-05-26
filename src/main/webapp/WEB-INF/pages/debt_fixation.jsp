<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<form action="/debt_fixation_execute" method="POST">
    Amount, hrn: <input type="text" name="amountchange"><br>
    Description: <input type="text" name="description"><br>
    Percent: <input type="text" name="percent"><br>
    Percent for:
    <br/><input type="radio" name="purpose" value="initialamount" /> initial amount
    <br/><input type="radio" name="purpose" value="residualamount" /> residual amount

    <br/><input type="submit" />
</form>

<p><a href="/">Main menu</a></p>

</body>
</html>
