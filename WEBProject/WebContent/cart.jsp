<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Il tuo Carrello</title>
	<%@ include file="include.jsp" %>
	
	<link rel="stylesheet" href="css/cart.css">
</head>
<body>

	<%@ include file="menuBar.jsp" %>
	
	<div id="container" class="row">
		<div id="products" class="col-sm-9">
			Ciao
		</div>
		
		
		<div id="goToPayment" class="card mt-4 col-sm-3">
			<div class="row">
				<div class="col">Prezzo Totale:</div>
				<div id="totalPrice" class="col">1000 €</div>
			</div>
			<a href="..payment">
				<button class="btn btn-primary">Procedi all'ordine</button>
			</a>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>