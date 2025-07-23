<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Savings Account</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-5">

<h2>Create Savings Account</h2>

<form action="<%= request.getContextPath() %>/savings_account/create_account" method="post" class="row g-3">
    <input type="hidden" name="customerId" value="<%= request.getAttribute("customerId") %>"/>

    <div class="col-md-6">
        <label for="savingsType" class="form-label">Account Type</label>
        <select class="form-select" name="savingsType" required>
            <option value="">Select</option>
            <option value="Regular">Regular</option>
            <option value="Premium">Premium</option>
            <option value="Student">Student</option>
            <option value="Basic">Basic</option>
        </select>
    </div>

    <div class="col-12">
        <button type="submit" class="btn btn-success">Create Account</button>
    </div>
</form>

</body>
</html>
