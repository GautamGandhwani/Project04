<%@page import="in.co.rays.ctl.LoginCtl"%>
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
	<center>
		<form action="<%=ORSView.LOGIN_CTL%>" method="post">
			<h1>User Login</h1>
			<table>
				<tr>
					<th>Login :</th>
					<td><input type="text" name="login"
						placeholder="Enter Login Id"></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="text" name="password"
						placeholder="Enter Password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=LoginCtl.OP_SIGN_IN%>"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>