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

<div class="hrefs3 ac_d">
    <h2>Access denied for ${login} (only for admin role users)!</h2>

    <h3><p><a href="/">Main menu</a></p></h3>

    <c:url value="/logout" var="logoutUrl"/>
    <h3><p>Click to logout: <a href="${logoutUrl}">Logout</a></p></h3>
</div>
</body>
</html>