<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/header.jsp"/>
    <%--<c:param name="pageTitle" value="Product List" />--%>




<c:forEach var="parks" items="${parks}">

<c:url var="parkDetails" value="/parkDetails"> 
				<c:param name="parkcode">${parks.parkcode}</c:param>
			</c:url> 	
	<ul>
				<div class="container-wrapper">
				
					<div class="img-container">
				<img id="park-img" src="img/parks/${parks.parkcode}.jpg"/>  
					</div>
					
				<div class="park-text-container">
				
				<li><a href="${parkDetails}">${parks.parkname}</a></li>
				<li>${parks.state}</li>
				 <li class="price ">${parks.parkdescription}</li>
				 </div>
	</div>
</ul>
</c:forEach>


</body>
</html>