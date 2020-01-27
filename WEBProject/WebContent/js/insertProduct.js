

function loadPhoto(url) {
	var element = document.getElementById("formControlFile");
	
	var array = element.value.split("\\");
	
	var path = "img/products"+array[array.length-1];
	if(url != "")
	{
		path = "img/products" + url;
	}
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

