var cartProducts = [];
var cartProductsQuantity = [];
var userId;
var totalPrice;

function addCardProduct(productId, quantity) {
	cartProducts.push(productId);
	cartProductsQuantity.push(quantity);
}

function setUserId(Id) {
	userId = Id;
}

function setTotalPrice(price) {
	totalPrice = price.toFixed(2);
}

function removeCartProduct(idProduct) {
	
	var rowId = "#rowProduct"+idProduct;
	$(rowId).remove();

	var indexToRemove = -1;

	for (var i = 0; i < cartProducts.length; i++){
		if(cartProducts[i] == idProduct){
			indexToRemove = i;
		}
	}

	if(indexToRemove > 0) {
		cartProducts.splice(indexToRemove, 1);
		cartProductsQuantity.splice(indexToRemove, 1);
	}

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

	for (var i = 0; i < cartProducts.length; i++){
		if(cartProducts[i] == idProduct){
			cartProductsQuantity[i] = newQuantity;
		}
	}

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


$(document).ready(function(){
	 
    $("#radio2").click(function() {
        $("#shipment").css("display","");
    });
    $("#radio1").click(function() {
        $("#shipment").css("display","none");
    });

	paypal.Buttons({
		createOrder: function(data, actions) {
			$('#products').hide();
			$('#shipmentcontainer').hide();
			$('#goToPayment').removeClass("col-sm-3");
			$('#goToPayment').addClass("col-sm-12");
			$('#goToPayment').css({"right": "0%", "position":"static", "padding" : "0"});
			$('#rowTotalPrice').css({"margin": "2%"});
			return actions.order.create({
				purchase_units: [{
					amount: {
						value: totalPrice
					}
				}]
			});
		},
		onApprove: function(data, actions) {
			return actions.order.capture().then(function(details) {
				alert('Transaction completed by ' + details.payer.name.given_name);

				return fetch('completedpayment', {
					method: 'post',
					headers: {
						'content-type': 'application/json'
					},
					body: JSON.stringify({
						orderID: data.orderID,
						userID: userId,
						products: cartProducts,
						productsQuantity: cartProductsQuantity
					})
				});
			});
		}
	}).render('#paypal-button-container');

});
