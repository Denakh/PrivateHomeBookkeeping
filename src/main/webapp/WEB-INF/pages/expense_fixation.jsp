<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<form action="/expense_fixation_execute" method="POST">
    Amount change, hrn: <input type="text" name="amount_change"><br>
    Description: <input type="text" name="description"><br>
    Expanse type:
    <br/><input type="radio" name="purpose" value="charity" /> charity
    <br/><input type="radio" name="purpose" value="health" /> health
    <br/><input type="radio" name="purpose" value="kids_and_pets" /> kids and pats
    <br/><input type="radio" name="purpose" value="other_capoutlays" /> other capital outlays
    <br/><input type="radio" name="purpose" value="recreation" /> recreation
    <br/><input type="radio" name="purpose" value="reserve" /> reserve

    <br/><input type="submit" />
</form>

<p><a href="/">Main menu</a></p>

</body>
</html>