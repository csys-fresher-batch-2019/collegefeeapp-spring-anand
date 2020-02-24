<%@page import="com.chainsys.course.CourseDAOImplementation"%>
<%@page import="com.chainsys.course.Course"%>
<%@page import="com.chainsys.department.DeptDAOImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.degree.DegreeDAOImplementation"%>
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
<body>
	<%
		String user = (String) session.getAttribute("LOGGED_IN_USERNAME");

		if (user != null) {
	%>

	<jsp:include page="Menu.jsp"></jsp:include>
	<center>
		<h1>ADD STUDENT</h1>
		<br> <br>
		<%
			ArrayList<Course> courses = (ArrayList) request.getAttribute("CoursesList");
				String infoMessage = (String) request.getAttribute("infoMessage");
				String errorMessage = (String) request.getAttribute("errorMessage");
				if (infoMessage != null)
					out.println(infoMessage);
				if (errorMessage != null)
					out.println(errorMessage);
		%>
		<form action="AddStudent">
			Enter Regno: <input type="text" name="txtregno" required> <br> <br>
			Enter Student Name:<input type="text" name="txtname" required> <br>
			<br> Select Course:<select name="course">
				<%
					CourseDAOImplementation obj = CourseDAOImplementation.getInstance();
						for (Course c : courses) {
				%>
				<option value="<%=c.getCourseId()%>">
					<%=obj.getCourseName(c.getCourseId())%>
				</option>
				<%
					}
				%>

			</select> <br> <br> Enter mail id:<input type="email" id="email"
				name="email"> <br> <br>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>
	</center>
	<%
		} else {
			response.sendRedirect("Login.jsp");
		}
	%>
</body>
</html>