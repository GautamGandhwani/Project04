<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="in.co.rays.ctl.SubjectCtl"%>
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
		<form action="<%=ORSView.SUBJECT_CTL%>" method="post">

			<jsp:useBean id="bean" class="in.co.rays.bean.SubjectBean"
				scope="request"></jsp:useBean>

			<%
				List courseList = (List) request.getAttribute("courseList");
			%>

			<h1>Add Subject</h1>

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
					<th align="left">Name<span style="color: red">*</span></th>
					<td><input type="text" name="name"
						value="<%=DataUtility.getStringData(bean.getName())%>"
						placeholder="Enter Name"></td>
				</tr>

				<tr>
					<th align="left">Course Name<span style="color: red">*</span></th>
			<td><%=HTMLUtility.getList("courseid", DataUtility.getStringData(bean.getCourseId()), courseList) %></td>
				</tr>

				<tr>
					<th align="left">Description<span style="color: red">*</span></th>
					<td><input type="text" name="description"
						value="<%=DataUtility.getStringData(bean.getDescription())%>"
						placeholder="Enter Description"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=SubjectCtl.OP_SAVE%>">&nbsp;<input type="submit"
						name="operation" value="<%=SubjectCtl.OP_RESET%>"></td>
				</tr>
