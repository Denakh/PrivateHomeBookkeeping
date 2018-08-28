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

<form action="/current_exp_calculation_execute" method="POST">
    <h3>
        <div class="new_data_fw">
            Total factual amount available, hrn: <input type="text" name="amount"><br>
            <br/><input type="submit"/>
        </div>
    </h3>

</form>


<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
