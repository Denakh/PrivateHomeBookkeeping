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

<div class="new_data finan">
    <h2> Get financial analysis results </h2>
    <form action="/financial_analysis_execute" method="POST">
        <h3> Last period: </h3>
        <input type="radio" name="per" value="year"/> year
        <br/><input type="radio" name="per" value="all_time"/> all time
        <br/>
        <h3> Periodicity: </h3>
        <input type="radio" name="periodicity" value="1_month"/> 1 month
        <br/><input type="radio" name="periodicity" value="3_months"/> 3 months
        <br/><input type="radio" name="periodicity" value="6_months"/> 6 months
        <br/><input type="radio" name="periodicity" value="year"/> year

        <br/><input type="submit"/>
    </form>
</div>

<div class="hrefs3 dget">
    <h3><p><a href="/data_getting">Previous menu</a></p></h3>
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
