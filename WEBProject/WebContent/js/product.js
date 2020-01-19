
function Review(text, author){
	this.text = text;
	this.author = author;
	var d = new Date();
	this.date = d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();
}

var reviewsOffset = 1;

var loadOtherReviews = function(productId){
	$.getJSON( "findreviews?id=" + productId + "&offset=" + reviewsOffset, function( data ) {
		if(data.length > 0) {
			$.each(data, function (key, val) {
				$("#reviewBox").append("<h6 id=\"reviewTitle\">" + val.title + "</h6>" +
					"<p id=\"reviewText\">" + val.body + "</p>" +
					"<small id=\"author\" class=\"text-muted\">Scritta da " + val.author + "</small>" +
					"<hr>")
			});
			reviewsOffset++;
		} else {
			$("#otherReviewsButton").hide();
		}
	});
}


$(document).ready(function(){
	  $("#writeReview").click(function(){
		  $(".bg-modal").css("display", "flex");
	  });

	  $(".close").click(function(){
		  $(".bg-modal").css("display", "none");
	  });
	  
	  
});