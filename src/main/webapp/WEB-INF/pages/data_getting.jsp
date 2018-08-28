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

<form action="/data_getting_execute" method="POST">
    Expense item:
    <br/><input type="radio" name="purpose" value="charity"/> charity
    <br/><input type="radio" name="purpose" value="health"/> health
    <br/><input type="radio" name="purpose" value="kids_and_pets"/> kids and pats
    <br/><input type="radio" name="purpose" value="other_capoutlays"/> other capital outlays
    <br/><input type="radio" name="purpose" value="recreation"/> recreation
    <br/><input type="radio" name="purpose" value="reserve"/> reserve
    <br>
    Last period:
    <br/><input type="radio" name="per" value="1_month"/> 1 month
    <br/><input type="radio" name="per" value="2_months"/> 2 months
    <br/><input type="radio" name="per" value="3_months"/> 3 months
    <br/><input type="radio" name="per" value="4_months"/> 4 months
    <br/><input type="radio" name="per" value="5_months"/> 5 months
    <br/><input type="radio" name="per" value="6_months"/> 6 months
    <br/><input type="radio" name="per" value="year"/> year
    <br/><input type="radio" name="per" value="all_time"/> all time

    <br/><input type="submit"/>
</form>

<form action="/ce_data_getting_execute" method="POST">
    Current expenses for per:
    <br/><input type="radio" name="per" value="3_months"/> 3 months
    <br/><input type="radio" name="per" value="6_months"/> 6 months
    <br/><input type="radio" name="per" value="year"/> year
    <br/><input type="radio" name="per" value="all_time"/> all time

    <br/><input type="submit"/>
</form>

<p><a href="/financial_analysis">Financial analysis</a></p>


<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
