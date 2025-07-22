<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - ABC Bank</title>
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
            display: flex;
            justify-content: center;
            align-items: flex-start;
            height: calc(100vh - 70px);
            padding-top: 50px;
        }

        .card {
            background-color: #1e1e1e;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.6);
            width: 100%;
            max-width: 600px;
        }

        .card h2 {
            text-align: center;
            color: #90caf9;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            margin-top: 15px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #2c2c2c;
            color: #fff;
            font-size: 16px;
        }

        .submit-btn {
            margin-top: 25px;
            width: 100%;
            padding: 12px;
            background-color: #2196f3;
            color: white;
            border: none;
            font-size: 18px;
            border-radius: 6px;
            cursor: pointer;
        }

        .submit-btn:hover {
            background-color: #0b7dda;
        }

        .error {
            color: #f44336;
            margin-top: 10px;
            font-size: 14px;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <h1>ABC Bank</h1>
    </div>

    <!-- Centered Card Form -->
    <div class="container">
        <div class="card">
            <h2>Customer Registration</h2>
            <form id="registerForm" action="registerServlet" method="post" onsubmit="return validateForm()">
                <label for="customerID">Customer ID</label>
                <input type="number" name="customerID" required>

                <label for="fname">First Name</label>
                <input type="text" name="fname" required>

                <label for="lname">Last Name</label>
                <input type="text" name="lname" required>

                <label for="dob">Date of Birth</label>
                <input type="date" name="dob" id="dob" required>

                <label for="mobile">Mobile</label>
                <input type="text" name="mobile">

                <label for="mail">Email</label>
                <input type="email" name="mail">

                <label for="address">Address</label>
                <input type="text" name="address" required>

                <label for="aadhar">Aadhar Number</label>
                <input type="text" name="aadhar" required>

                <label for="pan">PAN Number</label>
                <input type="text" name="pan" required>

                <button type="submit" class="submit-btn">Register</button>
                <p class="error" id="errorMsg"></p>
            </form>
        </div>
    </div>

    <script>
        function validateForm() {
            const dob = document.getElementById("dob").value;
            const mobile = document.forms["registerForm"]["mobile"].value;
            const mail = document.forms["registerForm"]["mail"].value;
            const errorMsg = document.getElementById("errorMsg");

            if (mobile.trim() === "" && mail.trim() === "") {
                errorMsg.textContent = "Either mobile or email must be provided.";
                return false;
            }

            const birthDate = new Date(dob);
            const today = new Date();
            let age = today.getFullYear() - birthDate.getFullYear();
            const m = today.getMonth() - birthDate.getMonth();
            if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
                age--;
            }

            if (age < 18) {
                errorMsg.textContent = "You must be at least 18 years old.";
                return false;
            }

            return true;
        }
    </script>

</body>
</html>
