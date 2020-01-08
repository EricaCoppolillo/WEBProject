
function placeMarker(map, location) {
  var marker = new google.maps.Marker({
    position: location,
    map: map
  });
  var infowindow = new google.maps.InfoWindow({
    content: 'Latitude: ' + location.lat() +
    '<br>Longitude: ' + location.lng()
  });
  infowindow.open(map,marker);
}


function myMap() {
	
	var myLatlng = {lat: 39.0202085, lng: 16.2472732};
	
	var mapProp= {
	  center: new google.maps.LatLng(39.0202085,16.2472732),
	  zoom: 8.2,
	};
	
	var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	google.maps.event.addListener(map, 'click', function(event) {
		placeMarker(map, event.latLng);
	});
}