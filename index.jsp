<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="components/all_css.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>



	<h1 class="text-center text-success">TODO APP</h1>

	<%
	String sucMsg = (String) session.getAttribute("sucMsg");
	if (sucMsg != null) {
	%>

	<div class="alert alert-success" role="alert"><%=sucMsg%></div>

	<%
	session.removeAttribute("sucMsg");
	}
	%>


	<%
	String failedMsg = (String) session.getAttribute("failedMsg");
	if (failedMsg != null) {
	%>

	<div class="alert alert-danger" role="alert"><%=failedMsg%></div>

	<%
	session.removeAttribute("failedMsg");
	}
	%>



	<div class="container">

		<table class="table table-striped" border="1px">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Todo</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
			
			
			
			
			
				<tr>
					<th scope="row">1</th>
					<th scope="col">John</th>
					<td>Java</td>
					<td>pending</td>
					<td><a href="" class="btn btn-sm btn-success">Edit</a> <a
						href="" class="btn btn-sm btn-danger">Delete</a></td>
				</tr>

			</tbody>
		</table>



	</div>



</body>
</html>