<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Edit Customer</title>
</head>
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
