<!DOCTYPE html>
<html>
<head>
  <title>Create Loan Account</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      padding: 20px;
      background-color: #f5f5f5;
    }
    form {
      max-width: 600px;
      margin: auto;
      background: #ffffff;
      padding: 25px;
      border-radius: 12px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    label {
      margin-top: 10px;
      display: block;
      font-weight: bold;
    }
    input, select {
      width: 100%;
      padding: 8px;
      margin-top: 4px;
      margin-bottom: 10px;
      border-radius: 6px;
      border: 1px solid #ccc;
    }
    button {
      margin-top: 15px;
      padding: 10px;
      width: 100%;
      background-color: #007bff;
      color: white;
      font-weight: bold;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>

<h2 style="text-align:center;">Create Loan Account</h2>

<form id="loanForm" action="/loan_accounts/create_loan_account" method="post">
  <input type="hidden" id="customerIdField" name="customerId" />

  <label for="loanAmount">Loan Amount</label>
  <input type="number" step="0.01" name="loanAmount" id="loanAmount" required />

  <label for="durationInDays">Duration (Days)</label>
  <input type="number" name="durationInDays" id="durationInDays" required />

  <label for="loanType">Loan Type</label>
  <select name="loanType" id="loanType" required>
    <option value="Car">Car</option>
    <option value="House">House</option>
    <option value="Personal">Personal</option>
    <option value="Student">Student</option>
  </select>

  <label for="collateralType">Collateral Type</label>
  <input type="text" name="collateralType" id="collateralType" required />

  <label for="collateralValue">Collateral Value</label>
  <input type="number" step="0.01" name="collateralValue" id="collateralValue" required />

  <button type="submit">Submit Loan Application</button>
</form>

<script>
  // Extract customerId from URL query parameters and insert it into the hidden field
  const params = new URLSearchParams(window.location.search);
  const customerId = params.get("customerId");
  if (customerId) {
    document.getElementById("customerIdField").value = customerId;
  } else {
    alert("Missing customerId in URL.");
    document.querySelector("form").style.display = "none";
  }
</script>

</body>
</html>
