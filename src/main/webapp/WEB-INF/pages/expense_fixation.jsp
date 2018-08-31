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

<div class="new_data efe">
    <h2> Expense fixation </h2>
    <form action="/expense_fixation_execute" method="POST">
        Amount change: <input type="text" name="amount_change"><br>
        <br/>Description : <input type="text" name="description"><br>
        <h3>Expanse type:</h3>
        <input type="radio" name="purpose" value="charity"/> charity
        <br/><input type="radio" name="purpose" value="health"/> health
        <br/><input type="radio" name="purpose" value="kids_and_pets"/> kids and pats
        <br/><input type="radio" name="purpose" value="other_capoutlays"/> other capital outlays
        <br/><input type="radio" name="purpose" value="recreation"/> recreation
        <br/><input type="radio" name="purpose" value="reserve"/> reserve

        <br/><input type="submit"/>
    </form>
</div>

<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
