<%@page import="com.chainsys.collegefeeregister.service.PaymentService"%>
<%@page import="com.chainsys.collegefeeregister.model.Payment"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<c:choose>
				<c:when test="${not empty errorMessage }">
${errorMessage}
 		</c:when>
			</c:choose>
			<h1>VIEW PAYMENTS MADE</h1>
			<br>
			<br>
			<%
				PaymentService obj = new PaymentService();
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
		</c:when>
		<c:otherwise>
			<c:redirect url="Login.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>