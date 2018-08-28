<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
    <style type="text/css">
        <%@include file="/WEB-INF/pages/styles/style.css"%>
    </style>
</head>
<body>

    <h3>
        <div class="new_data_fw">
            Total current expenses for previous month:
            <fmt:formatNumber value="${calculation_result}" pattern="###.00"/> hrn
        </div>
    </h3>

    <h3>
        <div class="new_data_fw">
            Difference between calculated total current expenses
            and standard rate for previous month: ${difference} hrn
        </div>
    </h3>

    <div class="hrefs3">
        <h3><p><a href="/">Main menu</a></p></h3>
    </div>

</body>
</html>

