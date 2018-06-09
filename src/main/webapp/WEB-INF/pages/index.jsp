<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>
    <div align="center">
        <h1>Your login is: ${login}, your roles are:</h1>
        <c:forEach var="s" items="${roles}">
            <h3><c:out value="${s}" /></h3>
        </c:forEach>

        <c:url value="/update" var="updateUrl" />
        <form action="${updateUrl}" method="POST">
            E-mail:<br/><input type="text" name="email" value="${email}" /><br/>
            Phone:<br/><input type="text" name="phone" value="${phone}" /><br/>
            <input type="submit" value="Update" />
        </form>

        <c:url value="/logout" var="logoutUrl" />
        <p>Click to logout: <a href="${logoutUrl}">LOGOUT</a></p>

        <p><a href="/income_fixation">Income fixation</a></p>
        <p><a href="/expense_fixation">Expense fixation (not current)</a></p>
        <p><a href="/debt_fixation">Debt fixation (in or out)</a></p>
        <p><a href="/deferral_fixation">Deferrals (expenses) fixation</a></p>
        <p><a href="/communal_pays_fixation">Communal pays fixation</a></p>
        <p><a href="/data_getting">Data getting</a></p>
        <p><a href="/current_expenses_rate">Current expenses rate</a></p>
        <p><a href="/foreign_currencies">Foreign currencies operations</a></p>
        <p><a href="/allocation_of_profits">Allocation of profits</a></p>

        <p><a href="/get_users">Get users list</a></p>

    </div>
</body>
</html>
