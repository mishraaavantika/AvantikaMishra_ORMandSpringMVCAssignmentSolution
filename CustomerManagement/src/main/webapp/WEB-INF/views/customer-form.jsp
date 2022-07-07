<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
<style type="text/css">
label {
	display: inline-block;
	width: 120px;
	font-size: 25px;
	margin-right: 20px;
	margin-bottom: 20px;
	color: green;
}

h1 {
	text-align: center;
	background-color: deepskyblue;
}

h2 {
	color: green;
	font-size: 35px;
	font-family: Tahoma, Verdana, sans-serif;
}

a {
	font-size: 25px;
}

button {
	font-size: 20px;
	width: 125px;
	background-color: lightblue;
}

input {
	width: 250px;
}
</style>
</head>
<body>
	<div>
		<h1>CUSTOMER RELATIONSHIP MANAGEMENT</h1>
	</div>

	<h2>Save Customer</h2>
	<form action="save" method="post">
		<!-- Add hidden form field to handle update -->
		<input type="hidden" name="id" value="${Customer.id}" /> <label
			for="firstName">First Name:</label> <input type="text"
			style="font-size: 15pt; height: 35px; width: 350px" name="firstName"
			value="${Customer.firstName}"><br> <label for="lastName">Last
			Name:</label> <input type="text"
			style="font-size: 15pt; height: 35px; width: 350px" name="lastName"
			value="${Customer.lastName}"><br> <label for="email">Email:</label>
		<input type="text" style="font-size: 15pt; height: 35px; width: 350px"
			name="email" value="${Customer.email}"><br>

		<button type="submit" class="btn btn-info col-5 width:250%">Save</button>
	</form>
	<p>
		<a href="/CustomerManagement/customer/list">Back to
			List</a>
	</p>
</body>
</html>