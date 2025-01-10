<%@page import="in.co.rays.ctl.ItemInformationListCtl"%>
<%@page import="in.co.rays.bean.ItemInformationBean"%>
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
	<div align="center">
		<form action="<%=ORSView.ITEMINFORMATION_LIST_CTL%>" method="post">

			<jsp:useBean id="bean" class="in.co.rays.bean.ItemInformationBean"
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

			<h1>Item Information List</h1>

			<table>
				<tr>
					<th>Title :</th>
					<td><input type="text" name="title" placeholder="Enter Title"
						value="<%=ServletUtility.getParameter("title", request)%>"></td>
					<td><input type="submit" name="operation"
						value="<%=ItemInformationListCtl.OP_SEARCH%>"></td>&nbsp;
					<td><input type="submit" name="operation"
						value="<%=ItemInformationListCtl.OP_RESET%>"></td>
				</tr>
			</table>
			<br>
			<table border="1px" width="100%">
				<tr>
					<th><input type="checkbox" id="selectall"></th>
					<th>S.No.</th>
					<th>Title</th>
					<th>Over View</th>
					<th>purchase Date</th>
					<th>Cost</th>
					<th>Category</th>
					<th>Edit</th>
				</tr>
				<%
					while (it.hasNext()) {
						bean = (ItemInformationBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getTitle()%></td>
					<td><%=bean.getOverview()%></td>
					<td><%=bean.getCost()%></td>
					<td><%=bean.getPurchaseDate()%></td>
					<td><%=bean.getCategory()%></td>
					<td><a
						href="<%=ORSView.ITEMINFORMATION_CTL%>?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<br>
			<table width="100%">
				<tr>
					<td align="left"><input type="submit" name="operation"
						value="<%=ItemInformationListCtl.OP_PREVIOUS%>"
						<%=(pageNo == 1) ? "disabled" : ""%>></td>

					<td><input type="submit" name="operation"
						value="<%=ItemInformationListCtl.OP_NEW%>"></td>

					<td><input type="submit" name="operation"
						value="<%=ItemInformationListCtl.OP_DELETE%>"></td>

					<td align="right"><input type="submit" name="operation"
						value="<%=ItemInformationListCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>