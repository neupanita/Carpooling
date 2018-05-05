var start = [];
var end = [];
var curLocation = $('#user-city').val();

$(function weather() {
	$(document).ready(function() {
		$("#locweather").trigger("click");
		$.ajax({
			url:'DisplayPost',
			type:'POST',
			headers: {
				Accept:"application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			success:function(result) {
				$.each(result.JSONDATA,function(i, data) {
					if(isNaN(data.fromlocation) && isNaN(data.tolocation)) {
						start.push(data.fromlocation);
						end.push(data.tolocation);
					}
				});
			},
			error:function(exception) {
				console.log(exception);
			}
		});
	});
});	

$(function weather() {
	$("#locweather").click(function() {
		$("#weather_display").empty(); 
		$("#location_result").empty(); 
		var city = "";
		city = $('#user-city').val();
		var api = "http://api.openweathermap.org/data/2.5/forecast?q=";
		var countryCode = ",us";
		var apiKey = "&appid=97f9ce027149ca1b3d324cddf8e2bcd7"; 
		var units = "&units=metric&mode=json";
		if((city == "") || (!isNaN(curLocation))) {
			city = curLocation;
			console.log(city);
		} else {
			$.get("http://ipinfo.io", function(response) {
				city = response.city;
				console.log(city);
			}, "jsonp");
		}

		var url = api + city + countryCode + units + apiKey;
		if(city!="") {
			var weekdays = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
			var listIndex = [3, 11, 19, 27, 35];
			$.get(url).done(function(data) {
				var content = "";
				for(let i=0; i<listIndex.length; i++) {
					let index = listIndex[i];
					content += 
						"<div class='forecast'>" + weekdays[new Date(data.list[index].dt_txt).getDay()] +
							"<img src='http://openweathermap.org/img/w/"+data.list[index].weather[0].icon+".png'/>"+
							"<span>" + data.list[index].main.temp+" &#8451;  </span>" +
							"<span>," + data.list[index].weather[0].description+"</span>" +
						"</div>";
				}
				$("#weather_display").append(content);

			})
			.fail(function(xhr, status, exception) {
				console.log(exception);
			})	
		}
	});
});

function initMap() {
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: 8,
		center: {lat: -34.397, lng: 150.644}
	});
	var geocoder = new google.maps.Geocoder();

	geocodeAddress(geocoder, map);
}

function geocodeAddress(geocoder, resultsMap) {
	var address = curLocation;
	geocoder.geocode({'address': address}, function(results, status) {
		if (status === 'OK') {
			resultsMap.setCenter(results[0].geometry.location);
			var marker = new google.maps.Marker({
				map: resultsMap,
				position: results[0].geometry.location
			});
		} else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	});
}
