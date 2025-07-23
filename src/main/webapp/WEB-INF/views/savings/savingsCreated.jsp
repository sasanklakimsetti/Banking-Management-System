<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Savings Account Created</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script>
        window.onload = function () {
            const accountNumber = "<%= request.getAttribute("accountNumber") %>";
            const balance = "<%= request.getAttribute("balance") %>";
            const savingsType = "<%= request.getAttribute("savingsType") %>";

            document.getElementById("account-info").innerHTML = `
                <h3 class="text-success">Savings Account Successfully Created!</h3>
                <p><strong>Account Number:</strong> ${accountNumber}</p>
                <p><strong>Savings Type:</strong> ${savingsType}</p>
                <p><strong>Initial Balance:</strong> ₹${balance}</p>
                <a href="/customer/profile" class="btn btn-primary mt-3">Go to Profile</a>
            `;
        }
    </script>
</head>
<body class="container mt-5">
<div id="account-info"></div>
</body>
</html>
