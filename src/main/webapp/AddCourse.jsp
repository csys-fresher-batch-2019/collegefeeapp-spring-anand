<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page
	import="com.chainsys.collegefeeregister.service.DepartmentService"%>
<%@page import="com.chainsys.collegefeeregister.service.DegreeService"%>
<%@page import="java.util.ArrayList"%>
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
			<%
				String infoMessage = (String) request.getAttribute("infoMessage");
						String errorMessage = (String) request.getAttribute("errorMessage");
						if (infoMessage != null)
							out.println(infoMessage);
						if (errorMessage != null)
							out.println(errorMessage);
			%>
			<h1>ADD COURSE</h1>
			<br>
			<form action="AddCourse">
				Search by Name (Degree):
				<%
				DegreeService obj1 = new DegreeService();
						ArrayList<String> names1 = obj1.getAllDegree();
			%>
				<input name="degree_name" list="degree_list" required>
				<datalist id="degree_list">
					<%
						for (String a : names1) {
					%>
					<option value="<%=a%>"><%=a%></option>
					<%
						}
					%>
				</datalist>
				<br> <br> Search by Name (Department):
				<%
 	DepartmentService obj2 = new DepartmentService();
 			ArrayList<String> names2 = obj2.listAllDepartments();
 %>
				<input name="department_name" list="department_list" required>

				<datalist id="department_list">

					<%
						for (String a : names2) {
					%>
					<option value="<%=a%>"><%=a%></option>
					<%
						}
					%>
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