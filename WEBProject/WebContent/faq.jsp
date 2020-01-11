<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- le cose che devo capire in questa pagina è:
1.il css non funziona e non so perche
2.va messo qualcosa per abbellimento
3. devo aggiungere dei bottoni nella "tabella" di sinistra affinche possa cambiare le domande che ho presenti sulla destra nei collapse
4.far funzionare il link che non funziona anche se ho fatto un mapping server ecc.  
5. controllare se la riga 3 ho fatto bene a metterla o no-->

	<script src="https://www.w3schools.com/lib/w3.js"></script>
	
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="bootstrap/js/jquery-3.4.1.js"></script>
	<script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="js/faq.js"></script>
	
	<link rel="stylesheet" href="css/faq.css"> <!-- qua non so perchè lo sfondo rimane bianco se io ho incluso dei caratteri di merda buoni -->
	<link rel="stylesheet" href="css/CSShake.css">
</head>
<body>
<!-- dal momento che si tratta di una pagina jsp statica allora premetto che saro e scrivero solo cose essenziali -->
	<div w3-include-html="menuBar.jsp"></div>
	<script>w3.includeHTML();</script>
	


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
                                <tr><td id = "Registrazione" onclick="creaDomandeRegistrazione()">Registrazione e Accesso</td></tr>
                                <tr><td id = "GestioneProfilo" onclick="creaDomandeGestioneProfilo()">Gestione profilo</td></tr>
                                <tr><td id = "Acquisti" onclick="creaDomandeAcquisti()">Acquisti</td></tr>
                                <tr><td id = "Spedizioni" onclick = "creaDomandeSpedizioni()">Informazioni sulle spedizioni</td></tr>
                                <tr><td id = "ResiRimborsi" onclick = "creaDomandeResiRimborsi()">Resi e rimborsi</td></tr>
                            </tbody>
                    </table>
                </div>

                	
                <div id="istanzaDomande" class = "col-sm-9" >
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
            		<br>
                	<button onclick="creaDomandeRegistrazione()" id = "buttonCenterFaq" type="button" class="btn btn-secondary">Inizia</button>
                	
                </div>
            </div>
        </div>
         <br>
         <br>
        <!-- Footer -->
        <a id = "usbVolante"><img src="img/usb.png"></a>
	<footer class="page-footer font-small blue pt-4">
	  <div class="footer-copyright text-center py-3">© 2020 Copyright:
	    <a href="https://mdbootstrap.com/education/bootstrap/"> progettoSIW.it</a>
	  </div>
	</footer>
	<!-- Footer -->


	
</body>
</html>