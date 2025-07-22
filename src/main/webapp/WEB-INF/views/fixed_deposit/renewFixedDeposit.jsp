<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Renew Fixed Deposit</title>
</head>
<body>
<h2>Renew Fixed Deposit Account</h2>

<form action="/fixed_deposit/renew_account" method="post">
    <!-- Hidden Account Number -->
    <input type="hidden" name="accountNumber" value="${accountNumber}" />

    <!-- New Duration -->
    <label for="newDuration">New Duration (Days):</label>
    <input type="number" id="newDuration" name="newDuration" required /><br/><br/>

    <button type="submit">Renew Account</button>
</form>
</body>
</html>
