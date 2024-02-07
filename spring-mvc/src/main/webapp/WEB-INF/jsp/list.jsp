<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Books List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<h1>Books List</h1>

	<table class="table">
		<thead>
			<tr>
				<th>BookId</th>
				<th>Author</th>
				<th>Title</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${books}" var="book">
		<tbody>
			<tr>
				<td>${book.bId}</td>
				<td>${book.author}</td>
				<td>${book.title}</td>
				<td> <a href="<c:url value='/books/v1/api/edit/${book.bId}'/>"> Edit</a>
				<a href="<c:url value='/books/v1/api/delete/${book.bId}'/>">Delete</a>
				</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>

	<a href="<c:url value='/books/v1/api/showForm'/>">Add New Book</a>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>