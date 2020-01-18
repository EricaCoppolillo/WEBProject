/**
 * 
 */


$(document).ready(function(){
	
	
	$(".search_input").blur(function(){
		$(".search_input").attr("placeholder","Cerca...");
	});
	
	$(".search_input").focus(function() {
		$(".search_input").attr("placeholder","");
	})
	
	$("#search").click(function() {
		window.location.href = "search?p=1&keyword="+$(".search_input").val();
	});
	  
	  
});