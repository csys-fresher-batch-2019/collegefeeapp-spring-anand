<%@page import="com.chainsys.collegefeeregister.model.Degree"%>
<%@page import="com.chainsys.collegefeeregister.model.Department"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page
	import="com.chainsys.collegefeeregister.service.DepartmentService"%>
<%@page import="com.chainsys.collegefeeregister.service.DegreeService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD COURSE</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<body style="text-align: center">
	<c:choose>
		<c:when test="${not empty LOGGED_IN_USERNAME}">
			<jsp:include page="Menu.jsp"></jsp:include>
			<h1>ADD COURSE</h1>
			<br>
			<form action="AddCourse">

				<br>
				<br> Search by Name (Degree): <input name="degree_name"
					list="degree_list" required>
				<datalist id="degree_list">
					<c:forEach items="${DegreeList}" var="s">
						<option value="${s.id}">${s.name}</option>
					</c:forEach>

				</datalist>
				<br> <br> Search by Name (Department): <input
					name="department_name" list="department_list" required>

				<datalist id="department_list">

					<c:forEach items="${DepartmentList}" var="a">
						<option value="${a.deptId}">${a.deptName}</option>
					</c:forEach>

				</datalist>
				<br> <br>
				<button type="submit" class="btn btn-success">SUBMIT</button>
			</form>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>