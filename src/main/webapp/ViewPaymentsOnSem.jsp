<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.semester.Semester"%>
<%@page import="com.chainsys.semester.SemesterDAOImplementation"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<body>
	<center>
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
		<br> <br>
		<form action="ViewPaymentsOnSem">
			Select semester:<input name="sem_name" list="sem_list" required>
			<datalist id="sem_list">
				<%
					SemesterDAOImplementation objsem = SemesterDAOImplementation.getInstance();
						ArrayList<Semester> semlist = objsem.getAllSemester();
						for (Semester s1 : semlist) {
				%><option value="<%=s1.getId()%>">
					<%=objsem.getSemester(s1)%>
				</option>
				<%
					}
				%>
			</datalist>
			<button type="submit" class="btn btn-success">submit</button>
		</form>
	</center>
	<%
		} else {
			response.sendRedirect("Menu.jsp");
		}
	%>

</body>

</html>