function removeCartProduct(idProduct) {
	
	var rowId = "#rowProduct"+idProduct;
	$(rowId).remove();
	
	$.ajax({
		type: "GET",
		url: "removeCartProduct",
		data: {idProduct: idProduct},
		success: function(data) {}
	});
}
