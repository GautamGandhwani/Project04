<%@page import="in.co.rays.ctl.LoginCtl"%>
<%@page import="in.co.rays.bean.UserBean"%>
<%@page import="in.co.rays.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!-- Include jQuery UI -->
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
<!-- Include jQuery UI CSS -->
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="/ORSProject-4/js/checkbox.js"></script>
<script src="/ORSProject-4/js/datepicker.js"></script>

<script src="/ORSProject-4/js/datepickerp.js"></script>
</head>
<body>
	<%
		UserBean userBean = (UserBean) session.getAttribute("user");
		boolean userLoggedIn = userBean != null;
		String welcomeMsg = "Hi, "
				+ (userLoggedIn ? userBean.getFirstName() + " (" + session.getAttribute("role") + ")" : "Guest");
	%>
	<table>
		<tr>
			<td width="90%"><a style="text-decoration: none;"
				href="<%=ORSView.WELCOME_CTL%>"><b>Welcome</b></a> | <%
				if (userLoggedIn) {
			%> <a style="text-decoration: none;"
				href="<%=ORSView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOG_OUT%>"><b>Logout</b></a>
				<%
					} else {
				%> <a style="text-decoration: none;" href="<%=ORSView.LOGIN_CTL%>"><b>Login</b></a>
				<%
					}
				%></td>
			<td rowspan="2" align="right"><img
				src="<%=ORSView.APP_CONTEXT%>/img/customLogo.jpg" width="318"
				height="90"></td>
		</tr>
		<tr>
			<td>
				<h3><%=welcomeMsg%></h3>
			</td>
		</tr>
		<%
			if (userLoggedIn) {
		%>
		<tr>
			<td colspan="2"><a href="<%=ORSView.USER_CTL%>">Add User</a> | <a
				href="<%=ORSView.USER_LIST_CTL%>">User List</a> | <a
				href="<%=ORSView.ROLE_CTL%>">Add Role</a> | <a
				href="<%=ORSView.ROLE_LIST_CTL%>">Role List</a> | <a
				href="<%=ORSView.COLLEGE_CTL%>">Add College</a> | <a
				href="<%=ORSView.COLLEGE_LIST_CTL%>">College List</a> | <a
				href="<%=ORSView.COURSE_CTL%>">Add Course</a> | <a
				href="<%=ORSView.COURSE_LIST_CTL%>">Course List</a> | <a
				href="<%=ORSView.STUDENT_CTL%>">Add Student</a> | <a
				href="<%=ORSView.STUDENT_LIST_CTL%>">Student List</a> | <a
				href="<%=ORSView.SUBJECT_CTL%>">Add Subject</a> | <a
				href="<%=ORSView.SUBJECT_LIST_CTL%>">Subject List</a> | <a
				href="<%=ORSView.MARKSHEET_CTL%>">Add Marksheet</a> | <a
				href="<%=ORSView.MARKSHEET_LIST_CTL%>">Marksheet List</a> | <br>
				<a href="<%=ORSView.PURCHASE_CTL%>">Add Purchase</a> | <a
				href="<%=ORSView.PURCHASE_LIST_CTL%>">Purchase List</a> | <a
				href="<%=ORSView.PRESCRIPTION_CTL%>">Add Prescription</a> | <a
				href="<%=ORSView.PRESCRIPTION_LIST_CTL%>">Prescription List</a> | <a
				href="<%=ORSView.ITEMINFORMATION_CTL%>">Add Item</a> | <a
				href="<%=ORSView.ITEMINFORMATION_LIST_CTL%>">Item List</a> | <a
				href="<%=ORSView.JAVA_DOC_VIEW%>" target="blank">Java Doc</a></td>


		</tr>
		<%
			}
		%>
	</table>
	<hr>
</body>
</html>