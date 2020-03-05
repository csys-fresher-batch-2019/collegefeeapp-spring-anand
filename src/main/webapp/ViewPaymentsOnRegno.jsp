<%@page import="com.chainsys.collegefeeregister.service.StudentService"%>
<%@page import="com.chainsys.collegefeeregister.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title></title>
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
	<%
		String errorMessage = (String) request.getAttribute("errorMessage");
			if (errorMessage != null)
				out.println(errorMessage);
	%>
	<h1>VIEW PAYMENTS MADE</h1>
	<br>
	<br>
	<form action="ViewPaymentsOnRegno">
		Select Regno:<input name="regno_name" list="regno_list" required>
		<datalist id="regno_list">
			<%
				StudentService obj = new StudentService();
					ArrayList<Student> stdlist = obj.getAllActiveStudents();
					for (Student s1 : stdlist) {
			%><option value="<%=s1.getRegno()%>">
				<%=s1.getName()%>
			</option>
			<%
				}
			%>
		</datalist>
		<button type="submit" class="btn btn-success">submit</button>
	</form>

	<%
		} else {
			response.sendRedirect("Menu.jsp");
		}
	%>

</body>
</html>