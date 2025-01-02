<%@page import="in.co.rays.ctl.RoleCtl"%>
<%@page import="in.co.rays.ctl.UserListCtl"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="in.co.rays.ctl.RoleListCtl"%>
<%@page import="java.beans.beancontext.BeanContext"%>
<%@page import="in.co.rays.bean.RoleBean"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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
		<form action="<%=ORSView.ROLE_LIST_CTL%>" method="post">

			<jsp:useBean id="bean" class="in.co.rays.bean.RoleBean"
				scope="request"></jsp:useBean>

			<h1>Role List</h1>

			<%
				List roleList = (List) request.getAttribute("roleList");
				List list = ServletUtility.getList(request);
			%>

			<table>
				<tr>
					<th>Name :</th>
					<td><input type="text" name="name" placeholder="Enter Name"
						value="<%=ServletUtility.getParameter("name", request)%>"></td>
					<th>Role :</th>
					<td><%=HTMLUtility.getList("roleId", DataUtility.getStringData(bean.getId()), roleList)%></td>&nbsp;
					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_SEARCH%>"></td>&nbsp;
					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_RESET%>"></td>
				</tr>
				<br>
			</table>

			<table border="1px" width="100%">
				<tr>
					<th><input type="checkbox" id="selectall"></th>
					<th>S.No.</th>
					<th>Name</th>
					<th>Description</th>
					<th>Edit</th>
				</tr>
				<%
					Iterator it = list.iterator();
					while (it.hasNext()) {
						bean = (RoleBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getDescription()%></td>
					<td><a href="<%=ORSView.ROLE_CTL%>?id=<%=bean.getId()%>">Edit</a></td>
				</tr>

				<%
					}
				%>
			</table>
			<table>
				<tr>
					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_NEW%>"></td>

					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_DELETE%>"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>