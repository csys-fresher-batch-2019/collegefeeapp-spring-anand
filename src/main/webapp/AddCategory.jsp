<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD CATEGORY</title>
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
		<h1>ADD CATEGORY</h1>
		<br> <br>
		<form action="AddCategory">
			Enter name: <input type="text" name="category_name" required>
			<br> <br>
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