//function that defines the possibility to see an image as miniature
function loadPhoto() {
	var element = document.getElementById("formControlFile");
	console.log(element.value);
	
	var array = element.value.split("\\");
	
	var path = "img/"+array[array.length-1]; //CONTROLLARE BENE QUESTA COSA
	console.log(path);
	
	var divContainer = document.getElementById("imageInsertProduct");
	divContainer.setAttribute("class","col-sm-7 imageModified");
	var img = document.createElement("img");
	img.src = path;
	img.style.maxWidth = "100%";
	img.style.maxHeight = "100%";
	img.style.position = "relative";
	
	document.getElementById("imageInsertProduct").innerHTML = "";
	document.getElementById("imageInsertProduct").appendChild(img);
	
}

