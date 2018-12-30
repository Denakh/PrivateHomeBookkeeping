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

<div align="center">

    <div class="tables-fw celist">
        <h2 class="h2-al"> Current expenses list </h2>
        <table border="1" class="h2-al">
            <thead>
            <tr>
                <td><b>Currency</b></td>
                <td><b>Amount</b></td>
            </tr>
            </thead>
            <c:choose>
                <c:when test="${not empty foreignCurrenciesList}">
                    <c:forEach items="${foreignCurrenciesList}" var="foreignCurrency">
                        <tr>
                            <td>${foreignCurrency.currency}</td>
                            <td><fmt:formatNumber value="${foreignCurrency.amount}" pattern="###.00"
                                                  minIntegerDigits="1"/></td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="2">There is no amount in foreign currencies</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            <tr>
                <td colspan="2">Current currencies rate: USD(bid, ask): ${USDBidRate}, ${USDAskRate};
                    EUR(bid, ask):${EURBidRate}, ${EURAskRate};</td>
            </tr>
        </table>
    </div>

    <div class="hrefs3">
        <h3><p><a href="/">Main menu</a></p></h3>
    </div>
</div>

<form action="/foreign_currencies_execute" method="POST">
    Currency:
    <br/><input type="radio" name="currency" value="usd"/> USD
    <br/><input type="radio" name="currency" value="eur"/> EUR
    <br>
    Operation type:
    <br/><input type="radio" name="type" value="buying"/> buying
    <br/><input type="radio" name="type" value="selling"/> selling
    <br/><input type="radio" name="type" value="income"/> income
    <br/><input type="radio" name="type" value="expenditure"/> expenditure
    <br>
    Amount: <input type="text" name="amount"><br>
    Exchange rate hrn/currency: <input type="text" name="exchange_rate"><br>

    Additional information for income or expenditure:
    Description: <input type="text" name="description"><br>
    <h3>Purpose:</h3>
    <input type="radio" name="purpose" value="general"/> general
    <br/><input type="radio" name="purpose" value="charity"/> charity
    <br/><input type="radio" name="purpose" value="health"/> health
    <br/><input type="radio" name="purpose" value="kids_and_pets"/> kids and pats
    <br/><input type="radio" name="purpose" value="other_capoutlays"/> other capital outlays
    <br/><input type="radio" name="purpose" value="recreation"/> recreation
    <br/><input type="radio" name="purpose" value="reserve"/> reserve

    <br/><input type="submit"/>
</form>


Show exchange transactions statistic:
<form action="/exchange_transactions" method="POST">
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


<div class="hrefs3">
    <h3><p><a href="/">Main menu</a></p></h3>
</div>

</body>
</html>
