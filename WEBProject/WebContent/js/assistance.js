function getRandomColor() {
	
	var letters = '0123456789ABCDEF';
	var color = '#';
	for (var i = 0; i < 6; i++) {
	  color += letters[Math.floor(Math.random() * 16)];
	}
	return color;
}

function changeColor() {
	
	var comments = $(".usernameQuestion");
	var divQuestions = $(".divAssistanceComment");
	
	for(let i=0; i<comments.length; i++) {
		var color = getRandomColor();
		comments.eq(i).css({ 
	        "color": color
	    });
		divQuestions.eq(i).css({
			"border": "1px solid"+color
		});
	}
}

function answer(index, username, content) {
	
	var selInput = "#input"+index;
	var answer = $(selInput).val();
	
	if(answer != "") {
		
		$(selInput).val("");
		
		$("#containerQuestion"+index).remove();
		
		$.ajax({
			type: "POST",
			url: "assistance",
			data: {answer: answer, username: username, content: content},
			success: function(data) {}
		});
	}
}

function askQuestion() {
	
	var text = $("#inputQuestion").val();
	
	if(text != "") {
		
		$(".chatDisplay").css("visibility", "visible");
		$("#noHelp").remove();
		$("#inputQuestion").val("");
		
		var userQuestion = document.createElement("div");
		userQuestion.setAttribute("class", "divAssistanceComment");
		var you = "Tu";
		userQuestion.innerHTML = you.fontsize(4).fontcolor("#feac01") + "<br>" + text;
		document.getElementsByClassName("chatDisplay")[0].appendChild(userQuestion);
		
		var objDiv = document.getElementsByClassName("chatDisplay")[0];
		objDiv.scrollTop = objDiv.scrollHeight;
		
		$.ajax({
			type: "POST",
			url: "assistance",
			data: {question: text},
			success: function(data) {}
		}); 
	}
}

function deleteComments() {
	
	$("#noHelp").css("visibility", "visible");
	$(".chatDisplay").css("visibility", "hidden");
	
	$.ajax({
		type: "POST",
		url: "assistance",
		data: {makeEmpty: "true"},
		success: function(data) {}
	}); 
}