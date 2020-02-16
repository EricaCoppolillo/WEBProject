function infoWindow(id, marker, map) {
	
	var info;
	if(id == 1) {
		info = new google.maps.InfoWindow({
			content: 'Store Cosenza'
		});
	}
	
	if(id == 2) {
		 info = new google.maps.InfoWindow({
			content: 'Store Catanzaro'
		});
	}
	
	if(id == 3) {
		 info = new google.maps.InfoWindow({
			content: 'Store Crotone'
		});
	}
	
	if(id == 4) {
		 info = new google.maps.InfoWindow({
			content: 'Store Vibo Valentia'
		});
	}
	
	if(id == 5) {
		 info = new google.maps.InfoWindow({
			content: 'Store Reggio Calabria'
		});
	}
	info.open(map,marker);

}

var map;

function loadMarkers(coords) {
	
	var mapProp= {
	  center: new google.maps.LatLng(39.0202085,16.2472732),
	  zoom: 8.2,
	};
			
//	map = new google.maps.Map(document.getElementById('googleMap'),mapProp);
	
	var list = JSON.parse(coords);
	var id = 1;
	var markers = [];
	for(let i=0; i<list.length-1; i+=2) {
		var parsedLocation = new google.maps.LatLng(list[i],list[i+1]);
		var marker = new google.maps.Marker({
		    position: parsedLocation,
		    map: map,
		    title: 'Clicca per zoomare'
		  });
		markers.push(marker);
	}
	
	for(let i=0; i<markers.length; i++) {
		markers[i].addListener('click', function() {
		    map.setZoom(18);
		    map.setCenter(markers[i].getPosition());
		 });
		
		markers[i].addListener('mouseover', function() {
			infoWindow(i+1,markers[i],map);
		});
	}
}

function myMap() {
	
	var mapProp= {
	  center: new google.maps.LatLng(39.0202085,16.2472732),
	  zoom: 8.2
	};
	
	map = new google.maps.Map(document.getElementById('googleMap'), mapProp);
	directionsService = new google.maps.DirectionsService();
	directionsRenderer = new google.maps.DirectionsRenderer();
	directionsRenderer.setMap(map);
	
	
	
    var card = document.getElementById('pac-card');
    var input = document.getElementById('pac-input');
    var types = document.getElementById('type-selector');
    var strictBounds = document.getElementById('strict-bounds-selector');

    var autocomplete = new google.maps.places.Autocomplete(input);

   // Bind the map's bounds (viewport) property to the autocomplete object,
   // so that the autocomplete requests use the current map bounds for the
   // bounds option in the request.
    autocomplete.bindTo('bounds', map);

   // Set the data fields to return when the user selects a place.
    autocomplete.setFields(['address_components', 'geometry', 'icon', 'name']);

    var infowindow = new google.maps.InfoWindow();
    var infowindowContent = document.getElementById('infowindow-content');
//    infowindow.setContent(infowindowContent);
   
    autocomplete.addListener('place_changed', function() {
      infowindow.close();
      var place = autocomplete.getPlace();
      if (!place.geometry) {
       // User entered the name of a Place that was not suggested and
       // pressed the Enter key, or the Place Details request failed.
        window.alert("No details available for input: '" + place.name + "'");
        return;
      }
 
     // If the place has a geometry, then present it on a map.
      if (place.geometry.viewport) {
//        map.fitBounds(place.geometry.viewport);
      } else {
        map.setCenter(place.geometry.location);
      }
     

      var position = new google.maps.LatLng(place.geometry.location.lat(), place.geometry.location.lng())
      var marker = new google.maps.Marker({
         position: position,
         optimized: false,
         visible: true,
         map: map,
      });
     

      var address = '';
      if (place.address_components) {
       address = [
         (place.address_components[0] && place.address_components[0].short_name || ''),
         (place.address_components[1] && place.address_components[1].short_name || ''),
         (place.address_components[2] && place.address_components[2].short_name || '')
       ].join(' ');
      } 

      infowindowContent.children['place-icon'].src = place.icon;
      infowindowContent.children['place-name'].textContent = place.name;
      infowindow.setContent(place.name);
      infowindow.open(map, marker);
    });

   // Sets a listener on a radio button to change the filter type on Places
   // Autocomplete.
    function setupClickListener(id, types) {
      var radioButton = document.getElementById(id);
      radioButton.addEventListener('click', function() {
        autocomplete.setTypes(types);
      });
    }

    setupClickListener('changetype-all', []);
    setupClickListener('changetype-address', ['address']);
    setupClickListener('changetype-establishment', ['establishment']);
    setupClickListener('changetype-geocode', ['geocode']);

    document.getElementById('use-strict-bounds').addEventListener('click', function() {
          autocomplete.setOptions({strictBounds: this.checked});
    });
}


function calcRoute() {
  var start = document.getElementById('pac-input').value;
  var end = document.getElementById('end').value;
  var request = {
    origin: start,
    destination: end,
    travelMode: 'DRIVING'
  };
  directionsService.route(request, function(result, status) {
    if (status == 'OK') {
      directionsRenderer.setDirections(result);
    }
  });
}