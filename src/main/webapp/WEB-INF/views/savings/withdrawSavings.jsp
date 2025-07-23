<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Withdraw from Savings Account</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
  <script>
    window.onload = function () {
      const accountNumber = "<%= request.getAttribute("accountNumber") %>";
      const customerId = "<%= request.getAttribute("customerId") %>";

      document.getElementById("accountNumber").value = accountNumber;
      document.getElementById("customerId").value = customerId;
    }
  </script>
</head>
<body class="container mt-5">
<h2>Withdraw from Savings Account</h2>
<form action="${pageContext.request.contextPath}/savings_account/withdraw" method="post">
  <input type="hidden" name="accountNumber" id="accountNumber" />
  <input type="hidden" name="customerId" id="customerId" />

  <div class="mb-3">
    <label for="amount" class="form-label">Amount</label>
    <input type="number" class="form-control" name="amount" id="amount" required />
  </div>

  <button type="submit" class="btn btn-danger">Withdraw</button>
</form>
</body>
</html>
