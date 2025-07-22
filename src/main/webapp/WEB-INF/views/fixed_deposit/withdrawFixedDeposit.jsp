<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Withdraw Fixed Deposit</title>
</head>
<body>
<h2>Withdraw Fixed Deposit</h2>

<form id="withdrawForm" action="${pageContext.request.contextPath}/fixed_deposit/withdraw" method="post">
  <input type="hidden" name="accountNumber" value="${accountNumber}" />
  <button type="submit" class="btn btn-danger">Withdraw</button>
</form>

</body>
</html>
