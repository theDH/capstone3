<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp"/>


<title>Park Details</title>
</head>
<body>
<h1>Park Details</h1>
<ul>
<li>${park.parkdescription}</li>
<c:forEach var="weather" items="${weather}">
<li>${weather.forecast}</li>
</c:forEach>



</ul>
</body>
</html>