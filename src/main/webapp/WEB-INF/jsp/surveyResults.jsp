<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/header.jsp" />

<html>
<head>
<meta charset="UTF-8">
<title>Survey Results</title>
</head>
<body>
	<h1>Favorite Parks:</h1>

	<c:if test="${thankYou}">
		<p>Thank you for your survey</p>
	</c:if>

	<c:forEach var="theSurvey" items="${dailySurvey}">
		<ul>
			<img id="park-img" src="img/parks/${theSurvey.parkcode}.jpg" />
			<li>${theSurvey.parkname}</li>
			<li>${theSurvey.count} Votes</li>
		</ul>
	</c:forEach>

</body>
</html>