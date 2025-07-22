<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - ABC Bank</title>
    <style>
        body {
            background-color: #121212;
            color: #ffffff;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .navbar {
            background-color: #1f1f1f;
            padding: 15px 30px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.5);
        }

        .navbar h1 {
            color: #90caf9;
            margin: 0;
            font-size: 24px;
        }

        .container {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .glass-card {
            background: rgba(255, 255, 255, 0.05);
            border-radius: 20px;
            padding: 40px 30px;
            width: 100%;
            max-width: 400px;
            box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.5);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.15);
        }

        .glass-card h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #90caf9;
        }

        .input-group {
            position: relative;
            margin-bottom: 20px;
        }

        .input-group input {
            width: 100%;
            padding: 12px 40px 12px 40px;
            border: none;
            border-radius: 10px;
            background-color: #1e1e1e;
            color: white;
            font-size: 16px;
            outline: none;
            transition: all 0.3s ease;
        }

        .input-group input:focus {
            border: 2px solid #2196f3;
            box-shadow: 0 0 8px #2196f3;
        }

        .input-group .icon {
            position: absolute;
            left: 10px;
            top: 10px;
            font-size: 18px;
            color: #90caf9;
        }

        .actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 14px;
            color: #bbb;
            margin-bottom: 20px;
        }

        .actions a {
            color: #90caf9;
            text-decoration: none;
        }

        .submit-btn {
            width: 100%;
            padding: 12px;
            border-radius: 10px;
            border: 1px solid #90caf9;
            background-color: transparent;
            color: #90caf9;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s ease;
        }

        .submit-btn:hover {
            background-color: #2196f3;
            color: white;
        }

        .register-link {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
        }

        .register-link a {
            color: #90caf9;
            text-decoration: none;
        }

        .error {
            text-align: center;
            color: #f44336;
            margin-top: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <h1>ABC Bank</h1>
    </div>

    <!-- Glass Login Card -->
    <div class="container">
        <div class="glass-card">
            <h2>Login</h2>
            <form action="loginServlet" method="post">
                <div class="input-group">
                    <span class="icon">👤</span>
                    <input type="text" name="customerID" placeholder="Customer ID" required>
                </div>

                <div class="input-group">
                    <span class="icon">🔒</span>
                    <input type="password" name="dob" placeholder="Date of Birth (dd-mm-yyyy)" required>
                </div>

                <div class="actions">
                    <label><input type="checkbox" name="remember"> Remember Me</label>
                    <a href="#">Forgot password?</a>
                </div>

                <button type="submit" class="submit-btn">Login</button>
            </form>

            <!-- Show error message if "error=invalid" is passed in URL -->
            <%
                String error = request.getParameter("error");
                if (error != null && error.equals("invalid")) {
            %>
                <p class="error">Invalid Customer ID or DOB.</p>
            <%
                }
            %>

            <div class="register-link">
                Don’t have an account? <a href="registration.jsp">Register</a>
            </div>
        </div>
    </div>

</body>
</html>
