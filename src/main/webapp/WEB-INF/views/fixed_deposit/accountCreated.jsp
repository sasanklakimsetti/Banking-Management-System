<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FD Account Created</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background-color: #f8f9fa;
        }
        .card {
            max-width: 600px;
            margin: auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        .card h2 {
            color: green;
        }
        .card p {
            font-size: 18px;
            margin: 10px 0;
        }
        .btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="card">
    <h2>🎉 Fixed Deposit Account Created Successfully!</h2>

    <p><strong>Account Number:</strong> ${accountNumber}</p>
    <p><strong>Due Date:</strong> ${dueDate}</p>
    <p><strong>Total Payout:</strong> ₹${totalPayout}</p>

    <a class="btn" href="${pageContext.request.contextPath}/customer/profile">Go to Profile</a>
</div>
</body>
</html>
