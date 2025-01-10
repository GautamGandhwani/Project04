<%@page import="in.co.rays.util.PropertyReader"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.ctl.CollegeListCtl"%>
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
				int nextPageSize = DataUtility.getInt(PropertyReader.getValue("page.size").toString());
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
			%>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
			<h1>College List</h1>

			<table>
				<tr>
					<th>Name :</th>
					<td><input type="text" name="name" placeholder="Enter Name"></td>

					<td><input type="submit" name="operation"
						value="<%=CollegeListCtl.OP_SEARCH%>"><input type="submit"
						name="operation" value="<%=CollegeListCtl.OP_RESET%>"></td>
				</tr>
			</table>

			<table border="1px" width="100%">
				<tr>
					<th><input type="checkbox" id="selectall"></th>
					<th>S.No.</th>
					<th>Name</th>
					<th>Address</th>
					<th>State</th>
					<th>City</th>
					<th>Phone No.</th>
					<th>Edit</th>
				</tr>
				<%
					while (it.hasNext()) {
						bean = (CollegeBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getAddress()%></td>
					<td><%=bean.getState()%></td>
					<td><%=bean.getCity()%></td>
					<td><%=bean.getPhoneNo()%></td>
					<td><a href="<%=ORSView.COLLEGE_CTL%>?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<table width="100%">
				<tr>
					<td align="left"><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_PREVIOUS%>"
						<%=(pageNo == 1) ? "disabled" : ""%>></td>

					<td><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_NEW%>"></td>

					<td><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_DELETE%>"></td>

					<td align="right"><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>