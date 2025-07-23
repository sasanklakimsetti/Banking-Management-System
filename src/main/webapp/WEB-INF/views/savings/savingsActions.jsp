<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Savings Account Actions</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
  <script>
    window.onload = function () {
      const accountNumber = "<%= request.getAttribute("accountNumber") %>";
      const message = "<%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>";

      document.getElementById("status-message").innerText = message;
      document.getElementById("accountNumberInput").value = accountNumber;
    }
  </script>
</head>
<body class="container mt-5">
<h2>Savings Account Actions</h2>
<p id="status-message" class="text-success"></p>

<form action="${pageContext.request.contextPath}/savings_account/deposit" method="post" class="mb-4">
  <input type="hidden" name="accountNumber" id="accountNumberInput"/>
  <div class="mb-3">
    <label for="depositAmount" class="form-label">Deposit Amount</label>
    <input type="number" name="amount" id="depositAmount" class="form-control" required/>
  </div>
  <button type="submit" class="btn btn-success">Deposit</button>
</form>

<form action="${pageContext.request.contextPath}/savings_account/withdraw" method="post">
  <input type="hidden" name="accountNumber" value="<%= request.getAttribute("accountNumber") %>"/>
  <div class="mb-3">
    <label for="withdrawAmount" class="form-label">Withdraw Amount</label>
    <input type="number" name="amount" id="withdrawAmount" class="form-control" required/>
  </div>
  <button type="submit" class="btn btn-danger">Withdraw</button>
</form>
</body>
</html>
