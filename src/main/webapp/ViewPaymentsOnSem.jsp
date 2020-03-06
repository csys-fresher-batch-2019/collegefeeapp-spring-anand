<%@page import="com.chainsys.collegefeeregister.service.SemesterService"%>
<%@page import="com.chainsys.collegefeeregister.model.Semester"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
</head>
<body style="text-align: center">
	<c:choose>
		<c:when test="${not empty LOGGED_IN_USERNAME }">
			<jsp:include page="Menu.jsp"></jsp:include>
			<h1>VIEW PAYMENTS MADE</h1>
			<br>
			<br>
			<form action="ViewPaymentsOnSem">
				Select semester:<input name="sem_name" list="sem_list" required>
				<datalist id="sem_list">
					<%
						SemesterService objsem = new SemesterService();
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
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>