<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Withdrawal Successful</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-5">
<div class="alert alert-success">
  <h4>Withdrawal Successful</h4>
  <p><strong>Account Number:</strong> ${accountNumber}</p>
  <p><strong>Withdrawn Amount:</strong> ₹${payoutAmount}</p>
  <p><strong>Status:</strong> ${isPremature ? "Premature Withdrawal" : "Matured Withdrawal"}</p>
</div>
<a href="/customer/profile" class="btn btn-primary">Back to Profile</a>
</body>
</html>
