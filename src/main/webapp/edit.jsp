<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>List of Products - Edit</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Edit Product</h1>
	<form name="frmProduct" action="update" onsubmit="return validate()">
		<table>
			<tr>
				<td><input type="text" name="id" id="box3" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="name" class="box1"
					value="<%out.print(request.getAttribute("name"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="description" class="box2"
					value="<%out.print(request.getAttribute("description"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="value" class="box1"
					value="<%out.print(request.getAttribute("value"));%>"></td>
			</tr>
			
			
			<tr>
				<td>Available:
					<input type="checkbox" name="available"
    					<%= (Boolean.TRUE.equals(request.getAttribute("available"))) ? "checked" : "" %> >
				</td>
			</tr>
			
		</table>
		<input type="submit" value="Save" class="button1">
	</form>
	<script src="scripts/validator.js"></script>
</body>
</html>