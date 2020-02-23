var username = "";
var email = "";

function onSignIn(googleUser) {

	var profile = googleUser.getBasicProfile();
	username = profile.getName();
	email = profile.getEmail();
	
	document.getElementsByTagName("span")[0].textContent="Autenticazione effettuata";
	document.getElementsByTagName("form")[0].setAttribute("novalidate", "");
	
}

function googleLogin() {
	
	console.log(username + " " + email);
	if(username != "" && email != "") {
		$.ajax({ 
			type: "GET",
			url: "login",
			data: {usernameGoogle: username, emailGoogle: email},
			success: function(data) {
			}
		});
	}
}

function signOut() {
	
  var auth2 = gapi.auth2.getAuthInstance();
  auth2.signOut().then(function () {

	  document.getElementsByTagName("span")[0].textContent="Autenticati con Google";
	  document.getElementsByTagName("form")[0].removeAttribute("novalidate");
	  $("#facebookButtonTwo").css("display","none");

	  
  });
}

function googleFoo() {
	gapi.auth2.init().then(()=>signOut())
}

function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
	    // The current login status of the person.
	if (response.status === 'connected') {   // Logged into your webpage and Facebook.
		testAPI();  
	} 
}


function checkLoginState() {               // Called when a person is finished with the Login Button.
	document.getElementsByTagName("span")[0].textContent="Autenticati con Google";
	googleFoo();
	FB.getLoginStatus(function(response) {   // See the onlogin handler
	statusChangeCallback(response);
	});
}


window.fbAsyncInit = function() {
	FB.init({
	appId      : '2916490241749280',
	cookie     : true,                     // Enable cookies to allow the server to access the session.
	xfbml      : true,                     // Parse social plugins on this webpage.
	version    : 'v6.0'           // Use this Graph API version for this call.
});


FB.getLoginStatus(function(response) {   // Called after the JS SDK has been initialized.
	statusChangeCallback(response);        // Returns the login status.
	});
};


(function(d, s, id) {                      // Load the SDK asynchronously
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) return;
	js = d.createElement(s); js.id = id;
	js.src = "https://connect.facebook.net/it_IT/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));


function testAPI() {           // Testing Graph API after login.  See statusChangeCallback() for when this call is made.
	FB.api('/me', {fields: 'name, email'}, function(response) {
		
		var username = response.name;
		var email = response.email;

		document.getElementsByTagName("form")[0].setAttribute("novalidate", "");
		
		$('#facebookButton').remove();
		$("#facebookButtonTwo").css("display","inline");

		$.ajax({
			type: "GET",
			url: "login",
			data: {usernameFacebook: username, emailFacebook: email},
			success: function(data) {
			}
		});
	});
}
