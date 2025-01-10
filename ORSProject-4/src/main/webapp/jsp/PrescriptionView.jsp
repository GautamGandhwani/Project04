<%@page import="in.co.rays.ctl.PrescriptionListCtl"%>
<%@page import="in.co.rays.ctl.PrescriptionCtl"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.ctl.ORSView"%>
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
		<form action="<%=ORSView.PRESCRIPTION_CTL%>" method="post">
			<jsp:useBean id="bean" class="in.co.rays.bean.PrescriptionBean"
				scope="request"></jsp:useBean>
			<%
				if (bean != null && bean.getId() > 0) {
			%>
			<h1>Update Prescription</h1>
			<%
				} else {
			%>
			<h1>Add Prescription</h1>
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
			<input type="hidden" name="id" value="<%=bean.getId()%>" />

			<table>
				<tr>
					<th align="left">Name<span style="color: red">*</span></th>
					<td><input type="text" name="name"
						value="<%=DataUtility.getStringData(bean.getName())%>"
						placeholder="Enter Name"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Decease<span style="color: red">*</span></th>
					<td>
						<%
							HashMap<String, String> deceaseMap = new HashMap<>();
							deceaseMap.put("dengue", "Dengue");
							deceaseMap.put("malaria", "Malaria");
						%> <%=HTMLUtility.getList("decease", bean.getDecease(), deceaseMap)%>
					</td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("capacityMap", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Date<span style="color: red">*</span></th>
					<td><input type="text" name="date" id="pdate"
						value="<%=DataUtility.getDateString(bean.getDate())%>"
						placeholder="Enter Purchase Date"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("date", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Capacity<span style="color: red">*</span></th>
					<td><input type="text" name="capacity"
						value="<%=DataUtility.getStringData(bean.getCapacity())%>"
						placeholder="Enter Capacity"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("capacity", request)%></font></td>
				</tr>
				<tr>
					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=PrescriptionCtl.OP_UPDATE%>">&nbsp;<input
						type="submit" name="operation"
						value="<%=PrescriptionListCtl.OP_CANCEL%>"></td>
					<%
						} else {
					%>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=PrescriptionCtl.OP_SAVE%>">&nbsp;<input
						type="submit" name="operation"
						value="<%=PrescriptionCtl.OP_RESET%>"></td>
					<%
						}
					%>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>