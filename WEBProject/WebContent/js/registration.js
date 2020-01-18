function writeTexts(name, surname, date, username, email, question, answer, sameUsername, sameEmail) {
	
	$("#name").val(name);
	$("#surname").val(surname);
	$("#date").val(date);
	$("#username").val(username);
	$("#email").val(email);
	$("#question").val(question);
	$("#answer").val(answer);
	
	if(sameUsername != "null") {
  	  
	  $("#username").css('color', '#d70000');
  	  $("#username").css('border', '1px solid #d70000');
  	  $("#username").focusout(function() {
  		  $("#username").css('box-shadow', '0 0 0');
  		
  	  });
  	  $("#username").focus(function() {
  		  $("#username").css('box-shadow', '0px 0px 0px 3px rgba(215, 0, 0, 0.2)');
  		$("#username").css('color', 'black');
  	  });
  	
    }
    if(sameEmail != "null") {
  	  $("#email").css('color','#d70000');
  	  $("#email").css('border', '1px solid #d70000');
  	  $("#email").focusout(function() {
  		  $("#email").css('box-shadow', '0 0 0');
  	  });
  	  $("#email").focus(function() {
  		  $("#email").css('box-shadow', '0px 0px 0px 3px rgba(215, 0, 0, 0.2)');
  	  });
    }
}


