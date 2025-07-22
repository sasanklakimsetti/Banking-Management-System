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

        /* Modal styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 99;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0,0,0,0.6);
        }

        .modal-content {
            background-color: #1e1e1e;
            margin: 10% auto;
            padding: 30px;
            border-radius: 10px;
            width: 90%;
            max-width: 400px;
            color: white;
            position: relative;
        }

        .modal-content h2 {
            margin-bottom: 20px;
        }

        .modal-content input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            font-size: 16px;
            border: 1px solid #444;
            border-radius: 6px;
            background-color: #2a2a2a;
            color: white;
        }

        .modal-content button {
            width: 100%;
            padding: 10px;
            background-color: #2196f3;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        .modal-content button:hover {
            background-color: #0b7dda;
        }

        .close {
            position: absolute;
            top: 10px;
            right: 16px;
            font-size: 22px;
            cursor: pointer;
            color: #ccc;
        }

        .close:hover {
            color: #fff;
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
            <button onclick="openModal('depositModal')" class="action-btn">Deposit</button>
            <button onclick="openModal('withdrawModal')" class="action-btn">Withdraw</button>
        </div>
    </div>

    <!-- Deposit Modal -->
    <div id="depositModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal('depositModal')">&times;</span>
            <h2>Deposit Amount</h2>
            <input type="number" id="depositAmount" placeholder="Enter amount">
            <button onclick="submitDeposit()">Submit</button>
        </div>
    </div>

    <!-- Withdraw Modal -->
    <div id="withdrawModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal('withdrawModal')">&times;</span>
            <h2>Withdraw Amount</h2>
            <input type="number" id="withdrawAmount" placeholder="Enter amount">
            <button onclick="submitWithdraw()">Submit</button>
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

        function openModal(id) {
            document.getElementById(id).style.display = "block";
        }

        function closeModal(id) {
            document.getElementById(id).style.display = "none";
        }

        function submitDeposit() {
            const amount = parseFloat(document.getElementById("depositAmount").value);
            if (isNaN(amount) || amount <= 0) {
                alert("Please enter a valid amount.");
                return;
            }
            actualBalance += amount;
            if (balanceVisible) {
                document.getElementById("balance").textContent = actualBalance.toFixed(2);
            }
            closeModal('depositModal');
        }

        function submitWithdraw() {
            const amount = parseFloat(document.getElementById("withdrawAmount").value);
            if (isNaN(amount) || amount <= 0) {
                alert("Please enter a valid amount.");
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
            closeModal('withdrawModal');
        }
    </script>

</body>
</html>
