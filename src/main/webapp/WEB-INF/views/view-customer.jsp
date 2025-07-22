<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>View Customer</title>
</head>
<body>
<h2>Customer Details</h2>
<p><strong>ID:</strong> ${customer.customerId}</p>
<p><strong>Name:</strong> ${customer.firstName} ${customer.lastName}</p>
<p><strong>DOB:</strong> ${customer.dob}</p>
<p><strong>Address:</strong> ${customer.address}</p>
<p><strong>Mobile:</strong> ${customer.mobile}</p>
<p><strong>Email:</strong> ${customer.mail}</p>
<p><strong>Aadhar:</strong> ${customer.aadhar}</p>
<p><strong>PAN:</strong> ${customer.pan}</p>
<a href="/customers">Back to list</a>
</body>
</html>
