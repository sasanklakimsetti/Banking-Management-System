<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Open Fixed Deposit</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-5">
<h2 class="mb-4">Open FD</h2>

<script>
  const customerId = "<%= request.getAttribute("customerId") %>";
  document.write("<p>Customer ID: <strong>" + customerId + "</strong></p>");
</script>

<form action="/fixed_deposit/create_account" method="post" class="row g-3">
  <input type="hidden" name="customerId" value="<%= request.getAttribute("customerId") %>" />

  <div class="col-md-6">
    <label class="form-label">Deposit Amount</label>
    <input type="number" name="depositAmount" class="form-control" required />
  </div>

  <div class="col-md-6">
    <label class="form-label">Duration (days)</label>
    <input type="number" name="duration" class="form-control" required />
  </div>

  <div class="col-12">
    <button type="submit" class="btn btn-info">Open FD</button>
  </div>
</form>
</body>
</html>
