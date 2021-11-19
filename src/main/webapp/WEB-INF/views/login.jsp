<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<h3 class="text-center m-2" style="color:blue;">${loginFailed}</h3>
	<h3 class="text-center m-2" style="color:green;">${logoutMessage}</h3>
	
	<div class="container-main" align="center">
		<header class="container-head">
			<h2 class="head-text">LOGIN</h2>
		</header>

		<!-- Main section starts here  -->
		<main class="container-content">

			<!-- Form starts -->
			<form action="login" method="post" >
				<div class="label-container">
					<label class="label-name" for="username">Username:</label>
					<p class="marker-text">*</p>
					<input type="text" class="username" name="username"
					 id="username" required />
				</div>
				<br />
				
				<div class="label-container">
					<label class="label-password" for="password">Password:</label>
					<p class="marker-text">*</p>
					<input type="password" class="password" name="password" id="password" 
						required />
				</div>
				<br />

				<div class="container-btn">
					<input type="submit" id="btn" name="btn-submit" value="Login >>">
				</div>
			</form>
		</main>
	</div>
</body>
</html>