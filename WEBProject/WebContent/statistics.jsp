<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="menuBar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statistiche</title>
<%@ include file="include.jsp" %>
<script src="js/chart.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script> -->
<link rel="stylesheet" href="css/statistics.css">
<link rel="stylesheet" href="css/chart.css">


</head>
<body>
	
	<div id = "title" class = "jumbotron">
		<div class="imgTitle"></div>
		<h1 id="h1Title">Statistiche</h1>
		<p>Segui l'andamento dei prodotti presenti</p>
	</div>
	
	
	<div class = "row">
	
		<div class="col-sm-2"></div>
		
		<div id="bestProduct" class="card col-sm-10">
		
			<c:if test="${p1 != null}">
				<div class="card-body">
					<div id = "imageProductContainer"><img src="img/products/${p1.imagePath}" width="200px"></div>
					<h3>Smartphone più venduto</h3>
					<div>${p1.model}${p1.manufacturer}</div>
					<div>${p1.price}</div>
				</div>
			</c:if>
			<c:if test="${p1 == null}">
				<div class="card-body">
					<div id = "imageProductContainer"><img src="img/package.png" width="200px"></div>
					<div>Non e' stato ancora acquistato nessun prodotto della categoria Smartphone</div>	
				</div>
			</c:if>
			
			<c:if test="${p2 != null}">
				<div class="card-body">
					<div id = "imageProductContainer"><img src="img/products/${p2.imagePath}" width="200px"></div>
					<h3>Hardware più venduto</h3>
					<div>${p2.model}${p2.manufacturer}</div>
					<div>${p2.price}</div>
				</div>
			</c:if>
			<c:if test="${p2 == null}">
				<div class="card-body">
					<div id = "imageProductContainer"><img src="img/package.png" width="200px"></div>
					<div>Non e' stato ancora acquistato nessun prodotto della categoria Laptop</div>	
				</div>
			</c:if>
			
			<c:if test="${p3 != null}">
				<div class="card-body">
					<div id = "imageProductContainer"><img src="img/products/${p3.imagePath}" width="200px"></div>
					<h3>Hardware più venduto</h3>
					<div>${p3.model}${p3.manufacturer}</div>
					<div>${p3.price}</div>
				</div>
			</c:if>
			<c:if test="${p3 == null}">
				<div class="card-body">
					<div id = "imageProductContainer"><img src="img/package.png" width="200px"></div>
					<div>Non e' stato ancora acquistato nessun prodotto della categoria Hardware</div>	
				</div>
			</c:if>
			
			
			<c:if test="${p4 != null}">
				<div class="card-body">
					<div id = "imageProductContainer"><img src="img/products/${p4.imagePath}" width="200px"></div>
					<h3>Hardware più venduto</h3>
					<div>${p4.model}${p4.manufacturer}</div>
					<div>${p4.price}</div>
				</div>
			</c:if>
			<c:if test="${p4 == null}">
				<div class="card-body">
					<div id = "imageProductContainer"><img src="img/package.png" width="200px"></div>
					<div>Non e' stato ancora acquistato nessun prodotto della categoria Accessori</div>	
				</div>
			</c:if>
		
		</div>
			
		
	</div>
	
	<div id="titleGraph"><h1>Acquisti per categoria</h1></div>
	<div id="divGraph" class = "row">
		
		<canvas id="myChart" width="200" height="200"></canvas>
		<script>
		var numberOfSmartphone = '${numberOfSmartphone}';
		var numberOfLaptop = '${numberOfLaptop}';
		var numberOfHardware = '${numberOfHardware}';
		var numberOfAccessories = '${numberOfAccessories}';
		var ctx = document.getElementById('myChart').getContext('2d');
		var myChart = new Chart(ctx, {
		    type: 'horizontalBar',
		    data: {
		        labels: ['Smartphone', 'Laptop', 'Hardware','Accessori'],
		        datasets: [{
		            label: "singolo acquisto per categoria",
		            data: [numberOfSmartphone, numberOfLaptop, numberOfHardware,numberOfAccessories], //questi numeri devono essere sostituiti con i valori delle varie query che contengono gli acquisti per categoria
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		                'rgba(12, 206, 96, 0.2)',
		            ],
		            borderColor: [
		                'rgba(255, 99, 132, 1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(12, 206, 86, 1)',
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero: true
		                }
		            }]
		        }
		    }
		});
		</script>
	</div>
	<br><br><br><br><br><br><br><br><br>
	<div id="titleGraph"><h1>Capitale incassato per categoria</h1></div>
	<div id="divGraph" class = "row">
		
		<canvas id="myChart2" width="100" height="100"></canvas>
		<script>
		var numberOfSmartphone = '${priceSmartphone}';
		var numberOfLaptop = '${priceLaptop}';
		var numberOfHardware = '${priceHardware}';
		var numberOfAccessories = '${priceAccessories}';
		var ctx = document.getElementById('myChart2').getContext('2d');
		var myChart = new Chart(ctx, {
		    type: 'pie',
		    data: {
		        labels: ['Smartphone', 'Laptop', 'Hardware','Accessori'],
		        datasets: [{
		            label: "singolo acquisto per categoria",
		            data: [numberOfSmartphone, numberOfLaptop, numberOfHardware,numberOfAccessories], //questi numeri devono essere sostituiti con i valori delle varie query che contengono gli acquisti per categoria
		            backgroundColor: [
		                'rgba(22, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(5, 206, 86, 0.2)',
		                'rgba(255, 99, 132, 0.2)',
		            ],
		            borderColor: [
		                'rgba(22, 99, 132, 1)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(5, 206, 86, 1)',
		                'rgba(255, 99, 132, 0.2)',
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero: true
		                }
		            }]
		        }
		    }
		});
		</script>
	</div>
	

	
</body>
</html>