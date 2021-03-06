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

<div class="new_data debt_fix height_3">
    <h2 class="h2-al"> Debt fixation or params changing </h2>
    <form action="/debt_fixation_execute" method="POST">
        Amount, HRN *: <input type="text" name="amount"><br>
        Description: <input type="text" name="description"><br>
        Percent *: <input type="text" name="percent"><br>
        Percent * for:
        <br/><input type="radio" name="purpose" value="initial_amount"/> initial amount
        <br/><input type="radio" name="purpose" value="residual_amount"/> residual amount
        <br>Existing debt Id for change *: <input type="text" name="id_for_change"><br>

        <p class="t-l">* For fixation of existing debt params changing (paying back, existing debt growth, percent
            params changing):</p>
        <ul class="t-l">
            <li> amount has to be with sign "-" for paying back;</li>
            <li> new percent params can be specified if it needs;</li>
            <li> id of existing debt in the list under has to be specified (for new debt fixation don't input any value
                in the line);
            </li>
        </ul>
        <input type="submit"/>
    </form>
</div>

<div class="tables debt_table">
    <h2 class="h2-al"> Effective debts list </h2>
    <table border="1" class="debts">
        <thead>
        <tr>
            <td><b>Debt id</b></td>
            <td><b>Initial amount, HRN</b></td>
            <td><b>Entry date</b></td>
            <td><b>Description</b></td>
            <td><b>Percent</b></td>
            <td><b>Percent for initial (true)
                or remaining amount</b></td>
            <td><b>Remaining sum, HRN</b></td>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty debts}">
                <c:forEach items="${debts}" var="debt">
                    <tr>
                        <td>${debt.id}</td>
                        <td><fmt:formatNumber value="${debt.amount}" pattern="###.00" minIntegerDigits="1"/></td>
                        <td>${debt.date}</td>
                        <td>${debt.description}</td>
                        <td>${debt.percent}</td>
                        <td>${debt.percentForInitialAm}</td>
                        <td><fmt:formatNumber value="${debt.remainingSum}" pattern="###.00" minIntegerDigits="1"/></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="7">Effective debt entries don't exist</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>

<div class="show_data_ds">
    <h2> Show debt statistic </h2>
    <form action="/debt_show" method="POST">
        <h3> Last period *: </h3>
        <input type="radio" name="per" value="1_month"/> 1 month
        <br/><input type="radio" name="per" value="2_months"/> 2 months
        <br/><input type="radio" name="per" value="3_months"/> 3 months
        <br/><input type="radio" name="per" value="4_months"/> 4 months
        <br/><input type="radio" name="per" value="5_months"/> 5 months
        <br/><input type="radio" name="per" value="6_months"/> 6 months
        <br/><input type="radio" name="per" value="year"/> year
        <br/><input type="radio" name="per" value="all_time"/> all time

        <br/><input type="submit"/>
    </form>
</div>

<div class="hrefs3 mmd">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
