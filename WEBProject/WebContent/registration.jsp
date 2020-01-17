<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrazione</title>

	<%@ include file="include.jsp" %>  
	<link rel="stylesheet" href="css/login.css">
	
</head>
<body>

	<div id="container">
		<div id="divLogo">
			<a href="home">
				<img id="logoLogin" src="img/logo2.png">
			</a>
		</div>
		<form method="post" action="registration" class="needs-validation" novalidate>
		
		  <div class="form-group">
		 	<label for="name">Inserisci il tuo Nome</label>
			<input type="text" class="form-control" id="name" placeholder="Nome" name="name" required>	    
		    <!-- <div class="invalid-feedback">Per favore, riempi questo campo</div> -->
		  </div>
		  
		  <div class="form-group">
		 	<label for="surname">Inserisci il tuo Cognome</label>
			<input type="text" class="form-control" id="surname" placeholder="Cognome" name="surname" required>		    
		    <!-- <div class="invalid-feedback">Per favore, riempi questo campo</div> -->
		  </div>
		
		  <div class="form-group">
			 <label>Seleziona la tua Data di Nascita</label>
			 <input type="date" name="date" class="form-control" required>
		  </div>
		  
		  <div class="form-group">
		 	<label for="uname">Inserisci il tuo Indirizzo e-mail</label>
			<input type="text" class="form-control" id="email" placeholder="Email" name="email" required>
		    <div class="valid-feedback">Indirizzo e-mail valido.</div>		    
		    <div class="invalid-feedback">Per favore, riempi questo campo</div>
		  </div>
		  
		  <div class="form-group">
		 	<label for="uname">Inserisci il tuo Username</label>
			<input type="text" class="form-control" id="username" placeholder="Username" name="username" required>
		    <div class="valid-feedback">Username valido.</div>		    
		    <div class="invalid-feedback">Per favore, riempi questo campo</div>
		  </div>
		  
		  <div class="form-group">
		    <label class="insert" for="pwd">Inserisci la tua Password</label>
		    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
		    <div class="valid-feedback">Password valida.</div>
		    <div class="invalid-feedback">Per favore, riempi questo campo</div>
		  </div>
		  
		  <div class="form-group">
		 	<label for="uname">Inserisci la Domanda di Sicurezza</label>
			<input type="text" class="form-control" id="question" placeholder="Domanda" name="question" required>	    
		    <div class="invalid-feedback">Per favore, riempi questo campo</div>
		  </div>
		  
		  <div class="form-group">
		 	<label for="uname">Inserisci la Risposta di Sicurezza</label>
			<input type="text" class="form-control" id="answer" placeholder="Risposta" name="answer" required>
		    <div class="invalid-feedback">Per favore, riempi questo campo</div>
		  </div>
		  
<!-- 		  <div class="form-group form-check"> -->
<!-- 		    <label class="form-check-label"> -->
<!-- 		      <input class="form-check-input" type="checkbox" name="remember" required>Accetto le Condizioni d'Uso -->
<!-- 		      <div class="valid-feedback">Valida</div> -->
<!-- 		      <div class="invalid-feedback">Accetta le condizioni per accedere</div> -->
<!-- 		    </label> -->
<!-- 		  </div> -->
		  
		  <div class="col text-center">
		  	<input type="submit" class="btn btn-primary" value="Registrati" />
		  </div>
		</form>
	</div>
	
	<!-- Footer -->
	<hr>
	<footer class="page-footer font-small blue pt-4">
	  <div class="footer-copyright text-center py-3">� 2020 Copyright:
	    <a href="https://mdbootstrap.com/education/bootstrap/"> progettoSIW.it</a>
	  </div>
	</footer>
	<!-- Footer -->

	<script>
	// Disable form submissions if there are invalid fields
		(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    // Get the forms we want to add validation styles to
		    var forms = document.getElementsByClassName('needs-validation');
		    // Loop over them and prevent submission
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
		          event.preventDefault();
		          event.stopPropagation();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		  
		  
		})();
	</script>
	
	
	
	


</body>
</html>