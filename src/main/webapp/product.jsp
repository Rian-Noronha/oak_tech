<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="oak_tech.model.Product" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.NumberFormat" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new java.util.Locale("pt", "BR"));
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Oak Tech</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<h1>List of Products</h1>
	<a class="button1" href="new_product.html">New Product</a>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>Name</th>
				<th>Value</th>
				<th>Actions</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				for (int i = 0; i < products.size(); i++){
					String formattedValue = currencyFormat.format(products.get(i).getValue());
			%>
			<tr>
				<td><%= products.get(i).getName() %></td>	
				<td><%= formattedValue %></td>
				<td>
					<a href="select?id=<%= products.get(i).getId() %>" class="button1">Edit</a>
					<a href="javascript: deleteContact(<%= products.get(i).getId() %>)" class="Botao2">Delete</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmer.js"></script>

</body>
</html>
