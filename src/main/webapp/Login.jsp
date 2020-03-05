<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>LOGIN</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<body style="text-align: center">

	<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null)
			out.println(errorMessage);
	%>

	<form action="Login" method="post">
		<h1>ADMIN LOGIN</h1>
		<br> <br> Enter username: <input type="text" name="username"
			required><br> <br> Enter password: <input
			type="password" name="password" required><br> <br>
		<button type="submit" class="btn btn-success">submit</button>
	</form>

</body>
</html>

