<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.collegefeeregister.service.CourseService"%>
<%@page import="com.chainsys.collegefeeregister.model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD STUDENT</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<body style="text-align: center">
	<c:choose>
		<c:when test="${not empty LOGGED_IN_USERNAME }">
			<jsp:include page="Menu.jsp"></jsp:include>

			<h1>ADD STUDENT</h1>
			<br>
			<br>
			<%
				List<Course> courses = (List) request.getAttribute("CoursesList");
			%>
			<form action="AddStudent">
				Enter Regno: <input type="text" name="txtregno" required> <br>
				<br> Enter Student Name:<input type="text" name="txtname"
					required> <br> <br> Select Course:<select
					name="course">
					<%
						CourseService t = new CourseService();
								for (Course c : courses) {
					%>
					<option value="<%=c.getCourseId()%>">
						<%=t.getCourseName(c.getCourseId())%>
					</option>
					<%
						}
					%>
				</select> <br> <br> Enter mail id:<input type="email" id="email"
					pattern="[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}"
					title="Example:xyz@gmail.com" name="email"> <br> <br>
				<button type="submit" class="btn btn-success">Submit</button>
			</form>
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>
