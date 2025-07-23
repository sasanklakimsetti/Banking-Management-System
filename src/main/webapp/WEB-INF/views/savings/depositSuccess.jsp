<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Long accountNumber = (Long) request.getAttribute("accountNumber");
  Integer amount = (Integer) request.getAttribute("amount");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Deposit Success</title>
</head>
<body>
<h2>Deposit Successful!</h2>
<p>Account #: <%= accountNumber %></p>
<p>Amount Deposited: ₹<%= amount %></p>
<a href="<%= request.getContextPath() %>/savings-actions/<%= accountNumber %>">Go Back</a>
</body>
</html>
