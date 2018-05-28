<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Private Home Bookkeeping</title>
</head>
<body>

<form action="/allocation_of_profits_execute" method="POST">
    Percent for charity: <input type="text" name="charity_percent"><br>
    Percent for health: <input type="text" name="health_percent"><br>
    Percent for kids_and_pets: <input type="text" name="kids_and_pets_percent"><br>
    Percent for other_capoutlays: <input type="text" name="other_capoutlays_percent"><br>
    Percent for recreation: <input type="text" name="recreation_percent"><br>
    Percent for reserve: <input type="text" name="reserve_percent"><br>

    <br/><input type="submit" />
</form>

<p><a href="/">Main menu</a></p>

</body>
</html>
