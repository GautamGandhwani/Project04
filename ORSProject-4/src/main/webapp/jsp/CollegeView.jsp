<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.CollegeCtl"%>
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
		<form action="<%=ORSView.COLLEGE_CTL %>" method="post">

			<jsp:useBean id="bean" class="in.co.rays.bean.CollegeBean"
				scope="request" />

			<h1>Add College</h1>

			<h3>
				<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font>
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
					<th align="left">Name<span style="color: red">*</span></th>
					<td><input type="text" name="name"
						value="<%=DataUtility.getStringData(bean.getName())%>"
						placeholder="Enter Name"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Address<span style="color: red">*</span></th>
					<td><input type="text" name="address"
						value="<%=DataUtility.getStringData(bean.getAddress())%>"
						placeholder="Enter Address"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("address", request)%></font></td>
				</tr>

				<tr>
					<th align="left">State<span style="color: red">*</span></th>
					<td><input type="text" name="stste"
						value="<%=DataUtility.getStringData(bean.getState())%>"
						placeholder="Enter State"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("state", request)%></font></td>
				</tr>

				<tr>
					<th align="left">City<span style="color: red">*</span></th>
					<td><input type="text" name="city"
						value="<%=DataUtility.getStringData(bean.getCity())%>"
						placeholder="Enter City"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("city", request)%></font></td>
				</tr>

				<tr>
					<th align="left">Phone No.<span style="color: red">*</span></th>
					<td><input type="text" name="phoneno"
						value="<%=DataUtility.getStringData(bean.getPhoneNo())%>"
						placeholder="Enter Phone No"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("phoneno", request)%></font></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_SAVE%>">&nbsp; <input
						type="submit" name="operation" value="<%=CollegeCtl.OP_RESET%>">
					</td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>