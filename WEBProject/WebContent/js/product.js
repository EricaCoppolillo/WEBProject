
function Review(text, author){
	this.text = text;
	this.author = author;
	var d = new Date();
	this.date = d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();
}


$(document).ready(function(){
	  $("#writeReview").click(function(){
		  $(".bg-modal").css("display", "flex");
	  });

	  $(".close").click(function(){
		  $(".bg-modal").css("display", "none");
	  });
	  
	  
});