<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="596490774032-8a5cfrb4a64c6d37m9014498abo20h85.apps.googleusercontent.com">
<title>Log-in</title>

	<%@ include file="include.jsp" %>
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	<script type="text/javascript" src="js/login.js"></script>
	<link rel="stylesheet" href="css/login.css">
	
	
</head>
<body onload="googleFoo(); onSignIn()">

	<div id="container">
		<div id="divLogo">
			<a href="home">
				<img id="logoLogin" src="img/logo2.png">
			</a>
		</div>
		
		<c:if test="${loginError != null}">
		<div class="alert alert-danger alert-dismissible fade show">
	    	<div>
	    		<i class="fa fa-exclamation-triangle"></i>
	    		<strong>Attenzione!</strong>
	    		<p>Le credenziali che hai inserito non sono corrette<p>
			</div>
	    </div>
	    </c:if>
	    
		<form method="post" <c:if test="${adminNotAuthenticated == null}"> action="login" </c:if> <c:if test="${adminNotAuthenticated != null}"> action="login?admin=true" </c:if> class="needs-validation">		  
			<c:if test="${adminNotAuthenticated == null}">
			<div class="form row">
				<div class="col-sm-6 vl">
			</c:if> 
					<div <c:if test="${adminNotAuthenticated == null}"> class="form-group" </c:if> <c:if test="${adminNotAuthenticated != null}"> class="form-group adm" </c:if> >
					 	<c:if test="${adminNotAuthenticated == null}">
					 		<a class="adminLogin" href="login?admin=true">
						  		Sei un amministratore?
						  	</a>
					    	<label for="uname">Inserisci il tuo Username</label>
						</c:if>
						
						<c:if test="${adminNotAuthenticated != null}">
							<a class="adminLogin" href="login?admin=false">
						  		Non sei un amministratore?
						  	</a>
							<label for="uname">Inserisci il tuo ID</label>
						</c:if>
						
						<c:if test="${adminNotAuthenticated == null}">
					    	<input type="text" class="form-control" id="username" placeholder="Username" name="username" required>
					    	<div class="valid-feedback">Username valido.</div>
					    </c:if>
					    
					    <c:if test="${adminNotAuthenticated != null}">
					    	<input type="text" class="form-control" id="id" placeholder="ID" name="id" required>
					    	<div class="valid-feedback">ID valido.</div>
					    </c:if>
					    
					    <div class="invalid-feedback">Per favore, riempi questo campo</div>
				  </div>
				  
				  <div <c:if test="${adminNotAuthenticated == null}"> class="form-group" </c:if> <c:if test="${adminNotAuthenticated != null}"> class="form-group adm" </c:if> >
				  	<c:if test="${adminNotAuthenticated == null}">
				   		<a class="forgottenPassword" href="forgottenPassword">
				  			Password dimenticata?
				  		</a>
				  	</c:if>
				    <label class="insert" for="pwd">Inserisci la tua Password</label>
				   	
				    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
				    <div class="valid-feedback">Password valida.</div>
				    <div class="invalid-feedback">Per favore, riempi questo campo</div>
				  </div>
		
				  <c:if test="${adminNotAuthenticated == null}">
					  <div class="registration">
					  	Non hai ancora un account? 
					  	<a href="registration">
					  		Registrati
					  	</a>
					  </div>
				  </c:if>
			  
			  <c:if test="${adminNotAuthenticated == null}">
			  </div>
			  </c:if> 
			  
			  <c:if test="${adminNotAuthenticated == null}">
				  <div id="rightDiv" class="col-sm-6">
					  <div id="googleButton" class="g-signin2" data-width="300" data-onsuccess="onSignIn" onclick="googleLogin()" ></div>
					  
					  <div class="divHr row">
					  <hr class="col-sm-2">oppure<hr class="col-sm-2">
					  </div>
					  
					  <div id="facebookButton" class="fb-login-button" scope="public_profile,email" onlogin="checkLoginState()" data-width="300" data-size="large" data-button-type="login_with"  data-login_text="Autenticati con Facebook" data-auto-logout-link="false" data-use-continue-as="false"></div>
 			  	  		
 			  	  	  <div id="facebookButtonTwo" class="fb-login-button" scope="public_profile,email" data-width="300" data-size="large" data-button-type="login_with"  data-login_text="Autenticazione Effettuata" data-auto-logout-link="false" data-use-continue-as="false"></div>
 			  	  	  
 				  </div>
		  	  </c:if>
		  
		  <c:if test="${adminNotAuthenticated == null}">
		  </div>
		  </c:if> 
		  
		  <div class="col text-center">
		  	<input type="submit" class="btn btn-primary" value="Accedi" />
		  </div>
		  
		</form>
	</div>
	
	<%@ include file="footer.jsp" %>

</body>
</html>