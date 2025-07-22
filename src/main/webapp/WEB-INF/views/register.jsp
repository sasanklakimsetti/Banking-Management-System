<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">Create New Customer</h2>
    <form action="/customer/create" method="post" class="bg-white p-4 shadow-sm rounded">
        <div class="mb-3">
            <label class="form-label">First Name *</label>
            <input type="text" class="form-control" name="fname" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Last Name *</label>
            <input type="text" class="form-control" name="lname" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Date of Birth *</label>
            <input type="date" class="form-control" name="dob" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Address *</label>
            <textarea class="form-control" name="address" required></textarea>
        </div>
        <div class="mb-3">
            <label class="form-label">Mobile</label>
            <input type="text" class="form-control" name="mobile">
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email">
        </div>
        <div class="mb-3">
            <label class="form-label">Aadhar *</label>
            <input type="text" class="form-control" name="aadhar" required>
        </div>
        <div class="mb-3">
            <label class="form-label">PAN *</label>
            <input type="text" class="form-control" name="pan" required>
        </div>
        <button type="submit" class="btn btn-primary">Register Customer</button>
    </form>
</div>
</body>
</html>
