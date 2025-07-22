<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Customer Details</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-5">
<h2 class="mb-4">Customer Details</h2>
<ul class="list-group">
  <li class="list-group-item"><strong>ID:</strong> ${customer.id}</li>
  <li class="list-group-item"><strong>Name:</strong> ${customer.name}</li>
  <li class="list-group-item"><strong>Email:</strong> ${customer.email}</li>
  <li class="list-group-item"><strong>Phone:</strong> ${customer.phone}</li>
  <li class="list-group-item"><strong>Address:</strong> ${customer.address}</li>
</ul>
</body>
</html>
