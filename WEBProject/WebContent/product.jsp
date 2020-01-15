<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Techno World</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="bootstrap/js/jquery-3.4.1.js"></script>
	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
	
	
	
	<link rel="stylesheet" href="css/home.css">
	<link rel="stylesheet" href="css/product.css">
	<script src="js/product.js"></script>
</head>
<body>
	<div class="container" id="mainContainer">

	    <div class="row">
	
	      <div class="col-lg-9">
	        <div class="card mt-4">
	          <img id="productImage" class="card-img-top img-fluid" src="img/products/${product.imagePath}" alt="">
	          <div class="card-body">
	            <h3 id="name" class="card-title">${product.manufacturer} ${product.model}</h3>
	            <h4 id="price">${product.price}€</h4>
	            <p class="card-text">Descrizione:<br></p>
	            <p class="card-text" id="description">${product.description}</p>
	  		    <span class="text-warning" id="stars">
					<c:forEach var="i" begin="1" end="${product.starsAvg}">
						&#9733;
					</c:forEach>
					<c:forEach var="i" begin="1" end="${5- product.starsAvg}">
						&#9734;
					</c:forEach>
				</span>
	          </div>
	        </div>
			
			
	        <div class="card card-outline-secondary my-4">
	          <div class="card-header">Recensoni</div>
	          <div class="card-body">
	          	<div id="reviewBox" class="col">
					<c:forEach var="review" items="${product.reviews}">
						<p id="reviewText">${review.body}</p>
						<small id="author" class="text-muted">Scritta da ${review.author}</small>
						<hr>
					</c:forEach>
		         </div>
		         <a href="#" onclick="#">Altre recensioni...</a>
		         <hr>
		         <a href="#" class="btn btn-success" id="writeReview">Scrivi una recensione</a>
	          </div>
	        </div>
	      </div>
	     
	
	      <div class="col-lg-3">
	        <div class="card mt-4">
	          <div class="card-title">
	            <p style="color: lightseagreen;"><strong>Riepilogo:</strong></p>
	          </div>
	          <div class="card-text">
	            <p>${product.manufacturer} ${product.model}</p>
	            <div class="row card-text" style="margin: 0;">
	              <h4 style="color: lightseagreen;"><strong>€ ${product.price}</strong></h4>
	              <h6 style="color: lightslategrey; margin-top: 1%;">&nbsp; + spedizione gratuita</h6>
	            </div>
	
	
	          </div>
	          <div class="row" style="margin: 0; margin-bottom: 2%;">
	            <h6>Quantità:&nbsp; </h6>
	          
	            <select id="productQuantity" class="quantity__select" aria-label="Seleziona Quantità:">
	              <option value="1">1</option>
	              <option value="2">2</option>
	              <option value="3">3</option>
	              <option value="4">4</option>
	              <option value="5">5</option>
	            </select>
	          </div>
	          
	          <button type="button" class="btn btn-success">Aggiungi al carrello</button>
	
	        </div>
	      </div> <!-- lg-3 -->
	    </div> <!-- row -->
        

      </div> <!-- mainContainer -->
      
      
      <div class="bg-modal">
        <div class="modal-content">
          <div class="close">+</div>
            <h3>Scrivi recensione:</h3>
            <div class="form-group">
              <label for="usr">Nome:</label>
              <input type="text" class="form-control" id="usr">
          </div>
          <div class="form-group" style="margin: 0;">
              <label for="sel1">Valutazione: </label>
              <select class="form-control" id="sel1">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
              </select>
            </div>
          <div class="form-group">
              <label for="comment">Commento:</label>
              <textarea class="form-control" rows="5" id="comment"></textarea>
          </div>
          <a href="#" class="btn btn-success" onclick="stampa()">Invia recensione</a>
        </div>
      </div>
      
</body>
</html>