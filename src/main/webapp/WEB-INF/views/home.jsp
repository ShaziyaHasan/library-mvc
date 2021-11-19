<%@page import="com.nagarro.dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Library Management</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	
	<!-- Main container starts here -->
	
	<div class="container-fluid">

		<!-- Navbar starts here -->

		<nav class="navbar navbar-primary bg-gradient-primary"
			style="background-color: aliceblue;">
			<span class="navbar-brand mb-0 h1">
				<h3>
					<b> Library Management </b>
				</h3>
			</span>
			<%
			String username = (String) session.getAttribute("username");
			%>

			<form class="form-inline my-2 my-lg-0" action="logout">
				<h5 style="margin-bottom: 0px; margin-right: 5px;">
					<b> Welcome ${username}
					</b>
				</h5>
				<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</nav>

		<!-- Navbar ends here  -->

		<!-- Main section starts -->
		
		<main style="padding-left: 20 px; padding-right: 20 px;">
			<nav class="navbar navbar-light bg-white my-4" style="padding:0px;justify-content: space-evenly;">
				<p class="text-center font-weight-bold" style="font-size: 24px;margin-left: 25%;">
					Books Listing
				</p>
				<form action="add">
					<button type="submit" class="btn btn-primary">Add a book</button>
				</form>
			</nav>
		
			<!-- Table section starts here -->
			
			<section>
				<div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Book Code</th>
								<th>Book Name</th>
								<th>Author</th>
								<th>Date Added</th>
								<th>Actions</th>
							</tr>
						</thead>

						<tbody>

							<!-- looping through products fetched from table -->
							
							<c:forEach items="${booksInTable}" var="book">
								<tr>
									<td><c:out value="${book.getBookCode()}" /></td>
									<td><c:out value="${book.getBookName()}" /></td>
									<td><c:out value="${book.getAuthorName()}" /></td>
									<td><c:out value="${book.getAddedOn()}" /></td>
									<td>
										<div class="action-block" style="display:flex;">
										
											<!-- Edit button -->
											<form action="edit/${book.getBookCode()}" method="GET">
												<button class="btn btn-outline-secondary my-2 mx-3 my-sm-0"
												  style="width:88%;" type="submit">
													Edit
												</button>
											</form>
											
											<!-- Delete button -->
											<form action="delete/${book.getBookCode()}" method="GET">
												<button class="btn btn-outline-danger my-2 ml-4 my-sm-0" 
												  type="submit">
													Delete
												</button>
											</form>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>
		</main>
	</div>
</body>
</html>