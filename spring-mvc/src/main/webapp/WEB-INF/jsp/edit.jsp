<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Edit Book Form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

	<h1>Update the Book Details</h1>

	<table class="table">
		<form:form action="/books/v1/api/update" method="post"
			modelAttribute="book">
			<tbody>
				<tr>
					<td><form:input type="hidden" path="bId" /></td>
				</tr>
				<tr>
					<td><form:label path="author">Author</form:label></td>
					<td><form:input path="author" value="${book.author}"
							title="Enter Book author" /></td>
				</tr>
				<tr>
					<td><form:label path="title">Title</form:label></td>
					<td><form:input path="title" value="${book.title}"
							title="Enter Book title" /></td>
				</tr>
				<tr>
					<td><form:button value="submit">Update Book</form:button></td>
					<td><form:button value="reset">Reset</form:button></td>
				</tr>
			</tbody>
		</form:form>
	</table>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>