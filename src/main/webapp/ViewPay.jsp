<%@page import="com.chainsys.collegefeeregister.model.PaymentDetail"%>
<%@page import="java.util.List"%>
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
		<h1>VIEW PAYMENTS</h1>
		<br> <br>
		<%
			List<PaymentDetail> list = (List) request.getAttribute("PayList");
				if (list.isEmpty()) {
					out.println("No records found");
				} else {
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
			<%
				int i = 1;
						for (PaymentDetail p : list) {
			%>
			<tbody>
				<tr>
					<td><%=i++%></td>
					<td><%=p.getId()%></td>
					<td><%=p.getDate()%></td>
					<td><%=p.getRegno()%></td>
					<td><%=p.getFeeCourseId()%></td>
					<td><%=p.getSemId()%></td>
					<td><%=p.getAmount()%></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>
		<%
			}
		%>
	</center>
</body>
<%
	} else {
		response.sendRedirect("Login.jsp");
	}
%>

</html>