<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MENU</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">

</head>
<body>
	<c:choose>
		<c:when test="${not empty LOGGED_IN_USERNAME }">
			<nav class="navbar navbar-expand navbar-dark bg-dark"> <a
				class="navbar-brand" href="Menu.jsp">CollegeFee</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExample02" aria-controls="navbarsExample02"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExample02">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="AddPayment.jsp">Payment Register <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="ViewAllPayments">View All Payments <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="ViewPaymentsOnSem.jsp">View Payments By Semester<span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="ViewPaymentsOnRegno.jsp">View Payments By Student<span
							class="sr-only">(current)</span>
					</a></li>

					<li class="nav-item"><a class="nav-link" href="AddDegree.jsp">ADD
							DEGREE</a></li>
					<li class="nav-item"><a class="nav-link"
						href="AddDepartment.jsp">ADD DEPARTMENT</a></li>
					<li class="nav-item"><a class="nav-link" href="AddCourse.jsp">ADD
							COURSE</a></li>
					<li class="nav-item"><a class="nav-link" href="AddStudentLoad">ADD
							STUDENT</a></li>
					<li class="nav-item"><a class="nav-link"
						href="AddCategory.jsp">ADD FEE CATEGORY</a></li>
					<li class="nav-item"><a class="nav-link"
						href="AddCourseFeeLoad">ASSIGN COURSE FEE</a></li>
					<li class="nav-item active"><a class="nav-link" href="Logout">Logout
							<span class="sr-only">(current)</span>
					</a></li>
				</ul>
			</div>
			</nav>
			<c:choose>
				<c:when test="${not empty infoMessage }">
 ${infoMessage}
 		</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${not empty errorMessage }">
${errorMessage}
		</c:when>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>