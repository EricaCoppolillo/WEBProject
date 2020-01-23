<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica prodotto</title>
	<%@ include file="include.jsp" %>
	
	<script src="js/insertProduct.js"></script>
	
	<link rel="stylesheet" href="css/insertProduct.css">
	
</head>
<body onload="loadPhoto('${imgPathProduct}')">
	
	<%@ include file="menuBar.jsp" %>
	
	<br>
	
	<div class = "row" id = "mainRow">
		
<!-- 		<div class="col-sm-1" id="leftRowInsertProduct"></div> -->
		
		<div class="card">
			<div class= "col-sm-12 card-body"  id="rightRowInsertProduct">
			
		<form id="modulo1" class="form-horizontal" method="post" action="modifyProduct">
				<div id="titleInsertProduct">
					<h1>Modifica prodotto</h1>
				</div>
				
				
				<div class="row" id="categoryChoice">
					  <label for="sel1" class = "col-sm-2">Categoria:</label>
					  <select class="form-control col-sm-9" name="category" value="${categoryProduct}">
					    <option>Smartphone</option>
					    <option>Laptop</option>
					    <option>Hardware</option>
					    <option>Accessori</option>
					  </select>
				</div>
				
				<br>
				
				
			
				<div class="row" id="imgChoice">
					<div class="col-sm-2">Immagine:</div>
					<div id="imageInsertProduct" class="col-sm-7 photoCameraInsertProduct"></div>
				</div>

			
				
				
				  <div class="form-group" onchange="loadPhoto('');" id="insertImage">
				    <input type="file" class="form-control-file" id="formControlFile" name="path" value="${imgPathProduct}" required>
				  </div>
				
				<div class="row" id="insertTitle">
					  <div class="col-sm-2">Modello:</div>
					  <input type="text" class="form-control col-sm-9" id="usr" name="model" value = "${modelProduct}"required>
				</div>
				
				<div class="row" id="insertManufacturer">
					  <div class="col-sm-2">Produttore:</div>
					  <input type="text" class="form-control col-sm-9" id="usr" name="manufacturer"  value = "${manufacturerProduct}"required>
						<select name="productId" style = "display:none;">
	      				<option>${idProduct}</option>
	      			</select>					  
				</div>
				
			
				
				<div class="row" id="commentText">
					  <div class="col-sm-2">Descrizione del prodotto:</div>
					   <textarea class="form-control col-sm-9" rows="5" id="comment" name="description" required>${descriptionProduct}</textarea>
				</div>
				
				<div class="row" id="specificsText">
					  <div class="col-sm-2">Specifiche del prodotto:</div>
					   <textarea class="form-control col-sm-9" rows="2" id="comment" name="specifics" required>${specificsProduct}</textarea>
				</div>
				
				<div class="row" id = "priceInsertProduct">
					  <div class="col-sm-2">Prezzo (€):</div>
					  <input type="text" class="form-control col-sm-2" id="usr" name="price" value = "${priceProduct}"required>
				</div>
				
				
				<div id="rowSubmitInsertProduct">
						<button class="btn btn-primary">Invia</button>
				</div>
			</form>
		  </div> <!-- chiude la colonna di destra -->
		</div> <!-- chiude la card della seconda colonna -->
		

		
			
			
	</div> <!-- chiude la riga che contiene le due colonne -->
			
		
	<%@ include file="footer.jsp" %>
	
	
	
</body>
</html>