<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/header.jsp"/>
    <%--<c:param name="pageTitle" value="Product List" />--%>

<c:forEach var="parks" items="${parks}">
<nav class="level">



<c:url var="parkDetails" value="/parkDetails"> 
				<c:param name="parkcode">${parks.parkcode}</c:param>
			</c:url> 	
	<div class="level-left">
				
				<img id="park-img" src="img/parks/${parks.parkcode}.jpg"/>  
					
	</div>				
				
	<div class="level-right">

    		
      			
     			
				<p class="heading">><a href="${parkDetails}">${parks.parkname}</a></p>
				
				
				<textarea class="textarea">${parks.parkdescription}</textarea>
				
	</div>


</nav>
</c:forEach>
</body>
</html>