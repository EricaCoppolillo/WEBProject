<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Orders</title>
	<%@ include file="include.jsp" %>
	<link rel="stylesheet" href="css/orders.css">	
	<link rel="stylesheet" href="css/wrunner-default-theme.css">
	<script src="js/product.js"></script>
</head>
<body>
	<%@ include file="menuBar.jsp" %>
	
	<div class="jumbotron" id="titleOrders">
	<div class="imageTitleOrders"><img src="img/package.png" width="100px"></div>
		<h1>I miei ordini</h1>
		<h5>Visualizza i dati dei tuoi ordini</h5>
	</div>
	
	<div class="row" id = "principalRowOrders">
		
		<div class = "col-sm-2" id="filterOnOrders">
					
		</div>
		
		<div class = "col-sm-10" id = "viewOrders">
		
			<div class = "row">
					<h2>Numero di prodotti acquistati: ${nProducts}</h2>
			</div>
			
			<c:if test="${emptyProducts == true}">
					<div id="emptyCart" class="row"><h1>Il Carrello è vuoto</h1></div>
			</c:if>
		
			<c:forEach var="product" items="${products}">
				<a href="product?id=${product.id}">
					<div id = "rowProduct" class="row">
						<div id = "imageProductContainer"><img src="img/products/${product.imagePath}" width="200px"></div>
						<div id = "descriptionOrder">
							<h2>${product.model}</h2>
				</a>
							<h4>${product.price}</h4>
							<h5>${product.date}</h5>
							<h6>${product.shipment}</h6>
							<button onclick="checkProduct('${product.id}', 'cart')" class="btn btn-warning">Compralo di nuovo</button>
							<button class="btn btn-primary">Scrivi una recensione</button>
						</div>
					</div> <!-- rowProduct -->
				
			</c:forEach>
			
			
		</div> <!-- viewOrders -->
	</div> <!-- principalRowOrders -->
	
</body>
</html>