<!DOCTYPE html>
<html>
<head>
    <title>FD Actions</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-5">
<h2 class="mb-4">Manage Fixed Deposit</h2>
<form action="${pageContext.request.contextPath}/fd/action" method="post" class="row g-3">
    <input type="hidden" name="accountNumber" value="${accountNumber}" />
    <div class="col-md-6">
        <label class="form-label">Action</label>
        <select name="action" class="form-select">
            <option value="withdraw">Withdraw</option>
            <option value="renew">Renew</option>
            <option value="close">Close</option>
        </select>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-danger">Proceed</button>
    </div>
</form>
</body>
</html>
