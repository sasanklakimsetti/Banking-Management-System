<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Edit Customer</title>
</head>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f5f7fa;
    margin: 0;
    padding: 0;
  }

  h2 {
    text-align: center;
    margin-top: 30px;
    color: #333;
  }

  form {
    max-width: 500px;
    margin: 40px auto;
    background-color: #fff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
  }

  label {
    display: block;
    margin-bottom: 15px;
    color: #555;
  }

  input[type="text"],
  input[type="date"],
  input[type="email"] {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 14px;
  }

  button[type="submit"] {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 12px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    margin-top: 10px;
  }

  button[type="submit"]:hover {
    background-color: #45a049;
  }

</style>
<body>
<h2>Edit Customer</h2>
<form method="post" action="/customer/update/${customer.customerId}">
  <label>First Name: <input type="text" name="fname" value="${customer.firstName}" required></label><br>
  <label>Last Name: <input type="text" name="lname" value="${customer.lastName}" required></label><br>
  <label>Date of Birth: <input type="date" name="dob" value="${customer.dob}" required></label><br>
  <label>Address: <input type="text" name="address" value="${customer.address}" required></label><br>
  <label>Mobile: <input type="text" name="mobile" value="${customer.mobile}"></label><br>
  <label>Email: <input type="email" name="email" value="${customer.mail}"></label><br>
  <label>Aadhar: <input type="text" name="aadhar" value="${customer.aadhar}" required></label><br>
  <label>PAN: <input type="text" name="pan" value="${customer.pan}" required></label><br>
  <button type="submit">Update</button>
</form>
</body>
</html>
