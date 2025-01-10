<%@page import="in.co.rays.ctl.CourseListCtl"%>
<%@page import="in.co.rays.bean.CourseBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="java.util.List"%>
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
			scope="request"></jsp:useBean>
		<%
			List list = ServletUtility.getList(request);
		%>

		<h1 align="center">Course List</h1>

		<table border="1px" width="100%">
			<tr>
				<th><input type="checkbox" id="selectall"></th>
				<th>S.No.</th>
				<th>Name</th>
				<th>Duration</th>
				<th>Description</th>
				<th>Edit</th>
			</tr>
			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					bean = (CourseBean) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getDuration()%></td>
				<td><%=bean.getDescription()%></td>
				<td><a href="<%=ORSView.COURSE_CTL%>?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table>
			<tr>

				<td><input type="submit" name="operation"
					value="<%=CourseListCtl.OP_NEW%>"></td>

				<td><input type="submit" name="operation"
					value="<%=CourseListCtl.OP_DELETE%>"></td>


			</tr>
		</table>
	</form>
</body>
</html>