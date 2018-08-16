<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<form action="/financial_analysis_execute" method="POST">
    Last period:
    <br/><input type="radio" name="per" value="year"/> year
    <br/><input type="radio" name="per" value="all_time"/> all time
    <br/>
    Periodicity:
    <br/><input type="radio" name="periodicity" value="1_month"/> 1 month
    <br/><input type="radio" name="periodicity" value="3_months"/> 3 months
    <br/><input type="radio" name="periodicity" value="6_months"/> 6 months
    <br/><input type="radio" name="periodicity" value="year"/> year

    <br/><input type="submit"/>
</form>

<p><a href="/data_getting">Previously menu</a></p>

<p><a href="/">Main menu</a></p>

</body>
</html>
