<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="menuBar.jsp" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${category.name}</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="bootstrap/js/jquery-3.4.1.js"></script>
        <script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/search.css">
        <link rel="stylesheet" href="css/home.css">

        <!-- link per lo slider a 2 cursori -->
        <link rel="stylesheet" href="css/wrunner-default-theme.css">
       
       

    </head>
    <body>

        

        <div id="carouselBoxSearch" class="row">
		<div class="col">
			<div id="demo" class="carousel slide" data-ride="carousel">
		  		<!-- Indicators -->
			  <ul class="carousel-indicators">
			    <li data-target="#demo" data-slide-to="0" class="active"></li>
			    <li data-target="#demo" data-slide-to="1"></li>
			    <li data-target="#demo" data-slide-to="2"></li>
			  </ul>
			
			  <!-- The slideshow -->
			  <div class="carousel-inner">
			  	<div id="carousel2" class="carousel-item active">
			      <img id="img2" class="carousel-img" src="img/carousel/smartphone/2.jpg">
			  	</div>
			    <div id="carousel1" class="carousel-item">
			      <img class="carousel-img" id="img1" src="img/carousel/smartphone/1.jpg">
			    </div>
			    
			    <div id="carousel3" class="carousel-item">
			      <img class="carousel-img" id="img3" src="img/carousel/smartphone/3.jpg">
				</div>
				</div>
			  </div>
			</div>
			
			  <!-- Left and right controls -->
			  <a class="carousel-control-prev" href="#demo" data-slide="prev">
			    <span class="carousel-control-prev-icon"></span>
			  </a>
			  <a class="carousel-control-next" href="#demo" data-slide="next">
			    <span class="carousel-control-next-icon"></span>
			  </a>
		</div>
	



        <div class="jumbotron text-center" id="jumb">
            <h1>${category.name}</h1>
            <h3>in vendita</h3>
        </div>



        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3">




                    <div class="form-group">
					  <label for="sel1">Ordina per:</label>
					  <select class="form-control" id="sel1">
					    <option>Prezzo: crescente</option>
					    <option>Prezzo: Decrescente</option>
					  </select>
					</div>









                    <h4><br></br>Filtra per:</h4>

                    <div class="container">
                        <div id="accordion">
                            <div class="card">
                                <div class="card-header">
                                    <a class="card-link" data-toggle="collapse" href="#brandCollapse">Brand: </a>
                                </div>
                                <div id="brandCollapse" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        <c:forEach var="manufacturer" items="${manufacturers}">
                                            <a href="#" class="list-group-item d-flex justify-content-between align-items-center">${manufacturer.name}<span class="badge badge-primary badge-pill">${manufacturer.products}</span></a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                      
                        </div>
                    </div>


                    <h4><br>Prezzo:</h4>
                    <div class="my-js-slider"></div>
					<script src="js/wrunner-native.js"></script>
                    <script>
                        var setting = {
                            roots: document.querySelector('.my-js-slider'),
                            type: 'range',
                            step: 1,
                            //prezzo minimo e prezzo massimo dei prodotti presenti
                            limits : {     minLimit: 0,      maxLimit: 1000   },
                        }
                        var slider = wRunner(setting);




                    </script>    
                </div><!-- col -->

                <div class="col-sm-9">
                    <div class="row">
                        <!-- iterare du tutti gli elementi e prendere info -->
                        <c:forEach var="product" items="${products}">
                            <div class="col-lg-4 col-md-6 mb-4">
                                <div class="card h-100">
                                    <a href="product?id=${product.id}"><img class="card-img-top img-thumbnail" src="img/products/${product.imagePath}" alt=""></a>
                                    <div class="card-body">
                                        <h4 class="card-title">
                                            <a href="product?id=${product.id}">${product.manufacturer} ${product.model}</a>
                                        </h4>
                                        <h5>${product.price}€</h5>
                                        <p class="card-text">${product.description}</p>
                                    </div>
                                    <div class="card-footer">
                                        <small class="text-muted">
                                            <c:forEach var="i" begin="1" end="${product.starsAvg}">
                                                &#9733;
                                            </c:forEach>
                                            <c:forEach var="i" begin="1" end="${5- product.starsAvg}">
                                                &#9734;
                                            </c:forEach>
                                        </small>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div><!-- col -->
            </div><!-- row -->
        </div> <!--container-->


        <footer>
            <ul class="pagination justify-content-center" id="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item active"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </footer>
    </body>
</html>

