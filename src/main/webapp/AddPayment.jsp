<%@page import="com.chainsys.collegefeeregister.model.Category"%>
<%@page import="com.chainsys.collegefeeregister.dao.impl.CategoryDAOImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.collegefeeregister.model.Semester"%>
<%@page import="com.chainsys.collegefeeregister.dao.impl.SemesterDAOImplementation"%>
<%@page import="com.chainsys.collegefeeregister.model.Stud_Class"%>
<%@page import="com.chainsys.collegefeeregister.dao.impl.StudentDAOImplementation"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD PAYMENT</title>
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
		<h1>PAYMENT REGISTER</h1>
		<br> <br>
		<form action="AddPayment">
			Student Regno: <input name="regno_name" list="regno_list" required>
			<datalist id="regno_list"> <%
 	StudentDAOImplementation objstd = StudentDAOImplementation.getInstance();
 		ArrayList<Stud_Class> stdlist = objstd.getAllActiveStudents();
 		for (Stud_Class s : stdlist) {
 %><option value="<%=s.getRegno()%>"><%=s.getName()%></option>
			<%
				}
			%> </datalist>
			<br> <br> Select semester:<input name="sem_name"
				list="sem_list" required>
			<datalist id="sem_list"> <%
 	SemesterDAOImplementation objsem = SemesterDAOImplementation.getInstance();
 		ArrayList<Semester> semlist = objsem.getAllSemester();
 		for (Semester s1 : semlist) {
 %><option value="<%=s1.getId()%>">
				<%=objsem.getSemester(s1)%>
			</option>
			<%
				}
			%> </datalist>
			<br> <br> Select Category:<input name=cat_name
				" list="cat_list" required>
			<datalist id="cat_list"> <%
 	CategoryDAOImplementation objcat = CategoryDAOImplementation.getInstance();
 		ArrayList<Category> catlist = objcat.getAllCategory();
 		for (Category c1 : catlist) {
 %><option value=<%=c1.getId()%>><%=c1.getName()%>
			</option>
			<%
				}
			%> </datalist>
			<br> <br>

			<button type="submit" class="btn btn-success">submit</button>

		</form>

	</center>
	<%
		} else {
			response.sendRedirect("Login.jsp");
		}
	%>
</body>
</html>