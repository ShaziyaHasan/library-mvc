<%@page import="com.nagarro.dto.AuthorDTO"%>
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
<title>Add</title>
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
					<b> 
						Welcome ${username}
					</b>
				</h5>
				<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Logout</button>
			</form>
		</nav>

		<!-- Navbar ends here  -->

		<!-- Main section starts -->

		<main style="padding-left: 20 px; padding-right: 20 px;">
			<p class="text-center font-weight-bold" style="font-size: 24px;">
				Add Book Details</p>

			
			
			<!-- Adding Book Form starts -->
			
			<div class="card" style="border: 0px;">
				<div class="card-body">
					<form action="add" method="POST">

						<!-- Book code -->

						<div class="form-group row">
							<label for="bookCode" class="col-sm-2 col-form-label">
								Book Code
							</label>
							<div class="col-sm-10">
								<input type="number" class="form-control col-sm-6"
									id="bookCode" name="bookCode" required>
							</div>
						</div>

						<!-- Book name -->

						<div class="form-group row">
							<label for="bookName" class="col-sm-2 col-form-label">
								Book Name
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control col-sm-6" name="bookName" 
									id="bookName" required>
							</div>
						</div>

						<!-- Authors to choose -->

						<div class="form-group row">
							<label for="author" class="col-sm-2 col-form-label">Author</label>
							
							<select id="author" name = "authorId" 
								class="form-control col-sm-5 ml-3" required>
								
									<c:forEach items="${authorsList}" var="author">
										<option value="${author.getAuthorId() }">
											<c:out value="${author.getAuthorName()}" />
										</option>
									</c:forEach>
									
							</select>
						</div>
						
						<!-- Added on -->

						<div class="form-group row">
							<label for="addedOn" class="col-sm-2 col-form-label">
								Added On </label>
							<div class="col-sm-10">
								<input type="text" readonly class="form-control-plaintext col-sm-6"
									id="addedOn" value="Auto-generated">
							</div>
						</div>
						<button class="btn btn-primary" type="submit">Submit</button>
						<button class="btn btn-danger" type="button"
							onclick="window.location.href='home';">Cancel</button>
					</form>
				</div>
			</div>
		</main>
	</div>
</body>
</html>