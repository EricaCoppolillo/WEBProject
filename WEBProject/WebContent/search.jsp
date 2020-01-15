<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Smartphone</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="bootstrap/js/jquery-3.4.1.js"></script>
        <script src="bootstrap/js/jquery-3.3.1.slim.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/home.css">

        <!-- link per lo slider a 2 cursori -->
        <link rel="stylesheet" href="css/wrunner-default-theme.css">
        <script src="js/wrunner-native.js"></script>

    </head>
    <body>

        <div class="row">
            <div class="col-sm-2">
                <a href="http://localhost:8080/Progetto/home.html?">
                    <img id="logo" class="thumbnails" src="img/logo.png" width="100" height="100">
                </a>
            </div>
            <div id="whoWeAre" class="col-sm-1">Chi Siamo</div>
            <div class="col-sm-1"></div>
            <div id="faq" class="col-sm-1">FAQ</div>
            <div class="col-sm-1"></div>
            <div id="assistance" class="col-sm-1">Assistenza</div>
            <div class="col-sm-1"></div>

            <div class="col-sm-2">
                <form id="search" action="">
                    <div class="p-1 bg-light rounded rounded-pill shadow-sm mb-4">
                        <div class="input-group">
                            <input type="search" aria-describedby="searchIcon" class="form-control border-0 bg-light">
                            <div class="input-group-append">
                                <button id="searchIcon" type="submit" class="btn btn-link-dark"><i class="fa fa-search"></i></button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="col-sm-1">
                <button id="register" class="btn btn-outline-secondary">Registrati</button>
            </div>
            <div class="col-sm-1">
                <button id="login" class="btn btn-outline-secondary">Login</button>
            </div>

        </div>

        <div class="col-sm-14">
            <div id="demo" class="carousel slide my-4" data-ride="carousel">
                <!-- Indicators -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                </ul>

                <!-- The slideshow -->
                <div class="carousel-inner">
                    <div class="carousel-item">
                        <img class="carousel-img" src="img/phone.jpg" alt="Cellulari">
                        <button id="buttonPhone" class="btn btn-outline-primary">Smartphones Piu' Venduti</button>
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Smartphone</h5>
                            <p>Il massimo della tecnologia</p>
                        </div>

                    </div>
                    <div class="carousel-item active">
                        <img class="carousel-img" src="img/computer.jpg" alt="Laptop">
                        <button id="buttonLaptop" class="btn btn-outline-dark">Laptop Piu' Venduti</button>
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Laptop</h5>
                            <p>Il massimo della tecnologia</p>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <img id="imgCpu" class="carousel-img" src="img/cpu.jpg" alt="Cuffie">
                        <button id="buttonHardware" class="btn btn-outline-light">Hardware Piu' Venduti</button>
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Hardware</h5>
                            <p>Il massimo della tecnologia</p>
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
        </div>


        <div class="jumbotron text-center">
            <h1>TechnoWorld</h1>
            <h3>${category.name} in vendita</h3>
        </div>



        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3">




                    <form>
                        <fieldset>
                            <h4>Ordina per:</h4>
                            <select id="ordinaPer" >
                                <option value="Consigliati" selected="selected">Consigliati </option>
                                <option value="Prezzo: Crescente">Prezzo: Crescente </option>
                                <option value="Prezzo: Crescente">Prezzo: Decrescente </option>
                            </select>
                        </fieldset>
                    </form>









                    <h4><br></br>Filtra per:</h4>

                    <div class="container">
                        <div id="accordion">
                            <div class="card">
                                <div class="card-header">
                                    <a class="card-link" data-toggle="collapse" href="#collapseOne">Brand: </a>
                                </div>
                                <div id="collapseOne" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        <c:forEach var="manufacturer" items="${manufacturers}">
                                            <a class="list-group-item d-flex justify-content-between align-items-center">${manufacturer.name}<span class="badge badge-primary badge-pill">${manufacturer.products}</span></a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header">
                                    <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">Schermo: </a>
                                </div>
                                <div id="collapseTwo" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        <a class="list-group-item d-flex justify-content-between align-items-center">6"<span class="badge badge-primary badge-pill">12</span></a>
                                        <a class="list-group-item d-flex justify-content-between align-items-center">5"<span class="badge badge-primary badge-pill">22</span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header">
                                    <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">Processore:</a>
                                </div>
                                <div id="collapseThree" class="collapse" data-parent="#accordion">
                                    <div class="card-body">
                                        <a class="list-group-item d-flex justify-content-between align-items-center">Intel<span class="badge badge-primary badge-pill">12</span></a>
                                        <a class="list-group-item d-flex justify-content-between align-items-center">Snadragon<span class="badge badge-primary badge-pill">22</span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <h4><br>Prezzo:</h4>
                    <div class="my-js-slider"></div>

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
            <ul class="pagination justify-content-center" style="margin:20px 0">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item active"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </footer>
    </body>
</html>

