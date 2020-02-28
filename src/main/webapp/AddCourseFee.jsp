<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.collegefeeregister.category.Category"%>
<%@page import="com.chainsys.collegefeeregister.category.CategoryDAOImplementation"%>
<%@page import="com.chainsys.collegefeeregister.course.Course"%>
<%@page import="com.chainsys.collegefeeregister.course.CourseDAOImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD COURSE FEE</title>
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
		<h1>ADD COURSE FEE</h1>
		<br> <br>
		<%
			ArrayList<Course> courses = (ArrayList) request.getAttribute("CourseList");
				ArrayList<Category> categories = (ArrayList) request.getAttribute("CategoryList");
				String infoMessage = (String) request.getAttribute("infoMessage");
				String errorMessage = (String) request.getAttribute("errorMessage");
				if (infoMessage != null)
					out.println(infoMessage);
				if (errorMessage != null)
					out.println(errorMessage);
		%>

		<form action="AddCourseFee">
			Select Course: <select name="course">
				<%
					CourseDAOImplementation obj1 = new CourseDAOImplementation();
						for (Course c : courses) {
				%>
				<option value="<%=c.getCourseId()%>">
					<%=obj1.getCourseName(c.getCourseId())%>
				</option>
				<%
					}
				%>
			</select><br> <br> Select Category:<select name="category">
				<%
					CategoryDAOImplementation obj2 = CategoryDAOImplementation.getInstance();
						for (Category cc : categories) {
				%>
				<option value="<%=cc.getId()%>">
					<%=cc.getName()%>
				</option>
				<%
					}
				%>
			</select><br> <br> Enter amount: <input type="number"
				name="txtamount" min=1 required><br> <br>
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