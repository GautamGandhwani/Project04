<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.ctl.PrescriptionListCtl"%>
<%@page import="in.co.rays.bean.PrescriptionBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.util.ServletUtility"%>
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
	<div align="center">
		<form action="<%=ORSView.PRESCRIPTION_LIST_CTL%>" method="post">
			<jsp:useBean id="bean" class="in.co.rays.bean.PrescriptionBean"
				scope="request"></jsp:useBean>
			<%
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
			%>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
			<h1>Prescription List</h1>
			<table>
				<tr>
					<th>Name :</th>
					<td><input type="text" name="name" placeholder="Enter Name"
						value="<%=ServletUtility.getParameter("name", request)%>"></td>
					<td><input type="submit" name="operation"
						value="<%=PrescriptionListCtl.OP_SEARCH%>"></td>&nbsp;
					<td><input type="submit" name="operation"
						value="<%=PrescriptionListCtl.OP_RESET%>"></td>
				</tr>
			</table>
			<br>
			<table border="1px" width="100%">
				<tr>
					<th><input type="checkbox" id="selectall"></th>
					<th>S.No.</th>
					<th>Name</th>
					<th>Decease</th>
					<th>Date</th>
					<th>Capacity</th>
					<th>Edit</th>
				</tr>
				<%
					while (it.hasNext()) {
						bean = (PrescriptionBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getDecease()%></td>
					<td><%=bean.getDate()%></td>
					<td><%=bean.getCapacity()%></td>
					<td><a
						href="<%=ORSView.PRESCRIPTION_CTL%>?id=<%=bean.getId()%>">Edit</a>
				</tr>
				<%
					}
				%>
			</table>
			<br>
			<table width="100%">
				<tr>
					<td align="left"><input type="submit" name="operation"
						value="<%=PrescriptionListCtl.OP_PREVIOUS%>"
						<%=(pageNo == 1) ? "disabled" : ""%>></td>

					<td><input type="submit" name="operation"
						value="<%=PrescriptionListCtl.OP_NEW%>"></td>

					<td><input type="submit" name="operation"
						value="<%=PrescriptionListCtl.OP_DELETE%>"></td>

					<td align="right"><input type="submit" name="operation"
						value="<%=PrescriptionListCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>