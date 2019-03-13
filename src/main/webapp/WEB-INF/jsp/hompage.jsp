<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<h1>National Park Geek</h1>
<c:forEach var="park" items="${parkList}">
	<ul>
				<div class="container-wrapper">
				
					<div class="img-container">
					<img id="park-img" src="<c:url value="img/${park.imageName}"/>"/>
					</div>
					
				<div class="product-text-container">
				<li class="bold">${park.parkName}</li>
				<li>${park.state}</li>
				 <li class="price ">${park.description}</li>
				 </div>
	</div>
</ul>
</c:forEach>
</body>
</html>