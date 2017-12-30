<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<title>jCombat Demo - Microservices</title>
</head>

<body>
	<h1 style="color: red">jCombat Demo - Microservices with Spring Boot</h1>
	<div class="container">
		<div class="row">
			<h2>User Details</h2>
			<ul>
				<li><strong>Profile ID:</strong> ${profile.userId}</li>
				<li><strong>Profile Name:</strong> ${profile.name}</li>
			</ul>
		</div>
	</div>
</body>
</html>