<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD DEGREE</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<body style="text-align: center">
	<c:choose>
		<c:when test="${not empty LOGGED_IN_USERNAME}">
			<jsp:include page="Menu.jsp"></jsp:include>
			<h1>ADD DEGREE</h1>
			<br>
			<br>
			<form action="AddDegree">
				Enter name: <input type="text" name="degree_name"><br>
				<br>
				<button type="submit" class="btn btn-success">submit</button>
			</form>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>