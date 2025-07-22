<%@ page contentType="text/html;charset=UTF-8" %>
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
    <li class="list-group-item"><strong>ID:</strong> ${customer.customerId}</li>
    <li class="list-group-item"><strong>Name:</strong> ${customer.firstName} ${customer.lastName}</li>
    <li class="list-group-item"><strong>Email:</strong> ${customer.mail}</li>
    <li class="list-group-item"><strong>Mobile:</strong> ${customer.mobile}</li>
    <li class="list-group-item"><strong>Aadhar:</strong> ${customer.aadhar}</li>
    <li class="list-group-item"><strong>PAN:</strong> ${customer.pan}</li>
    <li class="list-group-item"><strong>Address:</strong> ${customer.address}</li>
    <li class="list-group-item"><strong>Date of Birth:</strong> ${customer.dob}</li>
</ul>
<a href="/customer/all" class="btn btn-primary mt-3">Back to List</a>
</body>
</html>
