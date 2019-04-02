<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp" />


<title>Park Details</title>
</head>
<body>
<div class="container is-fluid">
<div class="content is-large">
<h1>${park.parkname}</h1>

        <div class="notification">
        
        <p>${park.inspirationalquote}</p>
        <p> -${park.inspirationalquotesource}</p>
</div>
</div>
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
			<li>${park.elevationinfeet} ft elevation</li>
			<li>${park.milesoftrail} miles of trails</li>

			<c:if test="${park.numberofcampsites > 0}">
				<li>Number of campsites: ${park.numberofcampsites}</li>
			</c:if>

			<li>Climate: ${park.climate}</li>
			<li>Annual visitor count: ${park.annualvisitorcount}</li>
			<li>${park.numberofanimalspecies} different animal species</li>
			
			

		</ul>
	</div>
	
 		
 



	<div class="table">

		<tr>

			<div class="columns">
				<c:forEach var="weather" items="${weather}">
				<div class="column">
				<img id="weather-img" src="img/weather/${weather.forecastImage}.png"/>
					
						
							
						<li>${weather.forecast}</li>
						<c:if test='${temp eq "false"}'>
							<li>${weather.highInC} degrees</li>
							<li>${weather.lowInC} degrees</li>
						</c:if>	
						<c:if test='${temp eq "true"}'>
							<li>${weather.high} degrees</li>
							<li>${weather.low} degrees</li>
						</c:if>	
						
						<c:if test='${temp eq null}'>
							<li>${weather.high} degrees</li>
							<li>${weather.low} degrees</li>
						</c:if>	
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

</body>
</html>