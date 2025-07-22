<!DOCTYPE html>
<html>
<head>
  <title>Savings Account Actions</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-5">
<h2 class="mb-4">Deposit or Withdraw</h2>
<form action="${pageContext.request.contextPath}/savings/transaction" method="post" class="row g-3">
  <input type="hidden" name="accountNumber" value="${accountNumber}" />
  <div class="col-md-6">
    <label class="form-label">Amount</label>
    <input type="number" name="amount" class="form-control" required />
  </div>
  <div class="col-md-6">
    <label class="form-label">Action</label>
    <select name="action" class="form-select">
      <option value="deposit">Deposit</option>
      <option value="withdraw">Withdraw</option>
    </select>
  </div>
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>
</body>
</html>
