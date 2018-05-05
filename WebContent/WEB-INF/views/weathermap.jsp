<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Weather Map</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous" />

</head>

<body>
	<%
		String userSession = (String) session.getAttribute("userSession");
		if (userSession == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<div class="header">
		<%@include file="/WEB-INF/views/layout/header.jsp"%>
	</div>
	<section class="banner">
		<div class="map_container">

			<!--Weather task-->
			<div class="map_form weather_form">
				<div class="block">
					<div id="location_result"></div>
				</div>
				<div id="weather_display"></div>
				<!--lower block with two divs-->

				<div id="container_trips">
					<h1 id="weather-location">Weather of ${userCity}!!!</h1>
					<input type="button" id="trips" value="All Trips"> <input
						type="button" id="trips1" value="Trips with same Location">
					<input type="button" id="trips2" value="Trips with near Location">
					<input name='user-city' id='user-city' type='hidden'
						value="${userCity}">
					<div id="summary"></div>
				</div>
				<!--Google map-->
				<input class="map_text" type="text" id="city"
					placeholder="Search map"> <input class="map_button"
					type="button" id="locweather" value="Show Weather">
				<div id="map"></div>
			</div>
		</div>
		<!-- container end -->
	</section>
	<!-- banner end -->

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
		integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCtiMx-TubW49qgT_lgULfvzweEu1542NA&libraries=places&callback=initMap"
		async defer></script>
	<script src="js/weather_map_api.js" type="text/javascript"></script>
	<link href="css/weather_map.css" type="text/css" rel="stylesheet" />
</body>
</html>