<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="menuBar.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Home</title>
	
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="bootstrap/js/jquery-3.4.1.js"></script>
	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<link rel="stylesheet" href="css/home.css">
	
</head>
<body>

	<div id="carouselBox" class="row">
		<div class="col">
			<div id="demo" class="carousel slide" data-ride="carousel">
		  		<!-- Indicators -->
			  <ul class="carousel-indicators">
			    <li data-target="#demo" data-slide-to="0" class="active"></li>
			    <li data-target="#demo" data-slide-to="1"></li>
			    <li data-target="#demo" data-slide-to="2"></li>
			  </ul>
			
			  <!-- The slideshow -->
			  <div class="carousel-inner">
			    <div id="carouselPhone" class="carousel-item">
			      <img class="carousel-img" src="img/phone.jpg" alt="cellulari">
			      <button id="buttonPhone" class="btn btn-outline-primary">Smartphones Piu' Venduti</button>
			      <div class="carousel-caption d-none d-md-block">
				    <h5 class="carouselText">Smartphone</h5>
				    <p class="carouselText">Il massimo della tecnologia</p>
				  </div>
			      
			    </div>
			    <div id="carouselLaptop" class="carousel-item active">
			      <img id="carouselImg2" class="carousel-img" src="img/computer.jpg" alt="laptop">
			      <button id="buttonLaptop" class="btn btn-outline-light">Laptop Piu' Venduti</button>
			      <div class="carousel-caption d-none d-md-block">
				    <h5 class="carouselText">Laptop</h5>
				    <p class="carouselText">Il massimo della tecnologia</p>
				  </div>
			    </div>
			    
			    <div id="carouselHardware" class="carousel-item">
			      <img class="carousel-img" src="img/cpu.jpg" alt="cpu">
		      	  <button id="buttonHardware" class="btn btn-outline-light">Hardware Piu' Venduti</button>
		      	  <div class="carousel-caption d-none d-md-block">
				    <h5 class="carouselText">Hardware</h5>
				    <p class="carouselText">Il massimo della tecnologia</p>
				  </div>
			    </div>
			  </div>
			
			  <!-- Left and right controls -->
			  <a class="carousel-control-prev" href="#demo" data-slide="prev">
			    <span class="carousel-control-prev-icon"></span>
			  </a>
			  <a class="carousel-control-next" href="#demo" data-slide="next">
			    <span class="carousel-control-next-icon"></span>
			  </a>
			</div>
		</div>
	</div>
	
	
	
	 <div class="jumbotron text-center">
		<h1>TechnoWorld</h1>
		<h3>Entra in un mondo di pura tecnologia</h3>
	</div>
	
	
	<!-- <div class="lastArrives"">
		<h4>Ultimi Arrivi</h4> 
		<h6>Scopri i prodotti piu' recenti</h6>
	</div> -->
	
	
	
	<div class="row">
		<div class="col-sm-12">
		<div class="smartphoneCategory">
			<h1>SmartPhone</h1>
    		<p><a href="...html">Acquista ></a></p>
 	    	<div class="imageSmartphone"></div>
		</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-12">
			<div class="laptopCategory">
		   		<h1>Laptop</h1>
		   		<p><a href="...html">Acquista ></a></p>
			    <div class="imageLaptop"></div>
			</div>
	    </div>
	</div>
	
	<div class="row">
		<div class="col-sm-6">
			<div class="hardwareCategory">
		    	<div class="imageHardware"></div>
		    	<h1>Hardware</h1>
		    	<p><a href="...html">Acquista ></a></p>
    		</div>
    	</div>
	   	
	   	<div class="col-sm-6">
			<div class="accessoryCategory">
		   		<div class="imageAccessory"></div>
		   		<h1>Accessori</h1>
		   		<p><a href="...html">Acquista ></a></p>
	   		</div>
		</div>
	</div>
	
	<hr>
	
	<!-- Footer -->
	<footer class="page-footer font-small blue pt-4">
	  <div class="footer-copyright text-center py-3">© 2020 Copyright:
	    <a href="https://mdbootstrap.com/education/bootstrap/"> progettoSIW.it</a>
	  </div>
	</footer>
	<!-- Footer -->


</body>
</html>