<%@page import="in.co.rays.ctl.PurchaseListCtl"%>
<%@page import="in.co.rays.bean.PurchaseBean"%>
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
		<form action="<%=ORSView.PURCHASE_LIST_CTL%>" method="post">

			<jsp:useBean id="bean" class="in.co.rays.bean.PurchaseBean"
				scope="request"></jsp:useBean>

			<%
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
			%>

			<h1>Purchase List</h1>

			<table border="1px" width="100%">
				<tr>
					<th><input type="checkbox" id="selectall"></th>
					<th>S.No.</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Purchase Date</th>
					<th>Order Type</th>
					<th>Edit</th>
				</tr>

				<%
					while (it.hasNext()) {
						bean = (PurchaseBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getQuantity()%></td>
					<td><%=bean.getPrice()%></td>
					<td><%=bean.getPurchaseDate()%></td>
					<td><%=bean.getOrderType()%></td>
					<td><a
						href="<%=ORSView.PURCHASE_LIST_CTL%>?id=<%=bean.getId()%>">Edit</a>
				</tr>
				<%
					}
				%>
			</table>
			<br>
			<table style="width: 100%">
				<tr>


					<td style="width: 30%"><input type="submit" name="operation"
						value="<%=PurchaseListCtl.OP_NEW%>"></td>

					<td style="width: 25%"><input type="submit" name="operation"
						value="<%=PurchaseListCtl.OP_DELETE%>"></td>


				</tr>
			</table>
		</form>
	</div>
</body>
</html>