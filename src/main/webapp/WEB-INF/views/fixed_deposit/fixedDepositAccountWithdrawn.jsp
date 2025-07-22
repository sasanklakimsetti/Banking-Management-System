<html>
<head>
  <title>Fixed Deposit Withdrawn</title>
</head>
<body>
<h2>Withdrawal Successful</h2>

<c:choose>
  <c:when test="${isPremature}">
    <p>This was a <strong>premature withdrawal</strong>.</p>
  </c:when>
  <c:otherwise>
    <p>This was a <strong>matured withdrawal</strong>.</p>
  </c:otherwise>
</c:choose>

<p><strong>Amount Received:</strong> ₹${payoutAmount}</p>

<a href="/customer/dashboard">Back to Dashboard</a>
</body>
</html>
