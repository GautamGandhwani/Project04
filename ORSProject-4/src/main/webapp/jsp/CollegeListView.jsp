<%@page import="in.co.rays.ctl.CollegeCtl"%>
<%@page import="in.co.rays.bean.CollegeBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.util.ServletUtility"%>
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
	<div align="center">
		<form action="<%=ORSView.COLLEGE_LIST_CTL%>" method="post">
			<jsp:useBean id="bean" class="in.co.rays.bean.CollegeBean"
				scope="request"></jsp:useBean>
			<%
				List list = ServletUtility.getList(request);
			%>

			<h1>College List</h1>

			<table border="1px" width="100%">
				<tr>
					<th><input type="checkbox"></th>
					<th>S.No.</th>
					<th>Name</th>
					<th>Address</th>
					<th>State</th>
					<th>City</th>
					<th>Phone No.</th>
					<th>Edit</th>
				</tr>
				<%
					Iterator it = list.iterator();
					while (it.hasNext()) {
						bean = (CollegeBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" name="operation"
						value="<%=CollegeCtl.OP_DELETE%>"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getAddress()%></td>
					<td><%=bean.getState()%></td>
					<td><%=bean.getCity()%></td>
					<td><%=bean.getPhoneNo()%></td>
					<td>Edit</td>
				</tr>
				<%
					}
				%>
			</table>
		</form>
	</div>
</body>
</html>