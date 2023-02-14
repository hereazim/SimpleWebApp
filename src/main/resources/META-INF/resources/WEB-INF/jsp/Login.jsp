<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div class="container">
<h1>Login</h1>
<pre>${error}</pre>
<form method="post">
Username : <input type="text" name="name" placeholder="Enter Username"/><br><br>
Password : <input type="password" name=password placeholder="Enter Password"/><br><br><br>
<input type="submit"/>
</form>
</div>
</body>
</html>