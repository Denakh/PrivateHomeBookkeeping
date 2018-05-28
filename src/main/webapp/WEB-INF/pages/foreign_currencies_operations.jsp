<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<form action="/foreign_currencies_execute" method="POST">
    Currency:
    <br/><input type="radio" name="currency" value="usd" /> USD
    <br/><input type="radio" name="currency" value="eur" /> EUR
    <br>
    Operation type:
    <br/><input type="radio" name="type" value="buying" /> buying
    <br/><input type="radio" name="type" value="selling" /> selling
    <br/><input type="radio" name="type" value="income" /> income
    <br/><input type="radio" name="type" value="expenditure" /> expenditure
    <br>
    Amount: <input type="text" name="amount"><br>
    Exchange rate hrn/currency: <input type="text" name="exchange_rate"><br>

    <br/><input type="submit" />
</form>

<p><a href="/">Main menu</a></p>

</body>
</html>
