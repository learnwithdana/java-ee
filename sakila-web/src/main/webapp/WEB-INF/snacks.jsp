<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!--  import the Snack class  -->
<%@page import="com.hca.sakila.models.Snack"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Snacks</title>
</head>
<body>

	<h1>Snacks</h1>

	<%
	// Determine if there was a snack type specified
	String snackType = (String) request.getAttribute("snack-type");

	if (snackType.equals("missing")) {
	%>
	<p>You didn't specify what type of snack you wanted.</p>
	<%
	} else {
	
	// Display the matching snacks	
	Snack[] matchingSnacks = (Snack[]) request.getAttribute("matching-snacks");
	%>
	<table>
		<thead>
			<tr>
				<th>Product Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Snack snack : matchingSnacks) {
			%>
			<tr>
				<td><%=snack.getProductName()%></td>
				<td>$ <%=snack.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	}
	%>
</body>
</html>