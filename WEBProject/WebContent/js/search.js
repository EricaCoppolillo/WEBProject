/**
 * 
 */

$(document).ready(function(){
  $(".wrunner__handle").change(function(){
	  console.log("CIAO");
  });
});



function createProduct(id, img, manufacturer, model, price, description, starsAvg){
	$("#productBox").append("<div class=\"col-lg-4 col-md-6 mb-4\">");
    $(".col-lg-4").append("<div id=\"card\" class=\"card h-100\">");
    $("#card").append("<a href=\"product?id="+id+"\"><img class=\"card-img-top img-thumbnail\" src=img/products/"+img+" alt=\"\"></a>");
    $("#card").append("<div id=\"card-body\" class=\"card-body\">");
    $("#card-body").append("<h4 class=\"card-title\"><a href=\"product?id="+id+"\">"+manufacturer+" "+model+"</a></h4><h5>"+price+"€</h5><p class=\"card-text\">"+description+"</p>");
    $("#card-body").append("<div class=\"card-footer\"><small id=\"stars\" class=\"text-muted\"></small></div>");
   
    for(var i = 1; i<=5; i++){
        if(i<=starsAvg){
        	$("#stars").html($("#stars").html()+"&#9733;");
        }
        else {
        	$("#stars").html($("#stars").html()+"&#9734;");
        }
    }
    $("#stars").css("margin-left", "0");
	
	
	
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
		$.get("searchjson?p="+page, function(responseJson) {         
		    $.each(responseJson, function(index, product) { 
		       createProduct(product.id, product.img, product.manufacturer, product.model, product.price, product.description, product.stars);
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
	console.log(actualPage);
	return outcome;
	
}


