<!DOCTYPE html>
<html>
<head>
    <title>Create Savings Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-5">
<h2 class="mb-4">Open Savings Account</h2>
<form action="${pageContext.request.contextPath}/savings/create" method="post" class="row g-3">
    <input type="hidden" name="customerId" value="${customerId}" />
    <div class="col-md-6">
        <label class="form-label">Initial Deposit</label>
        <input type="number" name="initialDeposit" class="form-control" required />
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-success">Open Account</button>
    </div>
</form>
</body>
</html>
