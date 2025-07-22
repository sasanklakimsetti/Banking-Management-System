<!DOCTYPE html>
<html>
<head>
  <title>Pay Loan EMI</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-5">
<h2 class="mb-4">Pay EMI</h2>
<form action="${pageContext.request.contextPath}/loan/pay" method="post" class="row g-3">
  <input type="hidden" name="accountNumber" value="${accountNumber}" />
  <div class="col-md-6">
    <label class="form-label">EMI Amount</label>
    <input type="number" name="amount" class="form-control" required />
  </div>
  <div class="col-12">
    <button type="submit" class="btn btn-success">Pay</button>
  </div>
</form>
</body>
</html>
