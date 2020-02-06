<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chi Siamo</title>

	<%@ include file="include.jsp" %>
	<link rel="stylesheet" href="css/whoWeAre.css">
	
</head>
<body>

	<%@ include file="menuBar.jsp" %>
	
	<div id="container" class="card">
	  <div class="card-body">
	    <h2 class="card-title">Chi Siamo</h2>
	    <p class="card-text">Il gruppo che si è dedicato alla realizzazione di questo progetto è formato da:</p>
	    
		<ul>
		  <li>Erica Coppolillo</li>
		  <li>Alfredo Farò</li>
		</ul>
	    
		<div id="preLinks">Fieri e Onorati studenti dei docenti dell'<a href="https://www.mat.unical.it/demacs">Università della Calabria</a></div>
	  </div>
	</div>
	
	<%@ include file="footer.jsp" %>
	
</body>
</html>