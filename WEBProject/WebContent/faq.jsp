<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FAQ</title>

	<%@ include file="include.jsp" %>
	<script src="js/faq.js"></script>
	
	<link rel="stylesheet" href="css/faq.css"> <!-- qua non so perchè lo sfondo rimane bianco se io ho incluso dei caratteri di merda buoni -->
	<link rel="stylesheet" href="css/CSShake.css">
</head>
<body onload="createSpecialTable();">
	<%@ include file="menuBar.jsp" %>


	<div id = "title" class="jumbotron">
		<div class="imageTitle"></div>
        <h1>DOMANDE FREQUENTI</h1>
        <p>Per sapere basta cliccare</p>
    </div>

 

        <div id = "container">
        
                <div class="row">
                  
                        <div id = "categoriaFaq" class = "col-sm-3">
                    <table class="table table-bordered">
                            <thead>
                                <tr><th>FAQS</th></tr>
                            </thead>
                            <tbody>
                            <!-- questi dovrebbero essere delle specie di bottoni in cui in pratica cliccando si caricano i corretti collapse (non so se si possa fare) -->
                                <tr><td id = "Registrazione" onclick="createQuestionsRegistrazione()">Registrazione e Accesso</td></tr>
                                <tr><td id = "GestioneProfilo" onclick="createQuestionsGestioneProfilo()">Gestione profilo</td></tr>
                                <tr><td id = "Acquisti" onclick="createQuestionsAcquisti()">Acquisti</td></tr>
                                <tr><td id = "Spedizioni" onclick = "createQuestionsSpedizioni()">Informazioni sulle spedizioni</td></tr>
                                <tr><td id = "ResiRimborsi" onclick = "createQuestionsResiRimborsi()">Resi e rimborsi</td></tr>
                            </tbody>
                    </table>
                </div>

                	
                <div id="istanzaDomande" class = "col-sm-9" >
                <div id = "specialTable" class = "row">
                	<table>
		            	<tr>
		            		<td> <img src = "img/tastiFAQ/l.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-little"> </td>
		            		<td><div class = "tasti"></div><td>
		            		<td> <img src = "img/tastiFAQ/d.png" class = "tasti shake-hard"> </td>
		            		<td> <img src = "img/tastiFAQ/o.png" class = "tasti shake-rotate"> </td>
		            		<td> <img src = "img/tastiFAQ/m.png" class = "tasti shake-horizontal"> </td>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/n.png" class = "tasti shake-chunk"> </td>
		            		<td> <img src = "img/tastiFAQ/d.png" class = "tasti shake-opacity"> </td>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-crazy"> </td>
		            	</tr>
		            	<tr>
		            		<td> <img src = "img/tastiFAQ/n.png" class = "tasti shake-little"> </td>
		            		<td> <img src = "img/tastiFAQ/o.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/n.png" class = "tasti shake-hard"> </td>
		            		<td><div class = "tasti"></div><td>
		            		<td> <img src = "img/tastiFAQ/e2.png" class = "tasti shake-crazy"> </td>
		            		<td><div class = "tasti"></div><td>
		            		<td> <img src = "img/tastiFAQ/m.png" class = "tasti shake-crazy"> </td>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/i.png" class = "tasti shake-vertical"> </td>
		            	</tr>
		            	<tr>
		            		<td> <img src = "img/tastiFAQ/s.png" class = "tasti shake-rotate"> </td>
		            		<td> <img src = "img/tastiFAQ/t.png" class = "tasti shake-little"> </td>
		            		<td> <img src = "img/tastiFAQ/u.png" class = "tasti shake-hard"> </td>
		            		<td> <img src = "img/tastiFAQ/p.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/i.png" class = "tasti shake-opacity"> </td>
		            		<td> <img src = "img/tastiFAQ/d.png" class = "tasti shake-chunk"> </td>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-slow"> </td>
		            	</tr>
		            	<tr>
		            		<td> <img src = "img/tastiFAQ/c.png" class = "tasti shake-rotate"> </td>
		            		<td> <img src = "img/tastiFAQ/l.png" class = "tasti shake-little"> </td>
		            		<td> <img src = "img/tastiFAQ/i.png" class = "tasti shake-hard"> </td>
		            		<td> <img src = "img/tastiFAQ/c.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/c.png" class = "tasti shake-opacity"> </td>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-chunk"> </td>
		            		<td><div class = "tasti"></div><td>
		            		<td> <img src = "img/tastiFAQ/u.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/n.png" class = "tasti shake-opacity"> </td>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-chunk"> </td>
		            		<td><div class = "tasti"></div><td>
		            		<td> <img src = "img/tastiFAQ/v.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/o.png" class = "tasti shake-opacity"> </td>
		            		<td> <img src = "img/tastiFAQ/c.png" class = "tasti shake-chunk"> </td>
		            		<td> <img src = "img/tastiFAQ/e.png" class = "tasti shake-slow"> </td>
		            	</tr>
		            	<tr>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-slow"> </td>
		            		<td><div class = "tasti"></div><td>
		            		<td> <img src = "img/tastiFAQ/s.png" class = "tasti shake-opacity"> </td>
		            		<td> <img src = "img/tastiFAQ/i.png" class = "tasti shake-chunk"> </td>
		            		<td> <img src = "img/tastiFAQ/n.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/i.png" class = "tasti shake-opacity"> </td>
		            		<td> <img src = "img/tastiFAQ/s.png" class = "tasti shake-opacity"> </td>
		            		<td> <img src = "img/tastiFAQ/t.png" class = "tasti shake-chunk"> </td>
		            		<td> <img src = "img/tastiFAQ/r.png" class = "tasti shake-slow"> </td>
		            		<td> <img src = "img/tastiFAQ/a.png" class = "tasti shake-opacity"> </td>
		            		
		            	</tr>
	            	</table>
                </div>
            	
            		<br>
                	<button onclick="createQuestionsRegistrazione()" id = "buttonCenterFaq" type="button" class="btn btn-secondary">Inizia</button>
                	
                </div> <!-- chiude il div di istanze domande -->
            </div>
        </div>
         <br>
         <br>
        <a id = "usbVolante"><img src="img/usb.png"></a>
	
	<%@ include file="footer.jsp" %>


	
</body>
</html>