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
</head>
<body>
	<%@ include file="menuBar.jsp" %>
	
	<div class="jumbotron" id="titleOrders">
	<div class="imageTitleOrders"><img src="img/package.png" width="100px"></div>
		<h1>I miei ordini</h1>
		<h5>Visualizza i dati dei tuoi ordini</h5>
	</div>
	
	<div class="row" id = "principalRowOrders">
		
		<div class = "col-sm-3" id="filterOnOrders">
			<div class="form-group">
					<h4>Ordina per:</h4>
						<select class="form-control" id="orderBy" onchange="updateProducts()">
							<option>Ultimi Acquisti</option>
							<option>Prezzo crescente</option>  <!--  TODO implement ajax function orderBy -->
							<option>Prezzo decrescente</option>
						</select>
			</div>
			
			<h4><br>Prezzo:</h4>
                <div class="my-js-slider"></div>
				<script src="js/wrunner-native.js"></script>
                <script>
                	
                    var setting = {
                        roots: document.querySelector('.my-js-slider'),
                        type: 'range',
                        step: 1,
                        //prezzo minimo e prezzo massimo dei prodotti presenti
                        limits : {     minLimit: 0,      maxLimit: 1000   },
                    }
                    var slider = wRunner(setting);
                </script>    
			
			<div id="buttonSubmitOrders">
				<button class="btn btn-primary">Applica</button>
			</div>
					
		</div>
		
		<div class = "col-sm-9" id = "viewOrders">
		
			<div id = "rowProduct" class="row"> <!-- a questo devo inserire la grandezza in vh -->
				<div id = "imageProductContainer"><img src="img/package.png" width="200px"></div>
				<div id = "descriptionOrder">
					<h2>Model e facturer del prodotto</h2>
					<h4>Prezzo del prodotto</h4>
					<h5>Data di acquisto</h5>
					<h6>Shipment</h6>
					<button class="btn btn-warning">Compralo di nuovo</button>
					<button class="btn btn-success">Scrivi una recensione</button>
				</div>
			</div> <!-- rowProduct -->
			
		</div> <!-- viewOrders -->
	</div> <!-- principalRowOrders -->
	
</body>
</html>