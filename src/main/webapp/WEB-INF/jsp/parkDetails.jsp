<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<title>Park Details</title>
</head>
<body>
	<div class="content is-large">
		<h1>${park.parkname}</h1>
	</div>

	<div class="content is-medium">
		<div class="container is-fluid">
			<div class="notification">
				<p>${park.parkdescription}</p>
			</div>
		</div>
	</div>



	<div class="content is-medium">
		<ul>
			<li>${park.state}</li>
			<li>Established in ${park.yearfounded}</li>
			<c:if test="${park.entryfee == 0}">
				<li>No entrance fee</li>
			</c:if>
			<c:if test="${park.entryfee > 0}">
				<li>Entry fee: $${park.entryfee}.00</li>
			</c:if>
			<li>${park.acreage} sq acres</li>
			<li>${park.elevationinfeet}ft elevation</li>
			<li>${park.milesoftrail}miles of trails</li>

			<c:if test="${park.numberofcampsites > 0}">
				<li>Number of campsites: ${park.numberofcampsites}</li>
			</c:if>

			<li>Climate: ${park.climate}</li>
			<li>Annual visitor count: ${park.annualvisitorcount}</li>
			<li>${park.numberofanimalspecies}different animal species</li>
			<li>${park.inspirationalquote}</li>
			<li>-${park.inspirationalquotesource}</li>

		</ul>
	</div>
	<c:url var="tempURL" value="/tempConversion" />

	<form action=${tempURL} method="POST">
<label for="temp">Choose Fahrenheit or Celsius:</label>

<select name="temp">
<option value="" disabled selected>Select</option>
<option value="Farhenheit">Fahrenheit</option>
<option value="Celsius">Celsius</option>
</select>

<input name="temp" type="hidden" value="${temp}"/>
<input type="submit"/>
</form>

	<div class="table">
		<tr>
			<div class="columns">
				<c:forEach var="weather" items="${weather}">
					<div class="column">
						<img id="weather-img"
							src="img/weather/${weather.forecastImage}.png"/>

						<li>${weather.forecast}</li>
						<li>${weather.high}degrees</li>
						<li>${weather.low}degrees</li>
						<c:if test="${weather.parkAdvice == false}">
							<li>${weather.parkAdvice}</li>
						</c:if>
						<c:if test="${weather.parkTempAdvice == false}">
							<li>${weather.parkTempAdvice}</li>
						</c:if>
					</div>

				</c:forEach>
			</div>
		</tr>

	</div>

	<c:forEach var="weather" items="${weather}">
		<tr>
			<td>${weather.fiveDayForecastValue}</td>
			<c:choose>
				<c:when test='${temp eq "Celsius"}'>
					<td>${temp}</td>
					<td>${weather.highInC}</td>
				</c:when>
				<c:when test='${temp eq "Fahrenheit"}'>
					<td>${temp}</td>
					<td>${weather.high}</td>
				</c:when>
			</c:choose>
			<td>${weather.forecast}<img height=20px width=20px
				src="<c:url value="/img/weather/${weather.forecast}.png"/>"/>
			</td>
		</tr>
	</c:forEach>

</body>
</html>