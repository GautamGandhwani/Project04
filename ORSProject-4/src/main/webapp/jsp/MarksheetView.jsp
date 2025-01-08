<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="in.co.rays.ctl.MarksheetCtl"%>
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
		<form action="<%=ORSView.MARKSHEET_CTL%>" method="post">

			<jsp:useBean id="bean" class="in.co.rays.bean.MarksheetBean"
				scope="request"></jsp:useBean>

			<%
				List studentList = (List) request.getAttribute("studentList");
			%>
			<h1>Add Marksheet</h1>

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
					<th align="left">Roll No.<span style="color: red">*</span></th>
					<td><input type="text" name="rollNo"
						placeholder="Enter Roll Number"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("rollNo", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Name<span style="color: red">*</span></th>
					<td><%=HTMLUtility.getList("studentId", DataUtility.getStringData(bean.getStudentId()), studentList)%></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Physics<span style="color: red">*</span></th>
					<td><input type="text" name="physics"
						placeholder="Enter Physics Marks"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("physics", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Chemistry<span style="color: red">*</span></th>
					<td><input type="text" name="chemistry"
						placeholder="Enter Chemistry Marks"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("chemistry", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Maths<span style="color: red">*</span></th>
					<td><input type="text" name="maths"
						placeholder="Enter maths Marks"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("maths", request)%></font></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=MarksheetCtl.OP_SAVE%>">&nbsp;<input
						type="submit" name="operation" value="<%=MarksheetCtl.OP_RESET%>"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>