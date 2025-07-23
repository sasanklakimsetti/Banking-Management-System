<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form method="post" action="${pageContext.request.contextPath}/login">
  <label>Username: <input type="text" name="username" /></label><br/>
  <label>Password: <input type="password" name="password" /></label><br/>
  <input type="submit" value="Login"/>
</form>
</body>
</html>
