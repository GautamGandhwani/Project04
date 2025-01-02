<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<form action="<%=ORSView.COURSE_LIST_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.CourseBean"
			scope="request" />

		<h1>Course List</</h1>

		<table border="1px" width="100%">
			<tr>
				<th>S.No.</th>
				<th>Name</th>
				<th>Duration</th>
				<th>Description</th>
			</tr>

			<tr>
				<td><%=bean.getId()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getDuration()%></td>
				<td><%=bean.getDescription()%></td>
			</tr>
		</table>
	</form>
</body>
</html>