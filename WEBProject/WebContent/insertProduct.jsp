<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inserimento prodotto</title>
	<%@ include file="include.jsp" %>
	
	<link rel="stylesheet" href="css/insertProduct.css">
	
</head>
<body>
	
	<%@ include file="menuBar.jsp" %>
	
	<br>
	
	<div class = "row" id = "mainRow">
		
		<div class="col-sm-1" id="leftRowInsertProduct"></div>
		
		<div class="card">
			<div class= "col-sm-11 card-body"  id="rightRowInsertProduct">
				
				<div>
					<h1>Aggiungi un prodotto al catalogo</h1>
				</div>
				
				<div class="row" id="categoryChoice">
					  <label for="sel1" class = "col-sm-2">Categoria:</label>
					  <select class="form-control col-sm-9">
					    <option>Smartphone</option>
					    <option>Laptop</option>
					    <option>Hardware</option>
					    <option>Accessori</option>
					  </select>
				</div>
				
				<br>
			
				<div class="row" id="imgChoice">
					<div class="col-sm-2">Immagine:</div>
					<div class="col-sm-7 photoCameraInsertProduct">
					</div>
				</div>
				
				<br>
				
				<div class="row">
					  <div class="col-sm-2">Titolo:</div>
					  <input type="text" class="form-control col-sm-9" id="usr">
				</div>
				
				<br>
				
				<div class="row">
					  <div class="col-sm-2">Testo dell'annuncio:</div>
					   <textarea class="form-control col-sm-9" rows="5" id="comment"></textarea>
				</div>
				
				<br>
				
				<div class="row">
					  <div class="col-sm-2">Prezzo:</div>
					  <input type="text" class="form-control col-sm-1" id="usr">
					  <div class="col-sm-2"><h3>€</h3></div>
				</div>
				
				<br>
				
				<div>
					<button id="rowSubmitInsertProduct" type="button" class="btn btn-primary">Inserisci</button>
				</div>
				
		  </div> <!-- chiude la colonna di destra -->
		</div> <!-- chiude la card della seconda colonna -->
		
<!-- 		<div class="card"> -->
<!-- 			<div class="col-sm-1"> -->
<!-- 			ciao -->
<!-- 			</div> -->
<!-- 		</div> -->

<!--  	<div class="col-lg-3"> -->
<!-- 	        <div class="card"> -->
<!-- 	          <div class="card-title"> -->
<!-- 	            <h3 id="summary"><strong>Ricorda che...</strong></h3> -->
<!-- 	          </div> -->
<!-- 	          <div class="card-text"> -->
<!-- 	           Non ha senso caricare un prodotto che è già presente nel catalogo -->
<!-- 	           <br> -->
<!-- 	           Ricordati di completare correttamente tutti i campi -->
<!-- 	          </div> -->
<!-- 	        </div> -->
<!--     </div> lg-3 -->

		
			
			
	</div> <!-- chiude la riga che contiene le due colonne -->
			
		
	
	
	
	
</body>
</html>