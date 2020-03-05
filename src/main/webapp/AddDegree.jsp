<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD DEGREE</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<body style="text-align: center">
	<%
		String user = (String) session.getAttribute("LOGGED_IN_USERNAME");

		if (user != null) {
	%>

	<jsp:include page="Menu.jsp"></jsp:include>

	<h1>ADD DEGREE</h1>
	<br>
	<br>
	<%
		String infoMessage = (String) request.getAttribute("infoMessage");
			String errorMessage = (String) request.getAttribute("errorMessage");
			if (infoMessage != null)
				out.println(infoMessage);
			if (errorMessage != null)
				out.println(errorMessage);
	%>

	<form action="AddDegree">
		Enter name: <input type="text" name="degree_name"><br>
		<br>
		<button type="submit" class="btn btn-success">submit</button>
	</form>

	<%
		} else {
			response.sendRedirect("Login.jsp");
		}
	%>
</body>
</html>