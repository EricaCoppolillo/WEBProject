function removeCartProduct(idProduct) {
	
	var rowId = "#rowProduct"+idProduct;
	$(rowId).remove();
	
	$.ajax({
		type: "GET",
		url: "removeCartProduct",
		data: {idProduct: idProduct},
		success: function(data) {}
	});
	
	$.ajax({
		type: "GET",
		url: "updateTotalPrice",
		success: function(data) {
			var newTotPrice = parseFloat(data);
			document.getElementById("totalPrice").innerHTML = newTotPrice.toFixed(2) + " €";
		}
	});
}

function updateFunctions(idProduct) {
	
	var selectProduct = "#productQuantity"+idProduct;
	var newQuantity = $(selectProduct).children("option:selected").val();
	$.ajax({
		type: "GET",
		url: "updateQuantity",
		data: {idProduct: idProduct, newQuantity: newQuantity},
		success: function(data) {
			var resp = data.split(" ");
				
			var divPrice = "productPrice"+idProduct;
			document.getElementById(divPrice).innerHTML = parseFloat(resp[0]).toFixed(2) + " €";
			$("#"+divPrice).css('color', '#c10d0d');
			
			var newTotPrice = parseFloat(resp[1]);
			document.getElementById("totalPrice").innerHTML = newTotPrice.toFixed(2) + " €";
		}
	});
}

function updateTotalPrice() {

	
}
