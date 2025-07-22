<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h2>Error Occurred</h2>
<p>Status: <%= request.getAttribute("javax.servlet.error.status_code") %></p>
<p>Message: <%= request.getAttribute("javax.servlet.error.message") %></p>
</body>
</html>
