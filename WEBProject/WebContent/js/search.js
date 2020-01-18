/**
 * 
 */

$(document).ready(function(){
  
	/*set the price range*/
	$("#apply").click(function() {
		updateProducts();
	});
	
	/*set the brand*/
	$(".list-group-item").click(function(){
		if($(this).attr("id") != "prodActive"){
			$("#prodActive").attr("id", "not");
			$(".list-group-item").removeClass("active");
			$(this).addClass("active");
			$(this).attr("id", "prodActive")
		}
		else {
			$("#prodActive").attr("id", "not");
			$(".list-group-item").removeClass("active");
		}
		
		
		updateProducts();
	});
  
});



function createProduct(id, img, manufacturer, model, price, description, starsAvg){
	$("#productBox").append("<div id=product"+id+" class=\"col-lg-4 col-md-6 mb-4\">");
    $("#product"+id).append("<div id=\"card"+id+"\" class=\"card h-100\">");
    $("#card"+id).append("<a href=\"product?id="+id+"\"><img class=\"card-img-top img-thumbnail\" src=img/products/"+img+" alt=\"\"></a>");
    $("#card"+id).append("<div id=\"card-body"+id+"\" class=\"card-body\">");
    $("#card-body"+id).append("<h4 class=\"card-title\"><a href=\"product?id="+id+"\">"+manufacturer+" "+model+"</a></h4><h5>"+price+"€</h5><p class=\"card-text\">"+description+"</p>");
    $("#card-body"+id).append("<div class=\"card-footer\"><small id=\"stars"+id+"\" class=\"text-muted\"></small></div>");
   
    for(var i = 1; i<=5; i++){
        if(i<=starsAvg){
        	$("#stars"+id).html($("#stars"+id).html()+"&#9733;");
        }
        else {
        	$("#stars"+id).html($("#stars"+id).html()+"&#9734;");
        }
    }
    $("#stars"+id).css("margin-left", "0");	
}


function updateProducts(){
	
	var categoryID = $("#categoryId").text();
	var orderBy = $("#orderBy").val();
	var filterBy = $("#prodActive").html();
	if(filterBy != undefined){
		var n = filterBy.search("<");
		filterBy = filterBy.substr(0, n);
	}
	else{
		filterBy = "";
	}
	var priceLower = ($(".wrunner__valueNote")[0].innerText);
	var priceUpper = ($(".wrunner__valueNote")[1].innerText);
	
	console.log(priceLower + " " + priceUpper);
	
	
	//, filterBy, priceLower, priceUpper
	/*
	if(orderBy == "Consigliati"){
		orderBy = "stars";
	}
	else if(orderBy == "Prezzo crescente"){
		orderBy = "priceAsc";
	}
	else if(orderBy == "Prezzo decrescente"){
		orderBy = "priceDesc";
	}
	$("#productBox").html("");
	$.get("searchjson?category="+categoryID+"&p=1"+"&orderBy="+orderBy+"&filterBy="+filterBy+"&priceFrom="+priceLower+"&priceTo="+priceUpper, function(responseJson) {         
	    $.each(responseJson, function(index, product) { 
	       createProduct(product.id, product.imagePath, product.manufacturer, product.model, product.price, product.description, product.starsAvg);
	    });
	});*/
}




function goToPage(page){ 
	var actualPage = $("a.active").text();
	console.log(page);
	if(actualPage != page){
		var pageSel = "#page"+actualPage;
		var aSel = "#a"+actualPage;
		var actualPage = parseInt(actualPage, 10);
		$(pageSel).removeClass();
		$(aSel).removeClass();
		$(pageSel).addClass("page-item");
		$(aSel).addClass("page-link");
		actualA = "#a"+page;
		actualPage = "#page"+page;
		$(actualPage).addClass("active");
		$(actualA).addClass("active");
		
		$("#productBox").html("");
		$.get("searchjson?category=2&p="+page, function(responseJson) {  //TODO category = categoryID       
		    $.each(responseJson, function(index, product) { 
		       createProduct(product.id, product.imagePath, product.manufacturer, product.model, product.price, product.description, product.starsAvg);
		    });
		});
	} 
	
}


function changePage(next, totalPages) {
	var outcome = false;
	var actualPage = $("a.active").text();
	var pageSel = "#page"+actualPage;
	var aSel = "#a"+actualPage;
	var actualPage = parseInt(actualPage, 10);
	if(next === true){
		if((actualPage+1) <= totalPages){
			$(pageSel).removeClass();
			$(aSel).removeClass();
			$(aSel).addClass("page-link");
			$(pageSel).addClass("page-item");
			pageSel = "#page"+(actualPage+1);
			aSel  = "#a"+(actualPage+1);
			$(pageSel).addClass("active");
			$(aSel).addClass("active");
			outcome = true;
		}
	}
	else {
		if ((actualPage - 1) >= 1){
			$(pageSel).removeClass();
			$(aSel).removeClass();
			$(pageSel).addClass("page-item");
			$(aSel).addClass("page-link");
			pageSel = "#page"+(actualPage-1);
			aSel  = "#a"+(actualPage-1);
			$(pageSel).addClass("active");
			$(aSel).addClass("active");
			outcome = true;
			
		}
	}
	actualPage = $("a.active").text();
	
	if(outcome === true){
		$("#productBox").html("");
		$.get("searchjson?category=2&p="+actualPage, function(responseJson) {         
		    $.each(responseJson, function(index, product) { 
		       createProduct(product.id, product.imagePath, product.manufacturer, product.model, product.price, product.description, product.starsAvg);
		    });
		});
	}
	
}


