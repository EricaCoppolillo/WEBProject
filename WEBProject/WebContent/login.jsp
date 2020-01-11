<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log-in</title>


	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<script type="text/javascript" src="js/login.js"></script>
	<script src="bootstrap/js/jquery-3.4.1.js"></script>
	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<link rel="stylesheet" href="css/login.css">
</head>
<body>

	
	<div id="container">
		<div id="divLogo">
			<a href="home">
				<img id="logo" src="img/logo2.png">
			</a>
		</div>
		
		<c:if test="${erroreLogin != null}">
		<div class="alert alert-danger alert-dismissible fade show">
	    	<div>
	    		<i class="fa fa-exclamation-triangle"></i>
	    		<strong>Attenzione!</strong>
	    		<p>Le credenziali che hai inserito non sono corrette<p>
			</div>
	    </div>
	    </c:if>
	    
		<form method="post" <c:if test="${amministratoreNonAutenticato == null}"> action="login" </c:if> <c:if test="${amministratoreNonAutenticato != null}"> action="login?admin=true" </c:if> class="needs-validation" novalidate>
		  <div class="form-group">
		 	 <c:if test="${amministratoreNonAutenticato == null}">
		    	<label for="uname">Inserisci il tuo Username</label>
		    	<a class="adminLogin" href="login?admin=true">
			  		Sei un amministratore?
			  	</a>
			</c:if>
			<c:if test="${amministratoreNonAutenticato != null}">
				<label for="uname">Inserisci il tuo ID</label>
				<a class="adminLogin" href="login?admin=false">
			  		Non sei un amministratore?
			  	</a>
			</c:if>
			<c:if test="${amministratoreNonAutenticato == null}">
		    	<input type="text" class="form-control" id="username" placeholder="Username" name="username" required>
		    	<div class="valid-feedback">Username valido.</div>
		    </c:if>
		    <c:if test="${amministratoreNonAutenticato != null}">
		    	<input type="text" class="form-control" id="id" placeholder="ID" name="id" required>
		    	<div class="valid-feedback">ID valido.</div>
		    </c:if>
		    
		    <div class="invalid-feedback">Per favore, riempi questo campo</div>
		  </div>
		  
		  <div class="form-group">
		    <label class="insert" for="pwd">Inserisci la tua Password</label>
		   	<c:if test="${amministratoreNonAutenticato == null}">
		   		<a class="forgottenPassword" href="...passwordDimenticata">
		  			Password dimenticata?
		  		</a>
		  	</c:if>
		    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
		    <div class="valid-feedback">Password valida.</div>
		    <div class="invalid-feedback">Per favore, riempi questo campo</div>
		  </div>
		  
<!-- 		  <div class="form-group form-check"> -->
<!-- 		    <label class="form-check-label"> -->
<!-- 		      <input class="form-check-input" type="checkbox" name="remember" required>Accetto le Condizioni d'Uso -->
<!-- 		      <div class="valid-feedback">Valida</div> -->
<!-- 		      <div class="invalid-feedback">Accetta le condizioni per accedere</div> -->
<!-- 		    </label> -->
<!-- 		  </div> -->

		  <c:if test="${amministratoreNonAutenticato == null}">
			  <div class="registration">
			  	Non hai ancora un account? 
			  	<a href="registration">
			  		Registrati
			  	</a>
			  </div>
		  </c:if>
		  <div class="col text-center">
		  	<input type="submit" class="btn btn-primary" value="Accedi" />
		  </div>
		</form>
	</div>
	
	<!-- Footer -->
	<hr>
	<footer class="page-footer font-small blue pt-4">
	  <div class="footer-copyright text-center py-3">© 2020 Copyright:
	    <a href="https://mdbootstrap.com/education/bootstrap/"> progettoSIW.it</a>
	  </div>
	</footer>
	<!-- Footer -->
	
	

</body>
</html>