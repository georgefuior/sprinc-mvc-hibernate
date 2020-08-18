<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List customer</title>
<link type = "text/css"
		rel = "stylesheet"
		href = "${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM -Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="cointainer" >
		<div id=content>


			<!-- add html table -->
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName }</td>
						<td>${tempCustomer.email }</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>