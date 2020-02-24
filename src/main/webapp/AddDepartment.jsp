<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD DEPARTMENT</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<body>
	<%
		String user = (String) session.getAttribute("LOGGED_IN_USERNAME");
		if (user != null) {
	%>

	<jsp:include page="Menu.jsp"></jsp:include>
	<center>
		<h1>ADD DEPARTMENT</h1>
		<br> <br>
		<%
			String infoMessage = (String) request.getAttribute("infoMessage");
				String errorMessage = (String) request.getAttribute("errorMessage");
				if (infoMessage != null)
					out.println(infoMessage);
				if (errorMessage != null)
					out.println(errorMessage);
		%>

		<form action="AddDepartment">
			Enter name: <input type="text" name="department_name" required> <br>
			<br>
			<button type="submit" class="btn btn-success">SUBMIT</button>
		</form>
	</center>
	<%
		} else {
			response.sendRedirect("Login.jsp");
		}
	%>
</body>
</html>