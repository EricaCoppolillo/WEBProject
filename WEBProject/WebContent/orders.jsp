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
		
			
			<c:if test="${emptyOrders == true}">
					<div id="emptyCart" class="row"><h1>Non ci sono ordini</h1></div>
			</c:if>
		
			<c:forEach var="product" items="${products}">
				
					<div id = "rowProduct" class="row"> 
						
						<div id = "imageProductContainer"><img src="img/products/${product.imagePath}" width="200px"></div>
						<div id = "descriptionOrder">
						<div id="orderLink">
							<a  href="product?id=${product.id}">
								<h2> 
									${product.manufacturer} ${product.model}
								</h2>
									
								
							</a>
						</div>
							<h4>${product.price} €</h4>
							<h5>${product.date}</h5>
							<h6>${product.shipment}</h6>
							<a id="buyAgain" href="product?id=${product.id}">
								<button onclick="checkProduct('${product.id}', 'cart')" class="btn btn-warning">Compralo di nuovo</button>
							</a>
							<a id="writeComment" href="product?id=${product.id}">
								<button class="btn btn-primary">Scrivi una recensione</button>
							</a>
						</div>
					</div> <!-- rowProduct -->
					
			</c:forEach>
			
			
		</div> <!-- viewOrders -->
	</div> <!-- principalRowOrders -->
	
</body>
</html>