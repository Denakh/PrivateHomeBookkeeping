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
<h3>
    <div class="head">
        Your login is: ${login}, your roles are:
        <c:forEach var="s" items="${roles}">
            <c:out value="${s}"/>
        </c:forEach>

        <c:url value="/update" var="updateUrl"/>
        <form action="${updateUrl}" method="POST">
            E-mail:<br/><input type="text" name="email" value="${email}"/><br/>
            Phone:<br/><input type="text" name="phone" value="${phone}"/><br/>
            <input type="submit" value="Update"/>
        </form>

        <c:url value="/logout" var="logoutUrl"/>
        <p>Click to logout: <a href="${logoutUrl}">Logout</a></p>
    </div>
</h3>
<div class="alerts">
    <h2 class="h2-al">Notifications:</h2>
    <c:choose>
        <c:when test="${notification ne null}">
            <h3 class="h2-al">${notification}</h3>
        </c:when>
        <c:otherwise>
            <h3 class="h2-al">No special notifications</h3>
        </c:otherwise>
    </c:choose>
</div>
<h3>
</h3>
<div class="alerts">
    <h2 class="h2-al">Alerts</h2>
    <h3 class="h2-al">(executing order top-down has to be kept):</h3>
    <c:if test="${need_alloc_of_prof == false && need_cur_exp_rate == false && need_cur_exp_renew == false}">
        <h3 class="h2-al">No alerts!</h3>
    </c:if>
    <c:if test="${need_alloc_of_prof == true}">
        <p class="p1">You have to setup allocation of profits (excess over current expanses cover)
            rates for correct application operations, please click on reference at the next line:</p>
        <h3><p><a href="/allocation_of_profits">Setup allocation of profits</a></p></h3>
    </c:if>
    <br/>
    <c:if test="${need_cur_exp_rate == true}">
        <p class="p1">You have to setup current expanses monthly rates for correct application operations,
            please click on reference at the next line:</p>
        <h3><p><a href="/current_expenses_rate">Setup current expanses monthly rates</a></p></h3>
    </c:if>
    <br/>
    <c:if test="${need_cur_exp_renew == true}">
        <p class="p1">You have to update(calculate) current expanses amount for last month and
            debt data with percents(interests on loans) accounting (if exist), please click on reference at the next
            line:</p>
        <h3><p><a href="/current_exp_calculation">Monthly data calculation</a></p></h3>
    </c:if>
</div>
<h3>
    <div class="hrefs">
        <p class="op-h">Your operations</p>
        <p><a href="/income_fixation">Income fixation</a></p>
        <p><a href="/expense_fixation">Expense fixation (not current)</a></p>
        <p><a href="/debt_fixation">Debt fixation (in or out)</a></p>
        <p><a href="/deferral_fixation">Deferrals (expenses) fixation</a></p>
        <p><a href="/communal_pays_fixation">Communal pays fixation</a></p>
        <p><a href="/data_getting">Main data getting</a></p>
        <p><a href="/current_expenses_rate">Current expenses rate</a></p>
        <p><a href="/foreign_currencies">Foreign currencies operations</a></p>
        <p><a href="/allocation_of_profits">Allocation of profits</a></p>
    </div>
</h3>
<div class="hrefs2">
    <p class="p1">!Only for users with admin roles!</p>
    <h3><p><a href="/get_users_jsp">Get users list</a></p></h3>
</div>
</body>
</html>
