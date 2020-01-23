<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Il tuo Carrello</title>
	<%@ include file="include.jsp" %>
	
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/cart.js"></script>
	<link rel="stylesheet" href="css/cart.css">

</head>

<body>

	<%@ include file="menuBar.jsp" %>
	
	<div id="container" class="row">
		<c:if test="${emptyCart == true}">
			<div id="emptyCart" class="text-center py-3">Il Carrello è vuoto</div>
		</c:if>
		<c:if test="${emptyCart != true}">
			<div id="products" class="col-sm-9">
				<div class="row">
					<div class="col-sm-8"></div>
					<div id="titleQuantity" class="col-sm-2">Quantità</div>
					<div id="titlePrice" class="col-sm-1">Prezzo</div>
				</div>
				<c:forEach var="cartProduct" items="${cartProducts}">
					<div id="rowProduct${cartProduct.id}" class="row rowProduct">
						<img class="col-sm-2" src="img/products/${cartProduct.imagePath}" alt="">
						<div class="col-sm-6">
							<div id="modelProduct">${cartProduct.model} ${cartProduct.manufacturer}</div>
							<div>${cartProduct.description}</div>
							<div id="trashIcon" onclick="removeCartProduct('${cartProduct.id}')"><i class="fa fa-trash"></i> Rimuovi</div>
						</div>
						
						<div class="col-sm-2">
							<select id="productQuantity" class="quantity__select">
				              <option id="val1" value="1">1</option>
				              <option id="val2" value="2">2</option>
				              <option id="val3" value="3">3</option>
				              <option id="val4" value="4">4</option>
				              <option id="val5" value="5">5</option>
				            </select>
				            <script>
				            	var orderQuantity = ${cartProduct.orderQuantity};
				            	if(orderQuantity == 1) 
				            		document.getElementById("val1").setAttribute("selected", "");
				            	
				            	if(orderQuantity == 2)
				            		document.getElementById("val2").setAttribute("selected", "");
				            	
				            	if(orderQuantity == 3)
				            		document.getElementById("val3").setAttribute("selected", "");
				            	
				            	if(orderQuantity == 4)
				            		document.getElementById("val4").setAttribute("selected", "");
				            	
				            	if(orderQuantity == 5)
				            		document.getElementById("val5").setAttribute("selected", "");
				            </script>
			            </div>
			            <div id="productPrice" class="col-sm-2">${cartProduct.pricePerQuantity} €</div>
			            <hr class="hr">
					</div>
				</c:forEach>
			
		</div>
		
		<div id="goToPayment" class="card col-sm-3">
			<div id="rowTotalPrice" class="row">
				<div class="col">Prezzo Totale:</div>
				<div id="totalPrice" class="col">
				<script>
					var totPrice = ${totalPrice};
					document.getElementById("totalPrice").innerHTML = totPrice.toFixed(2) + " €";
				</script>
				</div>
			</div>
			<a id="anchorPayment" href="..payment">
				<button class="btn btn-primary">Procedi all'ordine</button>
			</a>
		</div>
		</c:if>
	</div>
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>