<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>AOPLATFORM LOGINFORM PAGE</title>
<link rel="stylesheet" href="/Platform/css/loginform.css"
	type="text/css" />

</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			AO<span>PLATFORM</span>
		</div>
	</div>
	<br>
	<div class="login">
		<form action="/Platform/LoginServlet" method="post">
			<input type="text" placeholder="username" name="name">
			<input	type="password" placeholder="password" name="pass"><br>
			<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>