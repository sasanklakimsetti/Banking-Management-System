<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Pay EMI</title></head>
<body>
<h2>Pay EMI</h2>
<form method="post" action="${pageContext.request.contextPath}/loan_account/pay_emi">
  <input type="hidden" name="accountNumber" value="${accountNumber}" />
  <label>Amount: <input type="number" name="amount" required /></label><br/>
  <button type="submit">Pay EMI</button>
</form>
</body>
</html>
