<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="UTF-8">
<title>Mappa</title>
	
	<%@ include file="include.jsp" %>
	<script src="js/map.js"></script>
	<link rel="stylesheet" href="css/map.css">
</head>
<body>

	<%@ include file="menuBar.jsp" %>
	
<div id="route" class="row">
	<div id="divFrom" class="col-sm-6 row">	
		<div class="col-sm-1">Da: </div>
		<div class="pac-card col-sm-11" id="pac-card">
	      <div>
	        <div id="type-selector" class="pac-controls">
	          <input type="radio" name="type" id="changetype-all" checked="checked">
	          <label for="changetype-all">Tutto</label>
	
	          <input type="radio" name="type" id="changetype-establishment">
	          <label for="changetype-establishment">Stabilimenti</label>
	
	          <input type="radio" name="type" id="changetype-address">
	          <label for="changetype-address">Indirizzi</label>
	
	          <input type="radio" name="type" id="changetype-geocode">
	          <label for="changetype-geocode">Coordinate</label>
	        </div>
	        <div id="strict-bounds-selector" class="pac-controls">
	          <input type="checkbox" id="use-strict-bounds" value="">
	          <label for="use-strict-bounds">Limiti Rigorosi</label>
	        </div>
	      </div>
	      <div id="pac-container">
	        <input id="pac-input" type="text"
	            placeholder="Inserisci una località">
	      </div>
		</div>
	    
	</div>
	<div id="divTo" class="col-sm-6 row">
		<div class="col-sm-1">A: </div>
		<select id="end" class="col-sm-5" onchange="calcRoute();">
		   <option value="" disabled selected hidden>Scegli la destinazione</option>
		  <option value="catanzaro, cz">Store Catanzaro</option>
		  <option value="cosenza, cs">Store Cosenza</option>
		  <option value="crotone, kr">Store Crotone</option>
		  <option value="reggio calabria, rc">Store Reggio Calabria</option>
		  <option value="vibo valentia, vv">Store Vibo Valentia</option>
		</select>
	</div>
	
</div>
<div id="googleMap"></div>


 <div id="infowindow-content">
      <img src="" width="16" height="16" id="place-icon">
      <span id="place-name"  class="title"></span><br>
      <span id="place-address"></span>
    </div>
	
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDoq-xsFhUtC3ucI3N5wH0KVVhVJZvNa68&callback=myMap&libraries=places" onload="loadMarkers('${coords}')"></script>
	
	
	<%@ include file="footer.jsp" %>
</body>
</html>