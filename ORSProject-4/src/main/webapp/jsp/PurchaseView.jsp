<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.ctl.PurchaseCtl"%>
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
		<form action="<%=ORSView.PURCHASE_CTL%>" method="post">
			<jsp:useBean id="bean" class="in.co.rays.bean.PurchaseBean"
				scope="request"></jsp:useBean>


			<h1>Add Purchase</h1>

			<h3>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h3>
			<h3>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h3>

			<!-- Hidden Fields -->
			<input type="hidden" name="id" value="<%=bean.getId()%>" /> <input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>" />
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>" /> <input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>" />
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>" />

			<table>
				<tr>
					<th align="left">Quantity<span style="color: red">*</span></th>
					<td><input type="text" name="quantity"
						value="<%=DataUtility.getStringData(bean.getQuantity())%>"
						placeholder="Enter Quantity"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("quantity", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Price<span style="color: red">*</span></th>
					<td><input type="text" name="price"
						value="<%=DataUtility.getStringData(bean.getPrice())%>"
						placeholder="Enter price"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("price", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Purchase Date<span style="color: red">*</span></th>
					<td><input type="text" name="purchaseDate" id="pdate"
						placeholder="Enter Purchase Date"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("purchaseDate", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Order Type<span style="color: red">*</span></th>
					<td>
						<%
							HashMap<String, String> orderTypeMap = new HashMap<>();
							orderTypeMap.put("mARKET", "mARKET");
							orderTypeMap.put("DELL", "DELL");
						%><%=HTMLUtility.getList("orderType", bean.getOrderType(), orderTypeMap)%>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("orderType", request)%></font></td>


				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=PurchaseCtl.OP_SAVE%>">&nbsp;<input
						type="submit" name="operation" value="<%=PurchaseCtl.OP_RESET%>"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>