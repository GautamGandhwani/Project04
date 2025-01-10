<%@page import="in.co.rays.ctl.ItemInformationCtl"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
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
		<form action="<%=ORSView.ITEMINFORMATION_CTL%>" method="post">

			<jsp:useBean id="bean" class="in.co.rays.bean.ItemInformationBean"
				scope="request"></jsp:useBean>


			<%
				if (bean != null && bean.getId() > 0) {
			%>
			<h1>Update Item Information</h1>
			<%
				} else {
			%>
			<h1>Add Item Information</h1>
			<%
				}
			%>

			<h3>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h3>
			<h3>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h3>

			<!-- Hidden Fields -->
			<input type="hidden" name="id" value="<%=bean.getId()%>">

			<table>
				<tr>
					<th align="left">Title<span style="color: red">*</span></th>
					<td><input type="text" name="title"
						value="<%=DataUtility.getStringData(bean.getTitle())%>"
						placeholder="Enter Title"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("title", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Over View<span style="color: red">*</span></th>
					<td><input type="text" name="overview"
						value="<%=DataUtility.getStringData(bean.getOverview())%>"
						placeholder="Enter Over View"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("overview", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Cost<span style="color: red">*</span></th>
					<td><input type="text" name="cost"
						value="<%=DataUtility.getStringData(bean.getCost())%>"
						placeholder="Enter Cost"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("cost", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Purchase Date<span style="color: red">*</span></th>
					<td><input type="text" name="purchaseDate" id="pdate"
						value="<%=DataUtility.getStringData(bean.getPurchaseDate())%>"
						placeholder="Enter Purchase Date"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("purchaseDate", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Decease<span style="color: red">*</span></th>
					<td>
						<%
							HashMap<String, String> categoryMap = new HashMap<>();
							categoryMap.put("Mobile", "Mobile");
							categoryMap.put("Food", "Food");
						%> <%=HTMLUtility.getList("category", bean.getCategory(), categoryMap)%>
					</td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("category", request)%></font></td>
				</tr>
				<tr>
					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=ItemInformationCtl.OP_UPDATE%>">&nbsp;<input
						type="submit" name="operation"
						value="<%=ItemInformationCtl.OP_CANCEL%>"></td>
					<%
						} else {
					%>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=ItemInformationCtl.OP_SAVE%>">&nbsp;<input
						type="submit" name="operation"
						value="<%=ItemInformationCtl.OP_RESET%>"></td>
					<%
						}
					%>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>