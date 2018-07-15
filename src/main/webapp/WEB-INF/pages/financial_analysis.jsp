<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<form action="/financial_analysis_execute" method="POST">
    Financial analysis type:
    <br/><input type="radio" name="purpose" value="gen_fin_condition"/> general finance condition
    <br/><input type="radio" name="purpose" value="gen_balance"/> general balance
    <br/><input type="radio" name="purpose" value="total_debt"/> total debt
    <br/><input type="radio" name="purpose" value="deferrals"/> deferrals
    <br/><input type="radio" name="purpose" value="total_income"/> total income
    <br/><input type="radio" name="purpose" value="total_expenses"/> total expenses
    <br/><input type="radio" name="purpose" value="total_cur_expenses"/> total current expenses
    <br/><input type="radio" name="purpose" value="rel_fin_indexes"/> relative finance indexes
    <br>
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


<p><a href="/data_getting">Previously menu</a></p>

<p><a href="/">Main menu</a></p>

</body>
</html>
