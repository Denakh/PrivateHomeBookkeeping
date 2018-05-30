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


Show exchange transactions statistic:
<form action="/exchange_transactions" method="POST">
    Periodicity:
    <br/><input type="radio" name="periodicity" value="1_month" /> 1 month
    <br/><input type="radio" name="periodicity" value="2_months" /> 2 months
    <br/><input type="radio" name="periodicity" value="3_months" /> 3 months
    <br/><input type="radio" name="periodicity" value="4_months" /> 4 months
    <br/><input type="radio" name="periodicity" value="5_months" /> 5 months
    <br/><input type="radio" name="periodicity" value="6_months" /> 6 months
    <br/><input type="radio" name="periodicity" value="year" /> year
    <br/><input type="radio" name="periodicity" value="all_time" /> all time

    <br/><input type="submit" />
</form>


<p><a href="/">Main menu</a></p>

</body>
</html>
