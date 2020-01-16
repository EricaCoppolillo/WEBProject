<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="bootstrap/js/jquery-3.4.1.js"></script>
	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<link rel="stylesheet" href="css/menuBar.css">
	
</head>
<body>

	<div id="menuBar" class="row">
		<a href="home" class="col">
		<div id="logo"></div>
		</a>
		<div id="whoWeAre" class="col">Chi Siamo</div>
		<div id="faq" class="col">
			<a href="faq">
				FAQ
			</a>
		</div>
		<div id="map" class="col">Mappa</div>
		<div id="assistance" class="col">Assistenza</div>	
		
		<div class="col">
	      <div class="d-flex justify-content-center h-100">
	        <div class="searchbar">
	          <input class="search_input" type="text" name="" placeholder="Search...">
	          <a href="#" class="search_icon"><i class="fa fa-search"></i></a>
	        </div>
	      </div>
	    </div>
         
		<div class="col">
			<c:if test="${(utente == null)}">
				<c:if test="${amministratore == null}">
					<a href="registration">
						<button id="register" class="btn btn-outline-secondary">Registrati</button>
					</a>
				</c:if> 
				<c:if test="${amministratore != null}">
					<label id="welcomeAdm" class="badge badge-pill badge-warning text-wrap">
					<span> Ciao, ${amministratore.id}</span>
					</label>
				</c:if>
			</c:if>
			<c:if test="${utente != null}">
				<%-- <p id="welcomeUser">Benvenuto, ${utente.username}</p> --%>
			</c:if>
		</div>
		<div class="col">
			<c:if test="${(utente == null) && (amministratore == null)}">
				<a href="login">
					<button id="login" class="btn btn-primary">
						Accedi
					</button>
				</a>
			</c:if>
			<c:if test="${(utente != null) || (amministratore != null)}">
				<a href="login?logout=true">
					<button id="logout" class="btn btn-primary">
						Logout
					</button>
				</a>
			</c:if>
		</div>
		
	</div>

</body>
</html>