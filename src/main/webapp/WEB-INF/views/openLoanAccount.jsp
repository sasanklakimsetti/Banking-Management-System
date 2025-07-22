<!DOCTYPE html>
<html>
<head>
  <title>Open Loan Account</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-5">
<h2 class="mb-4">Apply for Loan</h2>
<form action="${pageContext.request.contextPath}/loan/create" method="post" class="row g-3">
  <input type="hidden" name="customerId" value="${customerId}" />
  <div class="col-md-6">
    <label class="form-label">Loan Amount</label>
    <input type="number" name="amount" class="form-control" required />
  </div>
  <div class="col-md-6">
    <label class="form-label">Term (months)</label>
    <input type="number" name="term" class="form-control" required />
  </div>
  <div class="col-12">
    <button type="submit" class="btn btn-warning">Apply</button>
  </div>
</form>
</body>
</html>
