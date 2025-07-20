<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Home - ABC Bank</title>
    <style>
        body {
            background-color: #121212;
            color: #ffffff;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #1f1f1f;
            padding: 15px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-shadow: 0 2px 10px rgba(0,0,0,0.5);
        }
        .navbar h1 {
            color: #90caf9;
            margin: 0;
            font-size: 24px;
            font-weight: bold;
        }

        .container {
            text-align: center;
            padding: 60px 20px;
        }

        .balance-box {
            background-color: #1e1e1e;
            padding: 30px;
            border-radius: 10px;
            display: inline-block;
            margin-bottom: 30px;
        }

        .balance {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .toggle-btn {
            background: none;
            border: none;
            color: #90caf9;
            font-size: 20px;
            cursor: pointer;
        }

        .action-btn {
            background-color: #2196f3;
            color: white;
            padding: 12px 30px;
            margin: 10px;
            border: none;
            border-radius: 6px;
            font-size: 18px;
            cursor: pointer;
        }

        .action-btn:hover {
            background-color: #0b7dda;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <h1>ABC Bank</h1>
    </div>

    <div class="container">
        <div class="balance-box">
            <div class="balance" id="balanceText">Balance: ₹<span id="balance">****</span></div>
            <button class="toggle-btn" onclick="toggleBalance()">👁️</button>
        </div>

        <div>
            <button onclick="handleDeposit()" class="action-btn">Deposit</button>
            <button onclick="handleWithdraw()" class="action-btn">Withdraw</button>
        </div>
    </div>

    <script>
        let balanceVisible = false;
        let actualBalance = 12500.00; 

        function toggleBalance() {
            const balanceSpan = document.getElementById("balance");
            balanceVisible = !balanceVisible;
            balanceSpan.textContent = balanceVisible ? actualBalance.toFixed(2) : "****";
        }

        function handleDeposit() {
            const amount = parseFloat(prompt("Enter amount to deposit:"));
            if (isNaN(amount) || amount <= 0) {
                alert("Invalid amount.");
                return;
            }
            actualBalance += amount;
            if (balanceVisible) {
                document.getElementById("balance").textContent = actualBalance.toFixed(2);
            }
            alert("Amount deposited successfully!");
        }

        function handleWithdraw() {
            const amount = parseFloat(prompt("Enter amount to withdraw:"));
            if (isNaN(amount) || amount <= 0) {
                alert("Invalid amount.");
                return;
            }
            if (amount > actualBalance) {
                alert("Insufficient balance!");
                return;
            }
            actualBalance -= amount;
            if (balanceVisible) {
                document.getElementById("balance").textContent = actualBalance.toFixed(2);
            }
            alert("Amount withdrawn successfully!");
        }
    </script>

</body>
</html>
