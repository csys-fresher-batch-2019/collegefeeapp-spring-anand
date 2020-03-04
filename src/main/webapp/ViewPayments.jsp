<%@page import="java.util.List"%>
<%@page import="com.chainsys.collegefeeregister.model.Payment"%>
<%@page
	import="com.chainsys.collegefeeregister.dao.impl.PaymentDAOImplementation"%>
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
		<%
			PaymentDAOImplementation obj = PaymentDAOImplementation.getInstance();
				List<Payment> list = obj.listAll();
				if (list != null) {
		%>
		<table border="1">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Payment ID</th>
					<th>Date</th>
					<th>Regno</th>
					<th>FeeCourseID</th>
					<th>SemId</th>
					<th>Amount</th>
				</tr>
			</thead>
			<c:set var="PayList" value="<%=list%>"></c:set>
			<%
				int i = 1;
			%>
			<tbody>
				<c:forEach items="${PayList}" var="p">
					<tr>
						<td><%=i++%></td>
						<td>${p.id}</td>
						<td>${p.date}</td>
						<td>${p.regno}</td>
						<td>${p.feeCourseId}</td>
						<td>${p.semId}</td>
						<td>${p.amount}</td>
					</tr>
				</c:forEach>
			</tbody>
			<%
				}
			%>
		</table>

		<%
			} else {
				response.sendRedirect("Login.jsp");
			}
		%>
	</center>
</body>
</html>